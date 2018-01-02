package xqy.msa.springbootweb.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import xqy.msa.springbootweb.auth.domain.User;
import xqy.msa.springbootweb.auth.service.UserService;

/**
 * Created by xqy on 18/1/2.
 */
@Component
public class MyUserDetailsService implements UserDetailsService
{
    private final UserService userService;

    public MyUserDetailsService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.loadUserByName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户"+username+"不存在");
        }
        return new MyUserDetails(user);
    }
}
