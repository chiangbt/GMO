package cn.geoportal.gmo.server.security.filter;

import cn.geoportal.gmo.server.entity.SysMenu;
import cn.geoportal.gmo.server.service.SysMenuService;
import cn.geoportal.gmo.server.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.security.filter
 * @ClassName: CustomerFilter
 * @Author: chiangbt@geoportal.cn
 * @Description: 权限控制 根据请求url分析角色的过滤器
 * @Date: 2021/5/31 14:28
 */
@Component
public class CustomerFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private SysMenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        // 获取请求的rul
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        // 获取所有的菜单-角色
        List<SysMenu> menus = menuService.getMenusWithRole();
        for (SysMenu menu : menus) {
            // 判断请求url与角色是否相配
            if(antPathMatcher.match(menu.getUrl(), requestUrl)){
                // 将SysMenu对象的role取出名称进行匹配
                String[] str = menu.getRoles().stream().map(SysRole::getName).toArray(String[]::new);
                System.out.println("url:" + requestUrl + " 权限 ------------- " + SecurityConfig.createList(str));
                return SecurityConfig.createList(str);
            }
        }
        // 没匹配的url默认登录即可访问
        return SecurityConfig.createList("ROLE_LOGIN");
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
