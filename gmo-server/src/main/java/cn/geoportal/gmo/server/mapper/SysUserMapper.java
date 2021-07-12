package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.Customer;
import cn.geoportal.gmo.server.entity.SysUser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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

    /**
     * 2、分页式获取操作员
     * @param page
     * @param wrapper
     * @return
     */
    IPage<Map> getSysUserList(Page<Map> page, @Param(Constants.WRAPPER) QueryWrapper<SysUser> wrapper);

    /**
     * 3、添加操作员
     * @param username
     * @param email
     * @param password
     * @param name
     * @param nationId
     * @param politicId
     * @return
     */
    @Select("INSERT INTO t_sys_user(username,email,password,name,phone,nationId,politicId) values(#{username},#{email},#{password},#{name},#{phone},#{nationId},#{politicId}) RETURNING id")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int addSysUser(String username, String email, String password, String name, String phone, Integer nationId, Integer politicId);
}




