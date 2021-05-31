package cn.geoportal.gmo.server.entity.common;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.entity.common
 * @ClassName: RespBean
 * @Author: chiangbt@geoportal.cn
 * @Description: 公共返回对象
 * @Date: 2021/5/31 10:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "公共响应对象")
public class RespBean {

    @ApiModelProperty(value = "响应码")
    @JSONField(ordinal = 0)
    private long code;
    @ApiModelProperty(value = "响应信息")
    @JSONField(ordinal = 1)
    private String message;
    @ApiModelProperty(value = "响应数据")
    @JSONField(ordinal = 2)
    private Object data;

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static RespBean success(String message){
        return new RespBean(200, message, null);
    }

    /**
     * 成功返回结果
     * @param message
     * @param object
     * @return
     */
    public static RespBean success(String message, Object object){
        return new RespBean(200, message, object);
    }

    /**
     * 返回失败结果
     * @param message
     * @return
     */
    public static RespBean error(String message){
        return new RespBean(500, message, null);
    }

    /**
     * 返回失败结果
     * @param message
     * @param object
     * @return
     */
    public static RespBean error(String message, Object object){
        return new RespBean(500, message, object);
    }
}
