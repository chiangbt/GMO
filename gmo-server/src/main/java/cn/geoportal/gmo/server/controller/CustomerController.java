package cn.geoportal.gmo.server.controller;

import cn.geoportal.gmo.server.entity.Customer;
import cn.geoportal.gmo.server.entity.common.PageResult;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.service.CustomerService;
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

import java.util.List;
import java.util.Map;
/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller
 * @ClassName: CustomerController
 * @Author: chiangbt@geoportal.cn
 * @Description: 客户API
 * @Date: 2021/5/31 11:55
 */
@Api(tags = "客户模块")
@ApiSupport(order = 201)    // 分组排序
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 客户信息
     * @param pageNo
     * @param pageSize
     * @param name
     * @return
     */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "客户信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页号", required = true, example = "1"),
            @ApiImplicitParam(name="pageSize", value = "批次数量", required = true, example = "15"),
            @ApiImplicitParam(name = "name",value = "名称", required = false, example = "")
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
//    @PreAuthorize(value = "hasAnyRole('ADMIN', 'USER')")
    public RespBean customerList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                 @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize,
                                 @RequestParam(value="name", defaultValue = "") String name){
        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        wrapper.like("name", name);
        wrapper.orderByDesc("id");
        Page<Customer> ipage = new Page<>(pageNo, pageSize);
        try{
            IPage<Customer> users = customerService.selectPage(ipage, wrapper);
            PageResult<?> pageResult = new PageResult<Customer>(users.getCurrent(), users.getSize(), users.getTotal(), users.getRecords());

            return RespBean.success("获取成功", pageResult);
        }catch (Exception e){
            return RespBean.error("无数据");
        }
    }

    /**
     *
     * @param pageNo
     * @param pageSize
     * @param name
     * @return
     */
    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "客户信息列表(自定义字段)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页号", required = true, example = "1"),
            @ApiImplicitParam(name="pageSize", value = "批次数量", required = true, example = "15"),
            @ApiImplicitParam(name = "name",value = "名称", required = false, example = "")
    })
    @RequestMapping(value="/compact", method = RequestMethod.GET)
//    @PreAuthorize(value = "hasAnyRole('ADMIN', 'USER')")
    public RespBean compactCustomerList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                                        @RequestParam(value="name", defaultValue = "") String name){
        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        wrapper.like("name", name);
        Page<Map> ipage = new Page<>(pageNo, pageSize);
        try{
            IPage<Map> dt = customerService.customerCompactList(ipage, wrapper);
            PageResult<?> pageResult = new PageResult<Map>(dt.getCurrent(), dt.getSize(), dt.getTotal(), dt.getRecords());
            return RespBean.success("获取成功", pageResult);
        }catch(Exception e){
            return RespBean.error("无数据");
        }
    }

    /**
     *
     * @param name
     * @return
     */
    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "按名称查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "名称", required = true, example = "")
    })
    @RequestMapping(value="/selectByName", method = RequestMethod.GET)
//    @PreAuthorize(value = "hasAnyRole('ADMIN', 'USER')")
    public RespBean searchByName(@RequestParam("name") String name){
        List<Customer> customerList = customerService.selectByName(name);
        return RespBean.success("获取成功", customerList);
    }

    /**
     *
     * @param customer
     * @return
     */
    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "新建一个Customer")
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
//    @PreAuthorize(value = "hasAnyRole('ADMIN')")
    public RespBean addCustomer(@RequestBody Customer customer){
        try{
            int result = customerService.addCustomer(customer.getName(), customer.getAge(), customer.getAddress());
            return RespBean.success("添加成功", result);
        }catch (Exception exp){
            return RespBean.error("添加不成功");
        }
    }


    /**
     *
     * @param id
     * @return
     */
    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "获取指定id的Customer")
    @GetMapping(value = "/{id}", produces = "application/json")
//    @PreAuthorize(value = "hasAnyRole('ADMIN', 'USER')")
    public RespBean getCustomerById(@PathVariable(value="id") Integer id){
        try{
            Customer customer = customerService.findCustomerById(id);
            if(null == customer){
                return RespBean.error("记录不存在");
            }
            return RespBean.success( "获取成功", customer);
        }catch (Exception exp){
            return RespBean.error("获取不成功");
        }
    }


    /**
     *
     * @param customer
     * @param id
     * @return
     */
    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "更新一个Customer")
    @PatchMapping(value = "", consumes = "application/json", produces = "application/json")
//    @PreAuthorize(value = "hasAnyRole('ADMIN')")
    public RespBean updateCustomer(@RequestBody Customer customer, @RequestParam(value="id") Integer id){
        try{
            customer.setId(id);
            int result = customerService.updateCustomer(customer);
            if(0 == result){
                return RespBean.error("需要更新的数据不存在");
            }
            return RespBean.success("更新成功", result);
        }catch (Exception exp){
            return RespBean.error("更新不成功");
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @ApiOperationSupport(order = 7)
    @ApiOperation(value = "删除指定id的Customer")
    @DeleteMapping(value = "/{id}", produces = "application/json")
//    @PreAuthorize(value = "hasAnyRole('ADMIN')")
    public RespBean deleteCustomerById(@PathVariable(value="id") Integer id){
        try{
            int result = customerService.deleteCustomer(id);
            return RespBean.success("删除成功", result);
        }catch (Exception exp){
            return RespBean.error("删除不成功");
        }
    }
}
