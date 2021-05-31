package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity cn.geoportal.gmo.server.entity.SysRole
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 根据用户id查询角色列表
     * @param userId
     * @return
     */
    List<SysRole> getRoles(Integer userId);
}




