package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.Shopinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @Entity cn.geoportal.gmo.server.entity.Shopinfo
*/
public interface ShopinfoMapper extends BaseMapper<Shopinfo> {

    /**
     * 添加商铺信息
     * @param name
     * @param address
     * @param lat
     * @param lng
     * @param geomStr
     * @return
     */
    @Select("INSERT INTO t_shopinfo(name, address, lat, lng, geom) values(#{name}, #{address}, #{lat}, #{lng}, ST_GeomFromText(#{geomStr}, 4326) ) RETURNING id")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int addShopInfo(String name, String address, double lat, double lng, String geomStr);

    /**
     * 寻找Shop
     * @param offset
     * @param pageSize
     * @return
     */
    List<Shopinfo> findShopPage(String query, Integer offset, Integer pageSize);

    /**
     * 按距离寻找
     * @param pt
     * @param radius
     * @return
     */
    List<Shopinfo> findDistanceWithIn(String pt, double radius);

    /**
     * 寻找最近的Shop
     * @param pt
     * @param count
     * @return
     */
    List<Shopinfo> findNearestPOI(String pt, Integer count);
}
