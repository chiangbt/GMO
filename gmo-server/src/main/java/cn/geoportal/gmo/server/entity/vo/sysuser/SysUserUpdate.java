package cn.geoportal.gmo.server.entity.vo.sysuser;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.entity.vo
 * @ClassName: EmployeeUpdate
 * @Author: chiangbt@geoportal.cn
 * @Description: 雇员更新类
 * @Date: 2021/6/3 10:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "操作员更新类", description = "")
public class SysUserUpdate {

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JSONField(ordinal = 0)
    @ApiModelProperty(value = "id", required = false, hidden = true)
    private Long id;

    /**
     *
     */
    @ApiModelProperty(value = "用户姓名")
    @JSONField(ordinal = 1)
    private String name;

    /**
     *
     */
    @ApiModelProperty(value = "移动电话")
    @JSONField(ordinal = 2)
    private String phone;

    /**
     *
     */
    @ApiModelProperty(value = "地址")
    @JSONField(ordinal = 3)
    private String address;

    /**
     *
     */
    @ApiModelProperty(value = "是否激活")
    @JSONField(ordinal = 4)
    private Boolean enabled;

    /**
     *
     */
    @ApiModelProperty(value = "用户图像")
    @JSONField(ordinal = 5)
    private String userface;

    /**
     *
     */
    @ApiModelProperty(value = "注记")
    @JSONField(ordinal = 6)
    private String remark;

}
