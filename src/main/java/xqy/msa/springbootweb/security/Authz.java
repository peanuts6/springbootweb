package xqy.msa.springbootweb.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * Created by xqy on 17/12/29.
 */
@Component
public class Authz {
    public boolean check(String username, User user) {
        return username.equals(user.getUsername());
    }
}
