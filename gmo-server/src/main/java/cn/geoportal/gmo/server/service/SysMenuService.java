package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysMenu;
import cn.geoportal.gmo.server.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 根据用户id查询菜单列表
     *
     * @return
     */
    List<SysMenu> getMenusByUserId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<SysMenu> getMenusWithRole();
}
