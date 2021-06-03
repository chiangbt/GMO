package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity cn.geoportal.gmo.server.entity.SysUser
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 1、获取所有登录操作员
     * @param id
     * @param keywords
     * @return
     */
    List<SysUser> getAllSysUser(@Param("id")Long id, @Param("keywords") String keywords);
}




