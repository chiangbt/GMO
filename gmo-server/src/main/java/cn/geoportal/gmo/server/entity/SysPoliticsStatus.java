package cn.geoportal.gmo.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 政治面貌表
 * @TableName t_sys_politics_status
 */
@TableName(value ="t_sys_politics_status")
@Data
public class SysPoliticsStatus implements Serializable {
    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 政治面貌
     */
    private String name;

    /**
     *
     */
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}