package xqy.msa.springbootweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import xqy.temp.MyAuthenticationFilter2;
import xqy.temp.MyAuthenticationSuccessHandler2;

/**
 * Created by xqy on 17/12/29.
 */
public class SecurityConfig2 extends WebSecurityConfigurerAdapter
{
    @Autowired
    MyAuthenticationFilter2 apiAuthProvider;

    @Autowired
    MyAuthenticationSuccessHandler2 authSuccessHandler;

    @Autowired
    SimpleUrlAuthenticationFailureHandler authFailureHandler;

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth.authenticationProvider((AuthenticationProvider) apiAuthProvider);
    }


    @Override
    protected void configure( HttpSecurity httpSecurity ) throws Exception {

        httpSecurity

                // don't create session
                .sessionManagement()
                .sessionCreationPolicy( SessionCreationPolicy.STATELESS )
                .and()

                .authorizeRequests()
                .antMatchers( "/", "/login", "/register" ).permitAll()
                .antMatchers( "/js/**", "/css/**", "/img/**" ).permitAll()
                .anyRequest().authenticated()
                .and()

                // login
                .formLogin()
                .failureHandler( authFailureHandler )
                //.failureUrl( "/login" )
                .loginPage("/login")
                .successHandler( authSuccessHandler )
                .and()

                // JWT cookie filter
                .addFilterAfter( getCookieAuthenticationFilter(
                        new AndRequestMatcher( new AntPathRequestMatcher( "/account" ) )
                ) , UsernamePasswordAuthenticationFilter.class );
    }


    @Bean
    SimpleUrlAuthenticationFailureHandler getAuthFailureHandler() {

        SimpleUrlAuthenticationFailureHandler handler = new SimpleUrlAuthenticationFailureHandler( "/login" );
        handler.setDefaultFailureUrl( "/login" );
        //handler.setUseForward( true );

        return handler;

    }

    MyAuthenticationFilter2 getCookieAuthenticationFilter( RequestMatcher requestMatcher ) {

        MyAuthenticationFilter2 filter = new MyAuthenticationFilter2( requestMatcher );
        filter.setAuthenticationFailureHandler( authFailureHandler );
        return filter;
    }
}
