package cn.geoportal.gmo.server.security.filter;

import cn.geoportal.gmo.server.config.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.security.filter
 * @ClassName: JwtAuthencationTokenFilter
 * @Author: chiangbt@geoportal.cn
 * @Description: JWT登录授权过滤器
 * @Date: 2021/5/31 10:35
 */
public class JwtAuthencationTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtTokenUtil jwtTokenUitl;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取token进行前置拦截
        String authHeader = request.getHeader(tokenHeader);
        // 存在token
        if (null != authHeader && authHeader.startsWith(tokenHead)) {
            // 过滤Bearer
            String authToken = authHeader.substring(tokenHead.length());
            // 从token中获取用户名
            String username = jwtTokenUitl.getUserNameFromToken(authToken);
            // token存在用户名但未登录
            if (null != username && null == SecurityContextHolder.getContext().getAuthentication()) {
                // 登录
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (jwtTokenUitl.ValidateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
