package cn.geoportal.gmo.server.controller;


import cn.geoportal.gmo.server.entity.Shopinfo;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.entity.vo.ShopInfoAdd;
import cn.geoportal.gmo.server.service.ShopinfoService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(value = "商店信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页号", required = true, example = "1"),
            @ApiImplicitParam(name="pageSize", value = "批次数量", required = true, example = "15"),
            @ApiImplicitParam(name = "query",value = "名称", required = false, example = "")
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RespBean getAllShopinfoList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                 @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize,
                                 @RequestParam(value="query", defaultValue = "") String query){

        try{
            List<Shopinfo> shopInfos = shopinfoService.findShopPage(query, pageNo, pageSize);

            return RespBean.success("获取成功", shopInfos);
        }catch (Exception e){
            return RespBean.error("无数据");
        }
    }

    @ApiOperation(value = "范围查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lat", value = "纬度", required = true, example = "32.033305"),
            @ApiImplicitParam(name="lng", value = "经度", required = true, example = "118.850675"),
            @ApiImplicitParam(name = "radius",value = "范围距离", required = false, example = "1000")
    })
    @RequestMapping(value = "/distance", method = RequestMethod.GET)
    public RespBean getAllShopinfoList(@RequestParam(value = "lat", defaultValue = "32.033305") Float lat,
                                       @RequestParam(value = "lng", defaultValue = "118.850675") Float lng,
                                       @RequestParam(value="radius", defaultValue = "1000") Float radius){

        try{
            List<Shopinfo> shopInfos = shopinfoService.findWithDistance(lat, lng, radius);

            return RespBean.success("获取成功", shopInfos);
        }catch (Exception e){
            return RespBean.error("无数据");
        }
    }

    @ApiOperation(value = "所在点最近要素查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lat", value = "纬度", required = true, example = "32.033305"),
            @ApiImplicitParam(name="lng", value = "经度", required = true, example = "118.850675"),
            @ApiImplicitParam(name = "count",value = "要素数量", required = false, example = "10")
    })
    @RequestMapping(value = "/nearest", method = RequestMethod.GET)
    public RespBean getNearestShopinfoList(@RequestParam(value = "lat", defaultValue = "32.033305") Float lat,
                                       @RequestParam(value = "lng", defaultValue = "118.850675") Float lng,
                                       @RequestParam(value="count", defaultValue = "10") Integer count){

        try{
            List<Shopinfo> shopInfos = shopinfoService.findNearestPOI(lat, lng, count);

            return RespBean.success("获取成功", shopInfos);
        }catch (Exception e){
            return RespBean.error("无数据");
        }
    }

    @ApiOperation(value = "新建一个Shopinfo")
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public RespBean addShopInfo(@RequestBody ShopInfoAdd shopInfoAdd){
        try{
            int result = shopinfoService.addShopInfo(shopInfoAdd.getName(), shopInfoAdd.getAddress(), shopInfoAdd.getLat(), shopInfoAdd.getLng());
            return RespBean.success("添加成功", result);
        }catch (Exception exp){
            System.out.println(exp.getMessage());
            return RespBean.error("添加不成功");
        }
    }
}
