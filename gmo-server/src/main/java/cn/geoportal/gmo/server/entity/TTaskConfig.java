package cn.geoportal.gmo.server.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 定时任务表
 * @TableName t_task_config
 */
@TableName(value ="t_task_config")
@Data
public class TTaskConfig implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JSONField(ordinal = 0)
    @ApiModelProperty(value = "id", required = false, hidden = true)
    private Integer id;

    /**
     * 任务id
     */
    @TableField(value = "task_id")
    @JSONField(ordinal = 1)
    @ApiModelProperty(value = "任务id", required = true)
    private String taskId;

    /**
     * CRON表达式
     */
    @TableField(value = "cron")
    @JSONField(ordinal = 2)
    @ApiModelProperty(value = "CRON表达式", required = true)
    private String cron;

    /**
     * job引用地址
     */
    @TableField(value = "class_name")
    @JSONField(ordinal = 3)
    @ApiModelProperty(value = "job引用地址", required = true)
    private String className;

    /**
     * 描述
     */
    @TableField(value = "description")
    @JSONField(ordinal = 4)
    @ApiModelProperty(value = "描述", required = true)
    private String description;

    /**
     * 定时任务状态 0 停用,1启用
     */
    @TableField(value = "status")
    @JSONField(ordinal = 5)
    @ApiModelProperty(value = "定时任务状态", required = true)
    private Integer status;

    /**
     * 数据新建时间
     */
    @TableField(value = "createdat", fill = FieldFill.INSERT)
    @JSONField(ordinal = 6)
    @ApiModelProperty(value = "创建时间", required = false, hidden = true)
    private Date createdat;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}