package xqy.temp;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xqy on 17/12/29.
 */
@Component
public class MyAuthenticationSuccessHandler2 extends SavedRequestAwareAuthenticationSuccessHandler
{
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        if( !(authentication instanceof MyAuthenticationToken2) ) {
            return;
        }

        MyAuthenticationToken2 jwtAuthenticaton =    (MyAuthenticationToken2) authentication;

        // Add a session cookie
        Cookie sessionCookie = new Cookie( "SESSIONID", jwtAuthenticaton.getToken() );
        response.addCookie( sessionCookie );

        //clearAuthenticationAttributes(request);

        // call the original impl
        super.onAuthenticationSuccess( request, response, authentication );
    }
}
