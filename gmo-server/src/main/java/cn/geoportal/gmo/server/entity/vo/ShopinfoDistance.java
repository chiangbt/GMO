package cn.geoportal.gmo.server.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: chiangbt@geoportal.cn
 * @CreatedAt: 2021/6/9 11:18 下午
 **/
@Data
public class ShopinfoDistance {
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
    @JSONField(ordinal = 1)
    private String name;

    /**
     * 地址
     */
    @JSONField(ordinal = 2)
    private String address;

    /**
     * 时空位置
     */
    @JSONField(ordinal = 3)
    @TableField(exist = false)
    private String geomStr;

    /**
     * 距离
     */
    @JSONField(ordinal = 4)
    @TableField(exist = false)
    private Float distance;
}
