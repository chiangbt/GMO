package cn.geoportal.gmo.server.entity.mail;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.entity.mail
 * @ClassName: ChatMsg
 * @Author: chiangbt@geoportal.cn
 * @Description: 在线聊天
 * @Date: 2021/6/6 12:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ChatMsg {

    private String from;
    private String to;
    private String content;
    private LocalDateTime date;
    private String fromNickName;
}
