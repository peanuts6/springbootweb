package xqy.msa.springbootweb.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private Integer id;

    private String username;

    private String password;

    private String enabled;

    private String remember;

    private String qq;

    private String email;

    private String website;

    private String weixin;

    private Collection<GrantedAuthority> authorities;
}