package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.SysMenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity cn.geoportal.gmo.server.entity.SysMenuRole
 */
public interface SysMenuRoleMapper extends BaseMapper<SysMenuRole> {
    /**
     * 根据角色菜单
     * @param rid
     * @param mids
     * @return
     */
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}




