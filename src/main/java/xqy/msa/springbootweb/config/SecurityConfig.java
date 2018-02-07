package xqy.msa.springbootweb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import xqy.msa.springbootweb.auth.service.UserService;
import xqy.msa.springbootweb.security.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
//	@Autowired
//	DataSource dataSource;
	
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery("select username,password, enabled from imk_users where username=?")
//				.authoritiesByUsernameQuery("select username, role from imk_userrole where username=?");
//	}

	@Autowired
	private UserService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService())
				.passwordEncoder(passwordEncoder());
	}
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService(userService);
	}
	
	@Override
  	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
				.antMatcher("/api/**")
				.authorizeRequests()
				//.antMatchers("/api/**").denyAll()
				//.antMatchers("/api/**").hasAnyRole("USER")
				.antMatchers("/api/my/{username}").access("@authz.check(#username,pricipal)")
				.antMatchers("/api/auth/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.httpBasic();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("**/*.html","**/js/**","**/vendor/**","**/lib/**","**/css/**","**/styles/**","**/images/**","**/fonts/**", "**/**/favicon.ico");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		// 加密后60长度字符串
		return new BCryptPasswordEncoder();
	}
}
