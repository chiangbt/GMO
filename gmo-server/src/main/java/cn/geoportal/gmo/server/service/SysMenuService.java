package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 1、根据用户id查询菜单列表
     *
     * @return
     */
    List<SysMenu> getMenusByUserId();

    /**
     * 2、根据角色获取菜单列表
     * @return
     */
    List<SysMenu> getMenusWithRole();

    /**
     * 3、查询所有菜单
     * @return
     */
    List<SysMenu> getAllMenus();

    /**
     * 4、查询menu
     * @param id
     * @return
     */
    SysMenu findMenuById(Integer id);

    /**
     * 5、更新menu
     * @param sysMenu
     * @return
     */
    int UpdateMenuById(SysMenu sysMenu);
}
