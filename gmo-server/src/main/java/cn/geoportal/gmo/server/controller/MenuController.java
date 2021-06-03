package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.SysMenu;
import cn.geoportal.gmo.server.service.SysMenuService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: MenuController
 * @Author: chiangbt@geoportal.cn
 * @Description: 菜单模块
 * @Date: 2021/5/31 12:57
 */
@Api(tags = "4.菜单模块")
@ApiSupport(order = 306)    // 分组排序
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "登录用户可访问菜单列表")
    @GetMapping("/menu")
    public List<SysMenu> getMenuByUserId(){
        return sysMenuService.getMenusByUserId();
    }
}
