package cn.geoportal.gmo.server.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName t_customer
 */
@TableName(value ="t_customer")
@Data
public class Customer implements Serializable {
    /**
     * ID字段，为自增型
     * JSONField - ordinal 响应顺序；serialize 不显示
     * ApiModelProperty - 在add和update中不显示在Body中
     * required 非必须
     * hidden 隐藏在body中
     * position Body中的顺序
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JSONField(ordinal = 0)
    @ApiModelProperty(value = "id", required = false, hidden = true, position = 0)
    private Integer id;

    /**
     * Name
     * 必须填写
     * 默认值为test
     */
    @TableField(value = "name")
    @JSONField(ordinal = 1)
    @ApiModelProperty(value = "名称", required = true, example = "test", position = 1)
    private String name;

    /**
     * Age
     * 必须填写
     * 默认值为45
     */
    @TableField(value = "age")
    @JSONField(ordinal = 2)
    @ApiModelProperty(value = "年龄", required = true, example = "45", position = 2)
    private Integer age;

    /**
     * Address
     * 必须填写
     * 默认值为
     */
    @TableField(value = "address")
    @JSONField(ordinal = 3)
    @ApiModelProperty(value = "地址", required = false, example = "浙江宁波", position = 3)
    private String address;

    /**
     * CreatedAt
     * serialize = false，返回不显示
     * required, hidden , 添加不需要
     */
    @TableField(fill = FieldFill.INSERT)
    @JSONField(ordinal = 4, serialize = false)
    @ApiModelProperty(value = "创建时间", required = false, hidden = true, position = 4)
    private Date createdat;

    /**
     * UpdatedAt
     *
     */
    @TableField(value = "updatedat", fill = FieldFill.INSERT_UPDATE)
    @JSONField(ordinal = 5)
    @ApiModelProperty(value = "更新时间", required = false, hidden = true, position = 5)
    private Date updatedat;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}