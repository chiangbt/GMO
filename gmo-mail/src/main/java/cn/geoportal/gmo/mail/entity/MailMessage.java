package cn.geoportal.gmo.mail.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.mail.entity
 * @ClassName: MailMessage
 * @Author: chiangbt@geoportal.cn
 * @Description: MailMessage
 * @Date: 2021/6/6 15:38
 */
@Data
public class MailMessage {
    private String from;

    private String to;

    private String content;

    private LocalDateTime dt;
}
