package xqy.msa.springbootweb.auth.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.stereotype.Component;
import xqy.msa.springbootweb.auth.domain.User;
import xqy.msa.springbootweb.auth.domain.UserMapperCus;

/**
 * Created by xqy on 17/12/29.
 */
@Component
public class UserService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMapperCus userMapperCus;

    public UserService(){
        LOGGER.debug("=========== USER SERVICE ==========");
    }

    public User loadUserByName(String username){
        User user = userMapperCus.selectByName(username);
//        user.setAuthorities(getUserAuthority(username));
        return user;
    }
    
    public Collection<GrantedAuthority> getUserAuthority(String username){
    	return userMapperCus.selectRoles(username);
//        return null;
    }

}
