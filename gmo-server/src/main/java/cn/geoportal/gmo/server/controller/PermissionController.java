package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.SysMenu;
import cn.geoportal.gmo.server.entity.SysMenuRole;
import cn.geoportal.gmo.server.entity.SysRole;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.entity.vo.sysmenu.MenuRoleUpdate;
import cn.geoportal.gmo.server.service.SysMenuRoleService;
import cn.geoportal.gmo.server.service.SysMenuService;
import cn.geoportal.gmo.server.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: PermissionController
 * @Author: chiangbt@geoportal.cn
 * @Description: 权限组模块
 * @Date: 2021/6/1 11:29
 */
@Api(tags = "7.权限组模块")
@ApiSupport(order = 309)
@RestController
@RequestMapping(value = "/system/perm")
public class PermissionController {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysMenuRoleService sysMenuRoleService;

    /**
     *
     * @return
     */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "获取所有角色")
    @GetMapping("")
    public List<SysRole> getAllRoles(){
        return sysRoleService.list(new QueryWrapper<SysRole>().orderByDesc("id"));
    }

    /**
     *
     * @param sysRole
     * @return
     */
    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "添加角色")
    @PostMapping(value = "/role", consumes = "application/json", produces = "application/json")
    public RespBean addRole(@RequestBody SysRole sysRole){
        try{
            if(!sysRole.getName().startsWith("ROLE_")){
                sysRole.setName("ROLE_" + sysRole.getName());
            }
            int insert = sysRoleService.addRole(sysRole);
            return RespBean.success("添加成功", insert);
        }catch (Exception e){
            return RespBean.error("添加失败");
        }
    }

    /**
     *
     * @param rid
     * @return
     */
    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "删除角色")
    @DeleteMapping(value = "/role/{rid}", produces = "application/json")
    public RespBean deleteRoleById(@PathVariable(value="rid") Integer rid){
        try{
            int result = sysRoleService.deleteRole(rid);
            if(0 == result){
                return RespBean.error("需要删除的对象不存在");
            }
            return RespBean.success("删除成功", result);
        }catch (Exception exp){
            return RespBean.error("删除不成功");
        }
    }

    /**
     *
     * @return
     */
    @ApiOperationSupport(order = 2)
    @ApiOperation("查询所有菜单")
    @GetMapping(value = "/menus")
    public List<SysMenu> getAllMenus() {
        return sysMenuService.getAllMenus();
    }

    /**
     *
     * @param rid
     * @return
     */
    @ApiOperationSupport(order = 4)
    @ApiOperation("根据角色id查询菜单id")
    @GetMapping("/menuid/{rid}")
    public List<Long> getMenuidByRid(@PathVariable("rid") Integer rid) {
        // list查询的是SysMenuRole对象，所有用stream流获取Menuid，然后转换为List
        return sysMenuRoleService.list(new QueryWrapper<SysMenuRole>().eq("role_id", rid)).stream().map(SysMenuRole::getMenuId).collect(Collectors.toList());
    }

    /**
     *
     * @param rid
     * @param menuRoleUpdate
     * @return
     */
    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "更新角色菜单")
    @PatchMapping(value = "/menuid/{rid}")
    public RespBean updateMenuByRole(@PathVariable("rid") Integer rid, @RequestBody MenuRoleUpdate menuRoleUpdate){
        System.out.println(menuRoleUpdate.getMids());
        int[] menuids = Arrays.asList(menuRoleUpdate.getMids().split(",")).stream().mapToInt(Integer::parseInt).toArray();
        Integer[] newArray = ArrayUtils.toObject(menuids);
        System.out.println(newArray);
        return sysMenuRoleService.updateMenuRole(rid, newArray);
    }
}
