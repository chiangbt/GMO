package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity cn.geoportal.gmo.server.entity.SysRole
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 1、根据用户id查询角色列表
     * @param userId
     * @return
     */
    List<SysRole> getRoles(Long userId);

    /**
     * 2、获取非Admin外的所有角色列表
     * @return
     */
    List<SysRole> getRoleListNoAdmin();

    /**
     * 3、添加角色
     * @param name
     * @param namezh
     * @return
     */
    @Select("INSERT INTO t_sys_role(name, namezh) values(#{name},#{namezh}) RETURNING id")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int addJoblevel(String name, String namezh);
}




