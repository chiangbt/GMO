package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.Shopinfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
*
*/
public interface ShopinfoService extends IService<Shopinfo> {

    /**
     *
     * @param query
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Shopinfo> findShopPage(String query, int pageNo, int pageSize);

    /**
     *
     * @param lat
     * @param lng
     * @param radius
     * @return
     */
    List<Shopinfo> findWithDistance(double lat, double lng, double radius);

    /**
     *
     * @param name
     * @param address
     * @param lat
     * @param lng
     * @return
     */
    int addShopInfo(String name, String address, double lat, double lng);
}
