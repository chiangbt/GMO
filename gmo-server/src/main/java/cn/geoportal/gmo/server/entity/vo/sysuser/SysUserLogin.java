package cn.geoportal.gmo.server.entity.vo.sysuser;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.entity.vo
 * @ClassName: UserLogin
 * @Author: chiangbt@geoportal.cn
 * @Description: 用户登录对象
 * @Date: 2021/5/31 10:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserLogin对象", description = "")
public class SysUserLogin {
    @ApiModelProperty(value = "用户名", required = true, example = "admin", position = 0)
    @JSONField(ordinal = 0)
    private String username;

    @ApiModelProperty(value = "密码", required = true, example = "123", position = 1)
    @JSONField(ordinal = 1)
    private String password;

    @ApiModelProperty(value = "验证码", required = true, example = "", position = 2)
    @JSONField(ordinal = 2)
    private String verifycode;
}
