package xqy.temp;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;

/**
 * Created by xqy on 17/12/29.
 * 获取角色与url资源的所有对应关系，并根据url查询对应的所有角色
 */
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource
{
    //将所有的角色和url的对应关系缓存起来
//    private static List<RoleUrlResource> rus = null;

    //tomcat启动时实例化一次
    public MyInvocationSecurityMetadataSource() {

    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
