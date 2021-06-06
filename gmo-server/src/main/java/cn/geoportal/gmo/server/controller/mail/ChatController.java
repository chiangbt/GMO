package cn.geoportal.gmo.server.controller.mail;

import cn.geoportal.gmo.server.config.RabbitMqConfig;
import cn.geoportal.gmo.server.entity.mail.MailMessage;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

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

    /**
     * 发送消息
     *
     * @param msg 消息内容
     * @return
     */
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

    @RequestMapping(value = "/send/mail", method = RequestMethod.POST)
    public boolean send2(@RequestBody MailMessage msg) {
        try {
            MailMessage emailSend = new MailMessage("a", "b", "c", LocalDateTime.now());

            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.BINDING_KEY_2, emailSend);
        } catch (AmqpException e) {
            log.error("发送消息2异常：{}", e);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    //对象转化为字节码
    private  byte[] getBytesFromObject(Serializable obj) throws Exception {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        return bo.toByteArray();
    }
}
