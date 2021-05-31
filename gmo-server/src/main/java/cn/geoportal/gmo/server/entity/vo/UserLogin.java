package cn.geoportal.gmo.server.entity.vo;

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
@ApiModel(value = "userLogin对象", description = "")
public class UserLogin {
    @ApiModelProperty(value = "用户名", required = true)
    @JSONField(ordinal = 0)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @JSONField(ordinal = 1)
    private String password;

    @ApiModelProperty(value = "验证码", required = true)
    @JSONField(ordinal = 2)
    private String kaptcha;
}
