package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.entity.Customer;
import cn.geoportal.gmo.server.service.CustomerService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.geoportal.gmo.server.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer>
implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 返回User对象数组
     * @return
     */
    @Override
    public List<Customer> listCustomer() {
        return customerMapper.selectList(new QueryWrapper<>());
    }

    /**
     * selectByName方法，支持基于name的模糊查询
     * @param name
     * @return
     */
    @Override
    public List<Customer> selectByName(String name) {
        return customerMapper.selectByName(name);
    }

    /**
     * userCompactList，返回压缩版本的User对象数组
     * @param page
     * @param wrapper
     * @return
     */
    @Override
    public IPage<Map> customerCompactList(Page<Map> page, QueryWrapper<Customer> wrapper) {
        return customerMapper.customerCompactList(page, wrapper);
    }

    /**
     * 翻页查询
     * @param page
     * @param wrapper
     * @return
     */
    @Override
    public IPage<Customer> selectPage(Page page, Wrapper<Customer> wrapper) {
        return customerMapper.selectPage(page, wrapper);
    }

    /**
     * 添加Customer
     * @param customer
     * @return
     */
    @Override
    public int addCustomer(Customer customer) {
        return customerMapper.insert(customer);
    }

    /**
     * 添加Customer
     * @param name
     * @param age
     * @param address
     * @return
     */
    @Override
    public int addCustomer(String name, Integer age, String address) {
        return customerMapper.addCustomer(name, age, address);
    }

    /**
     * 更新指定的Customer
     * @param customer
     * @return
     */
    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateById(customer);
    }

    /**
     * 寻找指定的Customer
     * @param id
     * @return
     */
    @Override
    public Customer findCustomerById(Integer id) {
        return customerMapper.selectById(id);
    }

    /**
     * 删除指定的Customer
     * @param id
     * @return
     */
    @Override
    public int deleteCustomer(Integer id) {
        return customerMapper.deleteById(id);
    }
}




