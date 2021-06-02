package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity cn.geoportal.gmo.server.entity.SysUserRole
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    Integer updateSysUserRole(@Param("userId") Integer userId, @Param("rids") Integer[] rids);
}




