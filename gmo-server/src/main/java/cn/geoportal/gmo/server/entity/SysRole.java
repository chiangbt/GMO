package cn.geoportal.gmo.server.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName t_sys_role
 */
@ApiModel(value = "系统角色")
@TableName(value ="t_sys_role")
@Data
public class SysRole implements Serializable {
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
    @JSONField(ordinal = 0)
    @ApiModelProperty(value = "角色名")
    private String name;

    /**
     * 
     */
    @ApiModelProperty(value = "角色中文名")
    private String namezh;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}