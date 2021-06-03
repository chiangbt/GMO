package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.mapper.SysMenuRoleMapper;
import cn.geoportal.gmo.server.entity.common.RespBean;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.geoportal.gmo.server.entity.SysMenuRole;
import cn.geoportal.gmo.server.service.SysMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
public class SysMenuRoleServiceImpl extends ServiceImpl<SysMenuRoleMapper, SysMenuRole> implements SysMenuRoleService{

    @Autowired
    private SysMenuRoleMapper sysMenuRoleMapper;

    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
//        System.out.println(mids);
        sysMenuRoleMapper.delete(new QueryWrapper<SysMenuRole>().eq("role_id", rid));
        if (null == mids || 0 == mids.length) {
            return RespBean.success("更新成功！");
        }
        // 批量更新
        Integer result = sysMenuRoleMapper.insertRecord(rid, mids);
        if (result == mids.length) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}




