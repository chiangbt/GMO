package cn.geoportal.gmo.server.config.security;

import cn.geoportal.gmo.server.entity.SysUser;
import cn.geoportal.gmo.server.security.filter.JwtAuthencationTokenFilter;
import cn.geoportal.gmo.server.security.handler.RestAuthorizationEntryPoint;
import cn.geoportal.gmo.server.security.handler.RestfulAccessDeniedHandler;
import cn.geoportal.gmo.server.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.config.security
 * @ClassName: SecurityConfig
 * @Author: chiangbt@geoportal.cn
 * @Description: Security配置类
 * @Date: 2021/5/31 10:28
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthorizationEntryPoint restAuthorizationEntryPoint;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers(
                "/api/auth/register",
                "/api/auth/login",
                "/api/auth/logout",
                "/api/auth/captcha",
                "/css/**",
                "/js/**",
                "index.html",
                "favicon.ico",
                "/druid/**",
                "/doc.html",
                "/webjars/**",
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/v2/api-docs/**",
                "/img/**",
                "/uploads/**"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // 使用jwt不需要csrf
        http.csrf().disable()
                // 基于token不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 允许登陆访问
//                .antMatchers("/druid/**").permitAll()       // 允许druid使用
//                .antMatchers("/doc.html").permitAll()       // 允许knife4j使用
//                .antMatchers("/webjars/**").permitAll()
//                .antMatchers("/swagger-ui/**").permitAll()
//                .antMatchers("/swagger-resources/**").permitAll()
//                .antMatchers("/v2/api-docs/**").permitAll()
//                .antMatchers("/api/**").permitAll()
//                .antMatchers("/").permitAll()   // 让resource/static中的vue app可以访问
//                .antMatchers("/js/**").permitAll()
//                .antMatchers("/css/**").permitAll()
//                .antMatchers("/img/**").permitAll()
//                .antMatchers("/uploads/**").permitAll()
//                .antMatchers("/favicon.ico").permitAll()
                // 除了上面的都需要认证
                .anyRequest().authenticated()
                .and()
                // 禁用缓存
                .headers()
                .cacheControl();
        // 添加jwt登录授权过滤器
        http.addFilterBefore(jwtAuthencationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        // 自定义未授权和未登录的结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthorizationEntryPoint);
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            SysUser sysUser = sysUserService.getUserByUserName(username);
            if (null != sysUser) {
//                sysUser.setRoles(sysUserService.getRoles(sysUser.getId()));
                return sysUser;
            }
            throw new UsernameNotFoundException("用户名密码不正确");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthencationTokenFilter jwtAuthencationTokenFilter() {
        return new JwtAuthencationTokenFilter();
    }
}
