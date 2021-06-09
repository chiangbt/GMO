package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.Shopinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
*
*/
public interface ShopinfoService extends IService<Shopinfo> {
    int addShopInfo(String name, String address, double lat, double lng);
}
