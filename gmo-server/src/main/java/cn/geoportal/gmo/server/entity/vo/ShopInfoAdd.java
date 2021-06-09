package cn.geoportal.gmo.server.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.entity.vo
 * @ClassName: ShopInfoAdd
 * @Author: chiangbt@geoportal.cn
 * @Description: ShopInfoAdd
 * @Date: 2021/6/9 11:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShopInfoAdd {

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
}
