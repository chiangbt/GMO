package cn.geoportal.gmo.mail.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.mail.entity
 * @ClassName: MailMessage
 * @Author: chiangbt@geoportal.cn
 * @Description: MailMessage
 * @Date: 2021/6/6 15:38
 */
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = MailMessage.class)
public class MailMessage implements Serializable {

    private String to;
    private String content;
    private String date;

    public MailMessage(){ }

    public MailMessage(String to, String content, String date){
        this.to = to;
        this.content = content;
        this.date = date;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
