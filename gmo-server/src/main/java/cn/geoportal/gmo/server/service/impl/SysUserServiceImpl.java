package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.entity.vo.sysuser.SysUserReg;
import cn.geoportal.gmo.server.utils.SysUserUtils;
import cn.geoportal.gmo.server.config.security.JwtTokenUtil;
import cn.geoportal.gmo.server.entity.SysRole;
import cn.geoportal.gmo.server.entity.SysUserRole;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.mapper.SysRoleMapper;
import cn.geoportal.gmo.server.mapper.SysUserRoleMapper;
import cn.geoportal.gmo.server.mapper.SysUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * ??????????????????token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        //System.out.println(code);
        // ???????????????
        String captcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //System.out.println(captcha);
        if ((code == null && code.length() == 0) || !code.equalsIgnoreCase(captcha)) {
            return RespBean.error("??????????????????????????????????????????");
        }
        // ??????
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return RespBean.error("???????????????????????????");
        }
        if (!userDetails.isEnabled()) {
            return RespBean.error("???????????????????????????????????????");
        }
        // ??????security??????????????????
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // ??????token
        String token = jwtTokenUitl.genegrateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("????????????", tokenMap);
    }

    /**
     * ?????????????????????????????????
     * @param username
     * @return
     */
    @Override
    public SysUser getUserByUserName(String username) {
        return sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("username", username)
                .eq("enabled", true));
    }

    /**
     * ????????????id????????????
     * @param userId
     * @return
     */
    @Override
    public List<SysRole> getRoles(Long userId) {
        return sysRoleMapper.getRoles(userId);
    }


    /**
     * ?????????????????????
     * @param page
     * @param wrapper
     * @return
     */
    @Override
    public IPage<Map> getSysUserList(Page<Map> page, QueryWrapper<SysUser> wrapper) {
        return sysUserMapper.getSysUserList(page, wrapper);
    }


    /**
     * ???????????????
     * @param sysUser
     * @return
     */
    @Override
    public int addSysUser(SysUserReg sysUser) {
        return sysUserMapper.addSysUser(sysUser.getUsername(), sysUser.getEmail(),
                passwordEncoder.encode(sysUser.getPassword()), sysUser.getName(), sysUser.getPhone(),
                sysUser.getNationId(), sysUser.getPoliticId(), sysUser.getJoblevelId(),
                sysUser.getPositionId(), sysUser.getDepartmentId());
    }

    /**
     * ?????????????????????
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
     * ?????????????????????
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
            return RespBean.success("???????????????????????????");
        }
        return RespBean.error("???????????????????????????");
    }

}




