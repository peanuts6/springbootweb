package xqy.temp;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xqy on 17/12/29.
 */
public class MyAuthenticationFilter2 extends AbstractAuthenticationProcessingFilter
{
    public MyAuthenticationFilter2( RequestMatcher requestMatcher ) {

        super( requestMatcher );
        setAuthenticationManager( super.getAuthenticationManager() );

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String token = "";

        // get token from a Cookie
        Cookie[] cookies = httpServletRequest.getCookies();

        if( cookies == null || cookies.length < 1 ) {
            throw new AuthenticationServiceException( "Invalid Token" );
        }

        Cookie sessionCookie = null;
        for( Cookie cookie : cookies ) {
            if( ( "someSessionId" ).equals( cookie.getName() ) ) {
                sessionCookie = cookie;
                break;
            }
        }

        // TODO: move the cookie validation into a private method
        if( sessionCookie == null || StringUtils.isEmpty( sessionCookie.getValue() ) ) {
            throw new AuthenticationServiceException( "Invalid Token" );
        }

        MyAuthenticationToken2 jwtAuthentication = new MyAuthenticationToken2( sessionCookie.getValue(), null, null );

        return jwtAuthentication;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }
}
