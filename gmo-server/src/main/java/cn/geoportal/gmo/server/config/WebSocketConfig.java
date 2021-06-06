package cn.geoportal.gmo.server.config;

import cn.geoportal.gmo.server.config.security.JwtTokenUtil;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.config
 * @ClassName: WebSocketConfig
 * @Author: chiangbt@geoportal.cn
 * @Description: WebSocket配置类
 * @Date: 2021/6/6 11:46
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 配置代理域，前缀为/queue
        config.enableSimpleBroker("/queue");
    }

    /**
     * 添加endpoint，这样网页可以通过websocket连接上去
     * 配置wbsocket的服务地址，并且可以指定socketJS是否使用
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /**
         * 1. 用户可以使用/ws/ep来访问
         * 2. 允许跨域
         * 3. 允许使用socketjs
         */
        registry.addEndpoint("/ws/ep").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration){
        registration.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                // 判断是否为连接，如果是则需要token并设置用户对象
                if(StompCommand.CONNECT.equals(accessor.getCommand())){
                    String token = accessor.getFirstNativeHeader("Auth-Token");
                    if(!StringUtils.isEmpty(token)){
                        String authToken = token.substring(tokenHead.length());
                        String username = jwtTokenUtil.getUserNameFromToken(authToken);
                        // token中存在用户名
                        if(!StringUtils.isEmpty(username)){
                            // 登录
                            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                            // 验证token是否有效
                            if(jwtTokenUtil.ValidateToken(authToken, userDetails)){
                                UsernamePasswordAuthenticationToken authenticationToken =
                                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                            }
                        }
                    }
                }
                return message;
            }
        });
    }
}
