package cn.geoportal.gmo.server.entity.vo.sysuser;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.entity.vo.sysuser
 * @ClassName: SysUserReg(用户注册)
 * @Author: chiangbt@geoportal.cn
 * @Description: SysUserReg
 * @Date: 2021/7/12 16:53
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysUserReg对象", description = "")
public class SysUserReg {
    @ApiModelProperty(value = "用户名", required = true, example = "guest2", position = 0)
    @JSONField(ordinal = 0)
    private String username;

    @ApiModelProperty(value = "电子邮件", required = true, example = "guest@geo.cn", position = 1)
    @JSONField(ordinal = 1)
    private String email;

    @ApiModelProperty(value = "密码", required = true, example = "123", position = 2)
    @JSONField(ordinal = 2)
    private String password;

    @ApiModelProperty(value = "姓名", required = true, example = "guest2", position = 3)
    @JSONField(ordinal = 3)
    private String name;

    @ApiModelProperty(value = "电话", required = true, example = "13819847814", position = 4)
    @JSONField(ordinal = 4)
    private String phone;

    /**
     * role为1:n个，以"1,2,3"字符串形式传递
     */
    @ApiModelProperty(value = "角色", required = true, example = "2,3", position = 5)
    @JSONField(ordinal = 5)
    private String roleIds;

    @ApiModelProperty(value = "民族", required = true, example = "1", position = 6)
    @JSONField(ordinal = 6)
    private Integer nationId;

    @ApiModelProperty(value = "政治面貌", required = true, example = "1", position = 7)
    @JSONField(ordinal = 7)
    private Integer politicId;

    @ApiModelProperty(value = "职称", required = true, example = "1", position = 8)
    @JSONField(ordinal = 8)
    private Integer joblevelId;

    @ApiModelProperty(value = "职务", required = true, example = "1", position = 9)
    @JSONField(ordinal = 9)
    private Integer positionId;
}
