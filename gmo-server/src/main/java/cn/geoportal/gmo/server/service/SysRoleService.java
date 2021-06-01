package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     *
     * @param sysJoblevel
     * @return
     */
    int addRole(SysRole sysJoblevel);

    /**
     *
     * @param sysJoblevel
     * @return
     */
    int updateRole(SysRole sysJoblevel);

    /**
     *
     * @param id
     * @return
     */
    SysRole findRoleById(Integer id);

    /**
     *
     * @param id
     * @return
     */
    int deleteRole(Integer id);
}
