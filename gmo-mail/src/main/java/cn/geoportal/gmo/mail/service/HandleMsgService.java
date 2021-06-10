package cn.geoportal.gmo.mail.service;

import cn.geoportal.gmo.mail.entity.MailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;


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
    @Value("${spring.mail.username}")
    private String emailFrom;

    @RabbitListener(queues = "test1.queue")
    public void handle1(String msg) {
        log.info("方法1已接收到消息：{}", msg);
    }

    @RabbitListener(queues = "mail.queue")
    public void handle2(MailMessage emailSend) throws Exception {
        System.out.println("Mail Message : " + emailSend.getContent());

        MimeMessage message = emailSender.createMimeMessage();
        // 邮件设置
        //true表示需要创建一个multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(emailFrom);
        // 抄送给自己，避免被163屏蔽
        helper.addCc("chiangbt@163.com");
        helper.setTo(emailSend.getTo());//邮件接收者
        helper.setSubject("Geoportal信息通知");//邮件主题
        helper.setText(emailSend.getContent(), true);//邮件内容
        // 发送邮件
        emailSender.send(message);
    }

}
