package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysMenuRole;
import cn.geoportal.gmo.server.entity.common.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SysMenuRoleService extends IService<SysMenuRole> {
    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
