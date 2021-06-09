package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.entity.vo.ShopInfoAdd;
import cn.geoportal.gmo.server.service.ShopinfoService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: ShopInfoController
 * @Author: chiangbt@geoportal.cn
 * @Description: ShopInfoAPI接口
 * @Date: 2021/6/9 11:26
 */
@Api(tags = "13.商铺信息(空间表)")
@ApiSupport(order = 322)    // 分组排序
@RestController
@RequestMapping("/api/shipinfo")
public class ShopInfoController {

    @Autowired
    private ShopinfoService shopinfoService;

    @ApiOperation(value = "新建一个Shopinfo")
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public RespBean addCustomer(@RequestBody ShopInfoAdd shopInfoAdd){
        try{
            int result = shopinfoService.addShopInfo(shopInfoAdd.getName(), shopInfoAdd.getAddress(), shopInfoAdd.getLat(), shopInfoAdd.getLng());
            return RespBean.success("添加成功", result);
        }catch (Exception exp){
            System.out.println(exp.getMessage());
            return RespBean.error("添加不成功");
        }
    }
}
