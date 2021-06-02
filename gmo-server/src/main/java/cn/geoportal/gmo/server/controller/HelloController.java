package cn.geoportal.gmo.server.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: HelloController
 * @Author: chiangbt@geoportal.cn
 * @Description: 测试模块
 * @Date: 2021/5/31 16:10
 */
@Api(tags = "3.角色访问控制测试")
@ApiSupport(order = 303)
@RestController
public class HelloController {

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "Admin有权限访问")
    @GetMapping("/employee/basic/hello")
    public String hello2(){
        return "/employee/basic/hello";
    }

    @ApiOperationSupport(order = 0)
    @ApiOperation(value = "Admin无权限访问")
    @GetMapping("/employee/advanced/hello")
    public String hello3(){
        return "/employee/advanced/hello";
    }
}
