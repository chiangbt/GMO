package cn.geoportal.gmo.server.controller.mail;

import cn.geoportal.gmo.server.entity.SysUser;
import cn.geoportal.gmo.server.entity.mail.ChatMsg;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller.mail
 * @ClassName: WsController
 * @Author: chiangbt@geoportal.cn
 * @Description: Websocket
 * @Date: 2021/6/6 12:09
 */
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authorization, ChatMsg chatMsg){
        SysUser sysUser = (SysUser)authorization.getPrincipal();
        chatMsg.setFrom(sysUser.getUsername());
        chatMsg.setFromNickName(sysUser.getUsername());
        chatMsg.setDate(LocalDateTime.now());
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(), "/queue/chat", chatMsg);
    }
}
