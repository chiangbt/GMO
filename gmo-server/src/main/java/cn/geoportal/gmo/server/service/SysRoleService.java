package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 获取非Admin的所有角色
     * @return
     */
    List<SysRole> getRoleListNoAdmin();

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
