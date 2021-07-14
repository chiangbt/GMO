package cn.geoportal.gmo.server.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName t_sys_joblevel
 */
@ApiModel(value = "职称对象")
@TableName(value ="t_sys_joblevel")
@Data
public class SysJoblevel implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JSONField(ordinal = 0)
    @ApiModelProperty(value = "id", required = false, hidden = true)
    private Long id;

    /**
     * 
     */
    @JSONField(ordinal = 1)
    @ApiModelProperty(value = "职称名称")
    private String name;

    /**
     * 
     */
    @JSONField(ordinal = 2)
    @ApiModelProperty(value = "职位等级")
    private String titlelevel;

    /**
     * 
     */
    @JSONField(ordinal = 3)
    @ApiModelProperty(value = "是否启用", required = false, hidden = true)
    private Boolean enabled;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    @JSONField(ordinal = 4, serialize = false)
    @ApiModelProperty(value = "创建时间", required = false, hidden = true)
    private Date createdat;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}