package cn.geoportal.gmo.server.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商店空间表
 * @TableName t_shopinfo
 */
@TableName(value ="t_shopinfo")
@Data
public class Shopinfo implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JSONField(ordinal = 0)
    @ApiModelProperty(value = "id", required = false, hidden = true)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 纬度
     */
    private Float lat;

    /**
     * 经度
     */
    private Float lng;

    /**
     * 时空位置
     */
    @TableField(exist = false)
    private String geomStr;

    /**
     * 数据新建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JSONField(ordinal = 6)
    @ApiModelProperty(value = "创建时间", required = false, hidden = true)
    private Date createdat;

    /**
     * 数据更新时间
     */
    @TableField(value = "updatedat", fill = FieldFill.INSERT_UPDATE)
    @JSONField(ordinal = 7)
    @ApiModelProperty(value = "更新时间", required = false, hidden = true)
    private Date updatedat;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}