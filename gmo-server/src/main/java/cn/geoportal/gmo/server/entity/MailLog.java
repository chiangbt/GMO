package cn.geoportal.gmo.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 邮件日志表
 * @TableName t_mail_log
 */
@TableName(value ="t_mail_log")
@Data
public class MailLog implements Serializable {
    /**
     * ID
     */
    @TableId
    private Integer id;

    /**
     * 客户名
     */
    private String mailto;

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 数据新建时间
     */
    private Date createdat;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}