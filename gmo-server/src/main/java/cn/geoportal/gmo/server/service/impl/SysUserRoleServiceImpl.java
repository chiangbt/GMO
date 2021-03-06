package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.mapper.SysUserRoleMapper;
import cn.geoportal.gmo.server.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.geoportal.gmo.server.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService{

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int addUserRole(SysUserRole sysUserRole) {
        return sysUserRoleMapper.insert(sysUserRole);
    }
}




