package cn.geoportal.gmo.mail.service;

import cn.geoportal.gmo.mail.entity.MailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.mail.service
 * @ClassName: HandleMsgService
 * @Author: chiangbt@geoportal.cn
 * @Description: 消息接收服务
 * @Date: 2021/6/6 12:35
 */
@Component
public class HandleMsgService {

    private static Logger log = LoggerFactory.getLogger(HandleMsgService.class);

    @Autowired
    private JavaMailSender emailSender;

    @RabbitListener(queues = "test1.queue")
    public void handle1(String msg) {
        log.info("方法1已接收到消息：{}", msg);
    }

    @RabbitListener(queues = "mail.queue")
    public void handle2(MailMessage emailSend) throws Exception {
        System.out.println("Mail Message : " + emailSend.getContent());
        // 邮件设置
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("chiangbt@163.com");
        message.setTo(emailSend.getTo());
        message.setSubject("邮件通知");
        message.setText(emailSend.getContent());
        // 发送邮件
        emailSender.send(message);
    }

}
