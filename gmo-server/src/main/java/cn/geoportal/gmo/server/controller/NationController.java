package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.SysNation;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.service.SysNationService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: NationController
 * @Author: chiangbt@geoportal.cn
 * @Description: NationController
 * @Date: 2021/7/11 22:31
 */
@ApiIgnore
@RestController
@RequestMapping("/api/system/nation")
public class NationController {

    @Autowired
    private SysNationService sysNationService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public RespBean getAllNations(){
        try{
            List<SysNation> sysNations = sysNationService.getAllNation();
            return RespBean.success("获取成功", sysNations);
        }catch(Exception e){
            return RespBean.error("无数据");
        }
    }
}
