package cn.geoportal.gmo.server.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName t_sys_position
 */
@TableName(value ="t_sys_position")
@Data
public class SysPosition implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JSONField(ordinal = 0)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 
     */
    @JSONField(ordinal = 1)
    @ApiModelProperty(value = "职位名称")
    private String name;

    /**
     * 
     */
    @JSONField(ordinal = 2)
    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    @JSONField(ordinal = 3)
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date createdat;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}