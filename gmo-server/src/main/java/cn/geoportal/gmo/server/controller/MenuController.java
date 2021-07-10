package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.SysMenu;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.entity.vo.SysMenuUpdate;
import cn.geoportal.gmo.server.service.SysMenuService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/system/menu")
public class MenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "登录用户可访问菜单列表")
    @GetMapping("/menu")
    public List<SysMenu> getMenuByUserId(){
        return sysMenuService.getMenusByUserId();
    }

    @ApiOperation(value = "更新菜单名称")
    @PatchMapping(value = "/{id}", produces = "application/json")
    public RespBean updateMenuNameById(@PathVariable(value="id") Integer id, @RequestBody SysMenuUpdate sysMenuUpdate){
        SysMenu sysMenu = sysMenuService.findMenuById(id);
        try{
            sysMenu.setName(sysMenuUpdate.getName());
            sysMenu.setOrders(sysMenuUpdate.getOrders());
            int result = sysMenuService.UpdateMenuById(sysMenu);
            if(0 == result){
                return RespBean.error("需要更新的数据不存在");
            }
            return RespBean.success("更新成功", result);
        }catch (Exception exp){
            System.out.println(exp.getMessage());
            return RespBean.error("更新不成功");
        }
    }
}
