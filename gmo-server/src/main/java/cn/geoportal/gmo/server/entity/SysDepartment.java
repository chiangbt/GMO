package cn.geoportal.gmo.server.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName t_sys_department
 */
@TableName(value ="t_sys_department")
@Data
public class SysDepartment implements Serializable {
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
    @ApiModelProperty(value = "部门名称")
    private String name;

    /**
     * 
     */
    @JSONField(ordinal = 2)
    @ApiModelProperty(value = "父id")
    private Integer parentid;

    /**
     * 
     */
    @JSONField(ordinal = 3)
    @ApiModelProperty(value = "路径", required = false, hidden = true)
    private String deppath;

    /**
     * 
     */
    @JSONField(ordinal = 4)
    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    /**
     * 
     */
    @JSONField(ordinal = 5)
    @ApiModelProperty(value = "是否上级", required = false, hidden = true)
    private Boolean isparent;

    @JSONField(ordinal = 6)
    @ApiModelProperty(value = "子部门", required = false, hidden = true)
    @TableField(exist = false)
    private List<SysDepartment> children;

//    @JSONField(ordinal = 7)
//    @ApiModelProperty(value = "返回结果，存储过程使用", required = false, hidden = true)
//    @TableField(exist = false)
//    private Integer result;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}