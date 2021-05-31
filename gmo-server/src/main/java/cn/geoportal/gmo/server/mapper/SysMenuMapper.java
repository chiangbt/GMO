package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity cn.geoportal.gmo.server.entity.SysMenu
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据用户id获取菜单列表
     * @param id
     * @return
     */
    List<SysMenu> getMenusByUserId(Long id);
}




