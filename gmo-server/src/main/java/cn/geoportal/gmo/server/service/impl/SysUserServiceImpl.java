package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.utils.SysUserUtils;
import cn.geoportal.gmo.server.config.security.JwtTokenUtil;
import cn.geoportal.gmo.server.entity.SysRole;
import cn.geoportal.gmo.server.entity.SysUserRole;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.mapper.SysRoleMapper;
import cn.geoportal.gmo.server.mapper.SysUserRoleMapper;
import cn.geoportal.gmo.server.mapper.SysUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.geoportal.gmo.server.entity.SysUser;
import cn.geoportal.gmo.server.service.SysUserService;
import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUitl;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 用户登录返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        System.out.println(code);
        // 校验验证码
        String captcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println(captcha);
        if ((code == null && code.length() == 0) || !code.equalsIgnoreCase(captcha)) {
            return RespBean.error("验证码输入错误，请重新输入！");
        }
        // 登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return RespBean.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()) {
            return RespBean.error("账号被禁用，请联系管理员！");
        }
        // 更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 生成token
        String token = jwtTokenUitl.genegrateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("登录成功", tokenMap);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Override
    public SysUser getUserByUserName(String username) {
        return sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("username", username)
                .eq("enabled", true));
    }

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    @Override
    public List<SysRole> getRoles(Long userId) {
        return sysRoleMapper.getRoles(userId);
    }

    /**
     * 获取操作员用户
     * @param keywords
     * @return
     */
    @Override
    public List<SysUser> getAllSysUser(String keywords) {
        return sysUserMapper.getAllSysUser(
                SysUserUtils.getCurrentSysUser().getId(),
                keywords
        );
    }

    /**
     * 更新操作员用户
     * @param sysUser
     * @return
     */
    @Override
    public int updateSysUser(SysUser sysUser) {
        System.out.println(sysUser.getId());
        System.out.println(sysUser.getPhone());

        return sysUserMapper.updateById(sysUser);
    }

    @Override
    public int deleteCustomer(Integer id) {
        return sysUserMapper.deleteById(id);
    }

    /**
     * 更新操作员角色
     * @param userId
     * @param rids
     * @return
     */
    @Override
    @Transactional
    public RespBean updateSysUserRole(Integer userId, Integer[] rids) {
        sysUserRoleMapper.delete(new QueryWrapper<SysUserRole>().eq("user_id", userId));
        Integer result =  sysUserRoleMapper.updateSysUserRole(userId, rids);
        if(rids.length == result){
            return RespBean.success("更新操作员角色成功");
        }
        return RespBean.error("更新操作员角色失败");
    }

}




