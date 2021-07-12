package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SysUserRoleService extends IService<SysUserRole> {
    /**
     * 1、添加User_Role关系
     * @param sysUserRole
     * @return
     */
    int addUserRole(SysUserRole sysUserRole);
}
