package cn.geoportal.gmo.server.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.geoportal.gmo.server.entity.*;
import cn.geoportal.gmo.server.entity.common.PageResult;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.entity.vo.SysEmployeeSearch;
import cn.geoportal.gmo.server.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: EmployeeController
 * @Author: chiangbt@geoportal.cn
 * @Description: 员工模块
 * @Date: 2021/6/3 11:09
 */
@Api(tags = "10.雇员模块")
@ApiSupport(order = 312)
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {

    @Autowired
    private SysEmployeeService sysEmployeeService;
    @Autowired
    private SysPositionService sysPositionService;
    @Autowired
    private SysDepartmentService sysDepartmentService;
    @Autowired
    private SysJoblevelService sysJoblevelService;
    @Autowired
    private SysPoliticsStatusService sysPoliticsStatusService;
    @Autowired
    private SysNationService sysNationService;
    /**
     * 注意：使用了一个独特的查询类，并需要确保其字段全部为String
     * @param pageNo
     * @param pageSize
     * @param sysEmployeeSearch
     * @return
     */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "雇员信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页号", required = true, example = "1"),
            @ApiImplicitParam(name="pageSize", value = "批次数量", required = true, example = "15"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RespBean getEmployeeList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                    @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize,
                                    SysEmployeeSearch sysEmployeeSearch){
        // 翻页参数包装器
        QueryWrapper<SysEmployee> wrapper = new QueryWrapper<>();
        // 翻页对象
        Page<SysEmployee> ipage = new Page<>(pageNo, pageSize);
        try{
            // 为了保障SysEmployeeSearch的参数正确传输，确保其字段必须均为String
            IPage<SysEmployee> users = sysEmployeeService.selectPage(ipage, wrapper, sysEmployeeSearch);
            PageResult<?> pageResult = new PageResult<SysEmployee>(
                    users.getCurrent(),
                    users.getSize(),
                    users.getTotal(),
                    users.getRecords());

            return RespBean.success("获取成功", pageResult);
        }catch (Exception e){
            return RespBean.error("无数据");
        }
    }

    @ApiOperation(value = "获取所有职位")
    @ApiOperationSupport(order = 2)
    @GetMapping("/position")
    public List<SysPosition> getAllPositions(){
        return sysPositionService.list();
    }

    @ApiOperation(value = "获取所有部门")
    @ApiOperationSupport(order = 3)
    @GetMapping("/deps")
    public List<SysDepartment> getAllDepartments(){
        return sysDepartmentService.list();
    }

    @ApiOperation(value = "获取所有职称")
    @ApiOperationSupport(order = 4)
    @GetMapping("/joblevel")
    public List<SysJoblevel> getAllJoblevels(){
        return sysJoblevelService.list();
    }

    @ApiOperation(value = "获取所有政治面貌")
    @ApiOperationSupport(order = 5)
    @GetMapping("/politicstatus")
    public List<SysPoliticsStatus> getAllPoliticStatus(){
        return sysPoliticsStatusService.list();
    }

    @ApiOperation(value = "获取所有民族")
    @ApiOperationSupport(order = 6)
    @GetMapping("/nation")
    public List<SysNation> getAllNations(){
        return sysNationService.list();
    }

    @ApiOperation(value = "添加雇员")
    @ApiOperationSupport(order = 8)
    @PostMapping("")
    public RespBean addEmployee(@RequestBody SysEmployee sysEmployee){
        return sysEmployeeService.addEmployee(sysEmployee);
    }

    @ApiOperation(value = "导出员工数据")
    @ApiOperationSupport(order = 7)
    @GetMapping(value = "/export", produces = "application/octet-stream")
    public void exportEmployee(HttpServletResponse response) throws IOException {
        List<SysEmployee> list = sysEmployeeService.getEmployee(null);
        ExportParams parms = new ExportParams("员工表", "员工表", ExcelType.HSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(parms, SysEmployee.class, list);

        ServletOutputStream out = null;
        try{
            // 数据流
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode("员工表.xls", "UTF-8"));
            out = response.getOutputStream();
            workbook.write(out);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
}
