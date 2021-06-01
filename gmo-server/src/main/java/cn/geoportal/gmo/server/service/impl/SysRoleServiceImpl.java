package cn.geoportal.gmo.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.geoportal.gmo.server.entity.SysRole;
import cn.geoportal.gmo.server.service.SysRoleService;
import cn.geoportal.gmo.server.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public int addRole(SysRole sysRole) {
        return sysRoleMapper.addJoblevel(sysRole.getName(), sysRole.getNamezh());
    }

    @Override
    public int updateRole(SysRole sysRole) {
        return sysRoleMapper.updateById(sysRole);
    }

    @Override
    public SysRole findRoleById(Integer id) {
        return sysRoleMapper.selectById(id);
    }

    @Override
    public int deleteRole(Integer id) {
        return sysRoleMapper.deleteById(id);
    }
}




