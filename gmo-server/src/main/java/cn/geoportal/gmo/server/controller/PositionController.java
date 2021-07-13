package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.SysPosition;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.service.SysPositionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.List;

/**
 * @author: chiangbt@geoportal.cn
 * @CreatedAt: 2021/6/1 9:17 上午
 **/
@ApiIgnore
@RestController
@RequestMapping(value = "/system/basic/position")
public class PositionController {

    @Autowired
    private SysPositionService sysPositionService;

    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "获取所有职位")
    @GetMapping("")
    public List<SysPosition> getAllPostion(){
        return sysPositionService.list(new QueryWrapper<SysPosition>().orderByDesc("id"));
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "添加职位")
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public RespBean addPosition(@RequestBody SysPosition sysPosition){
        try{
            int insert = sysPositionService.addPosition(sysPosition);
            return RespBean.success("添加成功", insert);
        }catch (Exception e){
            return RespBean.error("添加失败");
        }
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "获取职位")
    @GetMapping(value = "/{id}", produces = "application/json")
    public SysPosition getPositionById(@PathVariable(value="id") Integer id){
        return sysPositionService.findPositionById(id);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "更新职位")
    @PatchMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public RespBean updatePostion(@RequestBody SysPosition sysPosition, @PathVariable(value="id") Long id){
        try{
            sysPosition.setId(id);
            int result = sysPositionService.updatePosition(sysPosition);
            if(0 == result){
                return RespBean.error("需要更新的数据不存在");
            }
            return RespBean.success("更新成功", result);
        }catch (Exception exp){
            return RespBean.error("更新不成功");
        }
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除职位")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public RespBean deletePositionById(@PathVariable(value="id") Integer id){
        try{
            int result = sysPositionService.deletePosition(id);
            if(0 == result){
                return RespBean.error("需要删除的对象不存在");
            }
            return RespBean.success("删除成功", result);
        }catch (Exception exp){
            return RespBean.error("删除不成功");
        }
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "批量删除职位")
    @DeleteMapping(value = "")
    public RespBean deletePostionsByIds(Integer[] ids){
        if(sysPositionService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}
