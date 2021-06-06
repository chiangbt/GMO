package cn.geoportal.gmo.server.entity.mail;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.entity.mail
 * @ClassName: MailMessage
 * @Author: chiangbt@geoportal.cn
 * @Description: MailMessage
 * @Date: 2021/6/6 15:33
 */
@Data
@AllArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = MailMessage.class)
public class MailMessage {

    private String from;

    private String to;

    private String content;

    private LocalDateTime dt;
}
