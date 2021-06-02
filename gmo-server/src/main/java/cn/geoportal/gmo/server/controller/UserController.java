package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.SysRole;
import cn.geoportal.gmo.server.entity.SysUser;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.service.SysRoleService;
import cn.geoportal.gmo.server.service.SysUserService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: UserController
 * @Author: chiangbt@geoportal.cn
 * @Description: 操作员管理
 * @Date: 2021/6/2 14:35
 */
@Api(tags = "操作用户模块")
@ApiSupport(order = 329)
@RestController
@RequestMapping("/system/admin")
public class UserController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "操作员列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<SysUser> getAllSysUser(String keywords){
        return sysUserService.getAllSysUser(keywords);
    }


    @ApiOperation(value = "更新操作员")
    @PatchMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public RespBean updateSysUser(@RequestBody SysUser sysUser, @PathVariable(value="id") Long id){
        try{
            sysUser.setId(id);
            int result = sysUserService.updateSysUser(sysUser);
            if(0 == result){
                return RespBean.error("需要更新的数据不存在");
            }
            return RespBean.success("更新成功", result);
        }catch (Exception exp){
            return RespBean.error("更新不成功");
        }
    }

    @ApiOperation(value = "删除指定id的操作员")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public RespBean deleteSysUserById(@PathVariable(value="id") Integer id){
        try{
            int result = sysUserService.deleteCustomer(id);
            return RespBean.success("删除成功", result);
        }catch (Exception exp){
            return RespBean.error("删除不成功");
        }
    }

    @ApiOperation(value = "获取所有角色")
    @GetMapping(value = "/roles")
    public List<SysRole> getAllRoles(){
        return sysRoleService.list();
    }

    @ApiOperation(value = "更新操作员角色")
    @PatchMapping(value = "/role/{userId}")
    public RespBean updateSysUserRole(@PathVariable(value="userId") Integer userId, Integer[] rids){
        return sysUserService.updateSysUserRole(userId, rids);
    }
}
