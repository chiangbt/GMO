package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.SysPoliticsStatus;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.service.SysPoliticsStatusService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: PoliticsStatusController
 * @Author: chiangbt@geoportal.cn
 * @Description: 政治面貌
 * @Date: 2021/7/11 22:54
 */
@Api(tags = "13.Nation模块")
@ApiSupport(order = 502)    // 分组排序
@RestController
@RequestMapping("/api/system/politicstatus")
public class PoliticsStatusController {

    @Autowired
    private SysPoliticsStatusService sysPoliticsStatusService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public RespBean getAllPoliticStatus(){
        try{
            List<SysPoliticsStatus> sysPoliticsStatuses = sysPoliticsStatusService.getAllPoliticsStatus();
            return RespBean.success("获取成功", sysPoliticsStatuses);
        }catch(Exception e){
            return RespBean.error("无数据");
        }
    }
}
