package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.Shopinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
* @Entity cn.geoportal.gmo.server.entity.Shopinfo
*/
public interface ShopinfoMapper extends BaseMapper<Shopinfo> {

    @Select("INSERT INTO t_shopinfo(name, address, lat, lng, geom) values(#{name}, #{address}, #{lat}, #{lng}, ST_GeomFromText(#{geomStr}, 4326) ) RETURNING id")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int addShopInfo(String name, String address, double lat, double lng, String geomStr);
}
