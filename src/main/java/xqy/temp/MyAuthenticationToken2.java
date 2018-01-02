package xqy.temp;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by xqy on 17/12/29.
 */
@Component
public class MyAuthenticationToken2 extends AbstractAuthenticationToken
{
    User principal;
    String token;

    public MyAuthenticationToken2(String token, User principal, Collection<? extends GrantedAuthority> authorities )
    {
        super( authorities );
        this.token = token;
        this.principal = principal;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    public void setToken( String token ) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
