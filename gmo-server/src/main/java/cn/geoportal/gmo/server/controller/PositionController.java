package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.SysPosition;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.service.SysPositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: chiangbt@geoportal.cn
 * @CreatedAt: 2021/6/1 9:17 上午
 **/
@RestController
@RequestMapping(value = "/system/config/position")
public class PositionController {

    @Autowired
    private SysPositionService sysPositionService;

    @ApiOperation(value = "获取所有职位")
    @GetMapping("/")
    public List<SysPosition> getAllPostion(){
        return sysPositionService.list();
    }

    @ApiOperation(value = "添加职位")
    @PostMapping("/")
    public RespBean addPosition(@RequestBody SysPosition sysPosition){
        try{
            int insert = sysPositionService.addPosition(sysPosition);
            return RespBean.success("添加成功", insert);
        }catch (Exception e){
            return RespBean.error("添加失败");
        }
    }

    @ApiOperation(value = "添加职位")
    @PatchMapping(value = "/", consumes = "application/json", produces = "application/json")
    public RespBean updatePostion(@RequestBody SysPosition sysPosition, @RequestParam(value="id") Long id){
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

    @ApiOperation(value = "删除指定id的职位")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public RespBean deletePositionById(@PathVariable(value="id") Integer id){
        try{
            int result = sysPositionService.deletePosition(id);
            return RespBean.success("删除成功", result);
        }catch (Exception exp){
            return RespBean.error("删除不成功");
        }
    }
}
