package cn.geoportal.gmo.server.service.impl;


import cn.geoportal.gmo.server.entity.Shopinfo;
import cn.geoportal.gmo.server.service.ShopinfoService;
import cn.geoportal.gmo.server.mapper.ShopinfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class ShopinfoServiceImpl extends ServiceImpl<ShopinfoMapper, Shopinfo> implements ShopinfoService{

    @Autowired
    private ShopinfoMapper shopinfoMapper;

    @Override
    public int addShopInfo(String name, String address, double lat, double lng) {
        System.out.println(name);
        System.out.println(address);
        System.out.println(lat);
        System.out.println(lng);
        String geomStr = "POINT" + "(" + lng + " " + lat + ")";
        return shopinfoMapper.addShopInfo(name, address, lat, lng, geomStr);
    }
}
