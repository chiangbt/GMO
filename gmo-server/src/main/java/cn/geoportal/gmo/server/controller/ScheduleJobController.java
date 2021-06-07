package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.TTaskConfig;
import cn.geoportal.gmo.server.entity.common.PageResult;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.service.TTaskConfigService;
import cn.geoportal.gmo.server.service.impl.task.ScheduleJobService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.*;
import org.quartz.SchedulerConfigException;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: ScheduleJobController
 * @Author: chiangbt@geoportal.cn
 * @Description: 定时任务控制器
 * @Date: 2021/6/7 10:57
 */
@Api(tags = "12.定时任务模块")
@ApiSupport(order = 314)
@RestController
@RequestMapping("/api/task")
public class ScheduleJobController {

    @Autowired
    private TTaskConfigService tTaskConfigService;
    @Autowired
    private ScheduleJobService jobService;

    @ApiOperation(value = "定时任务列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页号", required = true, example = "1"),
            @ApiImplicitParam(name="pageSize", value = "批次数量", required = true, example = "15"),
            @ApiImplicitParam(name = "taskId",value = "名称", required = false, example = "")
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RespBean customerList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                 @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize,
                                 @RequestParam(value="taskId", defaultValue = "") String taskId){
        // 翻页参数包装器
        QueryWrapper<TTaskConfig> wrapper = new QueryWrapper<>();
        wrapper.like("task_id", taskId);
        wrapper.orderByDesc("id");
        // 翻页对象
        Page<TTaskConfig> ipage = new Page<>(pageNo, pageSize);
        try{
            IPage<TTaskConfig> users = tTaskConfigService.selectPage(ipage, wrapper);
            PageResult<?> pageResult = new PageResult<TTaskConfig>(
                    users.getCurrent(),
                    users.getSize(),
                    users.getTotal(),
                    users.getRecords());

            return RespBean.success("获取成功", pageResult);
        }catch (Exception e){
            return RespBean.error("无数据");
        }
    }

    @ApiOperation(value = "导入定时任务")
    @GetMapping("/load/{taskId}")
    public String loadJob(@PathVariable("taskId") String taskId){
        try {
            jobService.loadJob(taskId);
        } catch (SchedulerConfigException e) {
            return "导入定时任务失败";
        }
        return "成功";
    }

    @ApiOperation(value = "重启定时任务")
    @GetMapping("/resume/{taskId}")
    public RespBean resumeJob(@PathVariable("taskId") String taskId){
        try {
            jobService.resumeJob(taskId);
        }catch (SchedulerException e) {
            return RespBean.error("恢复定时任务失败");
        }
        return RespBean.success("成功");
    }

    @ApiOperation(value = "停止定时任务")
    @GetMapping("/stop/{taskId}")
    public RespBean stopJob(@PathVariable("taskId") String taskId){
        try {
            jobService.stopJob(taskId);
        }catch (SchedulerException e) {
            return RespBean.error("暂停定时任务失败");
        }
        return RespBean.success("任务停止成功");
    }

    @ApiOperation(value = "卸载定时任务")
    @GetMapping("/unload/{taskId}")
    public String unloadJob(@PathVariable("taskId") String taskId){
        try {
            jobService.unloadJob(taskId);
        }catch (SchedulerException e) {
            return "卸载定时任务失败";
        }
        return "成功";
    }
}
