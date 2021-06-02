package cn.geoportal.gmo.server.controller;


import cn.geoportal.gmo.server.entity.SysJoblevel;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.service.SysJoblevelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: JoblevelController
 * @Author: chiangbt@geoportal.cn
 * @Description: 职称模块
 * @Date: 2021/6/1 11:14
 */
@Api(tags = "6.职称模块")
@ApiSupport(order = 308)
@RestController
@RequestMapping(value = "/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    private SysJoblevelService sysJoblevelService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "获取所有职称")
    @GetMapping("")
    public List<SysJoblevel> getAlJoblevel(){
        return sysJoblevelService.list(new QueryWrapper<SysJoblevel>().orderByDesc("id"));
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "获取职称")
    @GetMapping(value = "/{id}", produces = "application/json")
    public SysJoblevel getJoblevelById(@PathVariable(value="id") Integer id){
        return sysJoblevelService.findJoblevelById(id);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "添加职称")
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public RespBean addJoblevel(@RequestBody SysJoblevel sysJoblevel){
        try{
            int insert = sysJoblevelService.addJoblevel(sysJoblevel);
            return RespBean.success("添加成功", insert);
        }catch (Exception e){
            return RespBean.error("添加失败");
        }
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "更新职称")
    @PatchMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public RespBean updateJoblevel(@RequestBody SysJoblevel sysJoblevel, @PathVariable(value="id") Long id){
        try{
            sysJoblevel.setId(id);
            int result = sysJoblevelService.updateJoblevel(sysJoblevel);
            if(0 == result){
                return RespBean.error("需要更新的数据不存在");
            }
            return RespBean.success("更新成功", result);
        }catch (Exception exp){
            return RespBean.error("更新不成功");
        }
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除职称")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public RespBean deleteJoblevelById(@PathVariable(value="id") Integer id){
        try{
            int result = sysJoblevelService.deleteJoblevel(id);
            if(0 == result){
                return RespBean.error("需要删除的对象不存在");
            }
            return RespBean.success("删除成功", result);
        }catch (Exception exp){
            return RespBean.error("删除不成功");
        }
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "批量删除职称")
    @DeleteMapping(value = "")
    public RespBean deleteJoblevelByIds(Integer[] ids){
        if(sysJoblevelService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}
