package xqy.msa.springbootweb.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xqy.msa.springbootweb.auth.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by xqy on 18/1/2.
 */
public class MyUserDetails implements UserDetails{
    private final User user;
    private final Collection<GrantedAuthority> authorities;

    public MyUserDetails(User user){
        this.user = user;
        this.authorities = new ArrayList<>();
        this.authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        this.authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(
//                user.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.joining(", ")));
//        this.authorities = this.getAuthorities();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
