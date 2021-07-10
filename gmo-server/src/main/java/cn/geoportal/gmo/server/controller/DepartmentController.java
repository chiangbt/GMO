package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.SysDepartment;
import cn.geoportal.gmo.server.service.SysDepartmentService;
import cn.geoportal.gmo.server.entity.common.RespBean;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: DepartmentController
 * @Author: chiangbt@geoportal.cn
 * @Description: 部门模块
 * @Date: 2021/6/1 15:43
 */
@Api(tags = "8.部门模块")
@ApiSupport(order = 310)
@RestController
@RequestMapping(value = "/system/basic/department")
public class DepartmentController {

    @Autowired
    private SysDepartmentService sysDepartmentService;

    @ApiOperation(value = "获取所有部门")
    @GetMapping("")
    public List<SysDepartment> getAllDepartment(){
        return sysDepartmentService.getAllDepartments();
    }

    @ApiOperation("添加部门")
    @PostMapping("")
    public RespBean addDepart(@RequestBody SysDepartment sysDepartment) {
        return sysDepartmentService.addDepartment(sysDepartment);
    }

    @ApiOperation("删除部门")
    @DeleteMapping("/{id}")
    public RespBean deleteDepart(@PathVariable("id") Integer id) {
        return sysDepartmentService.deleteDepartment(id);
    }
}
