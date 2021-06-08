package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.entity.SysMenu;
import cn.geoportal.gmo.server.mapper.SysMenuMapper;
import cn.geoportal.gmo.server.service.SysMenuService;
import cn.geoportal.gmo.server.utils.SysUserUtils;
import cn.geoportal.gmo.server.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据用户id查询菜单列表
     * @return
     */
    @Override
    public List<SysMenu> getMenusByUserId() {
        // 获取用户id
        Long userId = SysUserUtils.getCurrentSysUser().getId();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        // 从redis获取菜单数据
        List<SysMenu> menus = (List<SysMenu>) valueOperations.get("menu_" + userId);
        // 如果为空，去数据库获取
        if (CollectionUtils.isEmpty(menus)) {
            menus = sysMenuMapper.getMenusByUserId(userId);
            valueOperations.set("menu_"+userId, menus);
        }
        return menus;
    }

    /**
     * 根据角色获取菜单列表
     * @return
     */
    @Override
    public List<SysMenu> getMenusWithRole() {
        return sysMenuMapper.getMenusWithRole();
    }

    @Override
    public List<SysMenu> getAllMenus() {
        return sysMenuMapper.getAllMenus();
    }

    @Override
    public SysMenu findMenuById(Integer id) {
        return sysMenuMapper.selectById(id);
    }

    @Override
    public int UpdateMenuById(SysMenu sysMenu) {
        Long userId = SysUserUtils.getCurrentSysUser().getId();
        redisTemplate.delete("menu_" + userId);

        return sysMenuMapper.updateById(sysMenu);
    }
}




