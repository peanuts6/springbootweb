package xqy.temp;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by xqy on 17/12/29.
 */
public class MyAuthenticationProvider2 implements AuthenticationProvider
{
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // perform API call to auth against a 3rd party

        // get User data
//        User user = new User();

        // return Authentication
        //return new UsernamePasswordAuthenticationToken( username, password, new ArrayList<>() );
        return null;

        // create a JWT token
//        String jwtToken = "some-token-123";
//        return new JWTAuthenticationToken( jwtToken, user, new ArrayList<>() );
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals( UsernamePasswordAuthenticationToken.class );
    }
}
