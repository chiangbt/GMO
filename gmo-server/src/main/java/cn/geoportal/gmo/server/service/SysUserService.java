package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.Customer;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.entity.SysUser;
import cn.geoportal.gmo.server.entity.SysRole;
import cn.geoportal.gmo.server.entity.vo.sysuser.SysUserReg;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 *
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 1、用户登录返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 2、根据用户名获取用户信息
     * @param username
     * @return
     */
    public SysUser getUserByUserName(String username);

    /**
     * 3、根据用户id查询角色
     * @param userId
     * @return
     */
    List<SysRole> getRoles(Long userId);

    /**
     * 4、获取操作员用户
     * @param keywords
     * @return
     */
    List<SysUser> getAllSysUser(String keywords);

    /**
     * 5、获取操作员分页
     * @param page
     * @param wrapper
     * @return
     */
    IPage<Map> getSysUserList(Page<Map> page, QueryWrapper<SysUser> wrapper);

    /**
     * 6、添加操作员
     * @param sysUser
     * @return
     */
    int addSysUser(SysUserReg sysUser);

    /**
     * 7、更新操作员用户
     * @param sysUser
     * @return
     */
    int updateSysUser(SysUser sysUser);

    /**
     * 8、删除指定的操作员用户
     * @param id
     * @return
     */
    int deleteCustomer(Integer id);

    /**
     * 9、更新操作员角色
     * @param userId
     * @param rids
     * @return
     */
    RespBean updateSysUserRole(Integer userId, Integer[] rids);
}
