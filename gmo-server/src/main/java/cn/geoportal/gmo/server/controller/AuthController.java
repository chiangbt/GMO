package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.SysUser;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.entity.vo.UserLogin;
import cn.geoportal.gmo.server.service.SysUserService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: AuthController
 * @Author: chiangbt@geoportal.cn
 * @Description: 登录相关
 * @Date: 2021/5/31 10:12
 */
@RestController
@Api(tags = "权限模块")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    /**
     * 用户登录并返回token
     * @param userLogin
     * @param request
     * @return
     */
    @ApiOperation(value = "登录返回token")
    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public RespBean login(@RequestBody UserLogin userLogin, HttpServletRequest request){
        // token在login函数中生成
        return sysUserService.login(userLogin.getUsername(), userLogin.getPassword(), userLogin.getKaptcha(), request);
    }


    @ApiOperation("获取当前登录用户的信息")
    @GetMapping("/user/info")
    public SysUser getUserInfo() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        if(null == userDetails) {
            return null;
        }
        String username = userDetails.getUsername();
        SysUser sysUser = sysUserService.getUserByUserName(username);
        sysUser.setPassword(null);
        sysUser.setRoles(sysUserService.getRoles(sysUser.getId()));
        return sysUser;
    }


    /**
     * 返回成功即可，具体实现在前端进行，因为使用token，退出时在前端把tokenHead删除就行了
     * @return
     */
    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public RespBean logout() {
        return RespBean.success("注销成功！");
    }


    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "获取验证码")
    @GetMapping(value = "/captcha", produces = "image/jpeg")
    public void getKaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置响应头
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String text = defaultKaptcha.createText();
        HttpSession session = request.getSession();
        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        //创建验证码图片
        BufferedImage image = defaultKaptcha.createImage(text);
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image, "jpg", os);
        IOUtils.closeQuietly(os);
    }
}
