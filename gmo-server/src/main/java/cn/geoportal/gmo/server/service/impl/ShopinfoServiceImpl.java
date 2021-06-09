package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.entity.Shopinfo;
import cn.geoportal.gmo.server.service.ShopinfoService;
import cn.geoportal.gmo.server.mapper.ShopinfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class ShopinfoServiceImpl extends ServiceImpl<ShopinfoMapper, Shopinfo> implements ShopinfoService{

    @Autowired
    private ShopinfoMapper shopinfoMapper;

    @Override
    public List<Shopinfo> findShopPage(String query, int pageNo, int pageSize) {
        Integer _pageno = 0;
        if(pageNo <= 0){
            _pageno = 0;
        }else{
            _pageno = pageNo - 1;
        }
        Integer offset = pageSize * _pageno;
        return shopinfoMapper.findShopPage(query, offset, pageSize);
    }

    @Override
    public List<Shopinfo> findWithDistance(double lat, double lng, double radius) {
        String pt = "POINT" + "(" + lng + " " + lat + ")";
        return shopinfoMapper.findDistanceWithIn(pt, radius);
    }

    @Override
    public int addShopInfo(String name, String address, double lat, double lng) {
        String geomStr = "POINT" + "(" + lng + " " + lat + ")";
        return shopinfoMapper.addShopInfo(name, address, lat, lng, geomStr);
    }
}
