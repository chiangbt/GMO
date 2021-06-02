package cn.geoportal.gmo.server.Utils;

import cn.geoportal.gmo.server.entity.SysUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.Utils
 * @ClassName: SysUserUtils
 * @Author: chiangbt@geoportal.cn
 * @Description: 用户工具模块
 * @Date: 2021/6/2 14:44
 */
public class SysUserUtils {

    /**
     * 1、获取当前登录用户
     * @return
     */
    public static SysUser getCurrentSysUser(){
        return (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
