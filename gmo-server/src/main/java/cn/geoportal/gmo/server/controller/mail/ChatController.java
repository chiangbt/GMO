package cn.geoportal.gmo.server.controller.mail;

import cn.geoportal.gmo.server.config.RabbitMqConfig;
import cn.geoportal.gmo.server.entity.MailLog;
import cn.geoportal.gmo.server.entity.mail.MailMessage;
import cn.geoportal.gmo.server.service.MailLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller.mail
 * @ClassName: ChatController
 * @Author: chiangbt@geoportal.cn
 * @Description: 在线聊天
 * @Date: 2021/6/6 12:14
 */
@Api(tags = "11.Websocket发送信息")
@RestController
public class ChatController {

    private static Logger log = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MailLogService mailLogService;

    /**
     * 发送消息
     *
     * @param msg 消息内容
     * @return
     */
    @ApiOperation(value = "发送消息")
    @RequestMapping(value = "/send/message", method = RequestMethod.GET)
    public boolean send(String msg) {
        try {
            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.BINDING_KEY_1, msg);
        } catch (AmqpException e) {
            log.error("发送消息1异常：{}", e);
            return false;
        }
        return true;
    }

    @ApiOperation(value = "发送邮件")
    @RequestMapping(value = "/send/mail", method = RequestMethod.POST)
    public boolean send2(@RequestBody MailMessage mailMessage) {
        try {
            MailMessage emailSend = new MailMessage(mailMessage.getTo(), mailMessage.getContent(), LocalDateTime.now().toString());

            // 保存到日志表
            MailLog mailLog = new MailLog();
            mailLog.setMailto(mailMessage.getTo());
            mailLog.setContent(mailMessage.getContent());
            mailLogService.save(mailLog);

            // 向RabbitMQ发送消息序列，以用于邮件发送
            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.BINDING_KEY_2, emailSend);
        } catch (AmqpException e) {
            log.error("发送消息2异常：{}", e);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
