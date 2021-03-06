package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.Customer;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * CustomerService
 */
public interface CustomerService extends IService<Customer> {
    /**
     * 1、返回User对象数组
     * @return
     */
    List<Customer> listCustomer();

    /**
     * 2、selectByName方法，支持基于name的模糊查询
     * @param name
     * @return
     */
    List<Customer> selectByName(String name);

    /**
     * 3、userCompactList，返回压缩版本的User对象数组
     * @param page
     * @param wrapper
     * @return
     */
    IPage<Map> customerCompactList(Page<Map> page, QueryWrapper<Customer> wrapper);

    /**
     * 4、翻页查询
     * @param page
     * @param wrapper
     * @return
     */
    IPage<Customer> selectPage(Page page, Wrapper<Customer> wrapper);

    /**
     * 5、添加Customer
     * @param customer 用户对象
     * @return
     */
    int addCustomer(Customer customer);

    /**
     * 6、添加Customer
     * @param name 姓名
     * @param age 年龄
     * @param address 地址
     * @return 新customer的id
     */
    int addCustomer(String name, Integer age, String address);

    /**
     * 7、更新指定id的Customer
     * @param customer
     * @return
     */
    int updateCustomer(Customer customer);

    /**
     * 8、获取指定id的Customer
     * @param id
     * @return
     */
    Customer findCustomerById(Integer id);

    /**
     * 9、删除指定id的Customer
     * @param id
     * @return
     */
    int deleteCustomer(Integer id);
}
