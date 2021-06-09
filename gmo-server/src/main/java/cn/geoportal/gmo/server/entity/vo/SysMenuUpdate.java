package cn.geoportal.gmo.server.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.entity.vo
 * @ClassName: SysMenuUpdate
 * @Author: chiangbt@geoportal.cn
 * @Description: SysMenuUpdate
 * @Date: 2021/6/9 10:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenuUpdate {

    @ApiModelProperty(value = "菜单名称")
    private String name;
}
