package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysMenu;
import cn.geoportal.gmo.server.entity.SysUser;
import cn.geoportal.gmo.server.entity.common.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 用户登录返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public SysUser getUserByUserName(String username);

}
