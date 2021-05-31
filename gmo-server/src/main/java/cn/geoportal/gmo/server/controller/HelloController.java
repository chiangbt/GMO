package cn.geoportal.gmo.server.controller;

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
@RestController
public class HelloController {

    @GetMapping("/employee/basic/hello")
    public String hello2(){
        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3(){
        return "/employee/advanced/hello";
    }
}
