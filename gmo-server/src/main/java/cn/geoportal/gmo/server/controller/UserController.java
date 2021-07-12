package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.SysRole;
import cn.geoportal.gmo.server.entity.SysUser;
import cn.geoportal.gmo.server.entity.SysUserRole;
import cn.geoportal.gmo.server.entity.common.PageResult;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.entity.vo.sysuser.SysUserReg;
import cn.geoportal.gmo.server.service.SysRoleService;
import cn.geoportal.gmo.server.service.SysUserRoleService;
import cn.geoportal.gmo.server.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: UserController
 * @Author: chiangbt@geoportal.cn
 * @Description: 操作员管理
 * @Date: 2021/6/2 14:35
 */
@Api(tags = "9.操作员模块")
@ApiSupport(order = 311)
@RestController
@RequestMapping("/api/system/admin")
public class UserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 1、操作员列表(自定义字段)
     * @param pageNo
     * @param pageSize
     * @param name
     * @return
     */
    @ApiOperationSupport(order = 0)
    @ApiOperation(value = "操作员列表(自定义字段)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页号", required = true, example = "1"),
            @ApiImplicitParam(name="pageSize", value = "批次数量", required = true, example = "15"),
            @ApiImplicitParam(name = "query",value = "名称", required = false, example = ""),
            @ApiImplicitParam(name = "role",value = "角色类型", required = false, example = "")
    })
    @RequestMapping(value="", method = RequestMethod.GET)
    public RespBean getSysUserList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                                        @RequestParam(value="query", defaultValue = "") String query){
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.like("username", query);
//        wrapper.eq("r.name", "ROLE_manager");
        Page<Map> ipage = new Page<>(pageNo, pageSize);
        try{
            IPage<Map> dt = sysUserService.getSysUserList(ipage, wrapper);
            PageResult<?> pageResult = new PageResult<Map>(dt.getCurrent(), dt.getSize(), dt.getTotal(), dt.getRecords());
            return RespBean.success("获取成功", pageResult);
        }catch(Exception e){
            return RespBean.error("无数据");
        }
    }

    /**
     * 2、获取操作员列表（非分页式）
     * @param keywords
     * @return
     */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "操作员列表(非分页式)")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SysUser> getAllSysUser(String keywords){
        return sysUserService.getAllSysUser(keywords);
    }

    /**
     * 3、添加操作员
     * role为1:n个，以"1,2,3"字符串形式传递
     * @param sysUser
     * @return
     */
    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "添加操作员")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public RespBean addSysUser(@RequestBody SysUserReg sysUser){
        try{
            // 添加一个SysUser
            int userid = sysUserService.addSysUser(sysUser);
            // role为1:n个，以"1,2,3"字符串形式传递
            String[] roleIds = sysUser.getRoleIds().split(",");
            for(String roldid : roleIds){
                // 新建User_Role对象
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId((long) userid);
                sysUserRole.setRoleId(Long.valueOf(roldid));
                // 添加UserRole对象
                sysUserRoleService.addUserRole(sysUserRole);
            }
            return RespBean.success("添加成功", userid);
        }catch (Exception exp) {
            return RespBean.error("添加不成功");
        }
    }

    /**
     * 4、更新操作员
     * @param sysUser
     * @param id
     * @return
     */
    @ApiOperationSupport(order = 3)
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

    /**
     * 4、删除指定操作员
     * @param id
     * @return
     */
    @ApiOperationSupport(order = 4)
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

    /**
     * 6、获取角色
     * @return
     */
    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "获取所有角色")
    @GetMapping(value = "/roles")
    public List<SysRole> getAllRoles(){
        return sysRoleService.list();
    }

    /**
     * 7、获取所有非admin角色
     * @return
     */
    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "获取所有非Admin角色")
    @GetMapping(value = "/roles/noadmin")
    public List<SysRole> getAllRoleListNoAdmin(){
        return sysRoleService.getRoleListNoAdmin();
    }

    /**
     * 8、更新操作员角色
     * @param userId
     * @param rids
     * @return
     */
    @ApiOperationSupport(order = 7)
    @ApiOperation(value = "更新操作员角色")
    @PatchMapping(value = "/role/{userId}")
    public RespBean updateSysUserRole(@PathVariable(value="userId") Integer userId, Integer[] rids){
        return sysUserService.updateSysUserRole(userId, rids);
    }
}
