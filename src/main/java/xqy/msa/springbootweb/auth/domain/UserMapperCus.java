package xqy.msa.springbootweb.auth.domain;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UserMapperCus {
	User selectByName(String username);

	public Collection<GrantedAuthority> selectRoles(String username);
}
