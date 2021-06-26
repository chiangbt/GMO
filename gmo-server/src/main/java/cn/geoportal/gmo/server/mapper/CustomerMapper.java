package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.Customer;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Customer 用户类
 * @Entity cn.geoportal.gmo.server.entity.Customer
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    /**
     * 1、基于mapper.xml中的sql
     * selectByName方法，支持基于name的模糊查询
     * UserMapper.xml提供具体实现方法
     * @param name name字段查询
     * @return User对象数组
     */
    List<Customer> selectByName(@Param("name") String name);

    /**
     * 2、customerCompactList，返回压缩版本的数据
     * @param page 页数对象
     * @param wrapper 包装器
     * @return
     */
    IPage<Map> customerCompactList(Page<Map> page, @Param(Constants.WRAPPER) QueryWrapper<Customer> wrapper);

    /**
     * 3、基于@Select的注解功能
     * 自定义添加Customer
     * @param name 姓名
     * @param age 年龄
     * @param address 地址
     * @return 新增Customer的id
     */
    @Select("INSERT INTO t_customer(name, age, address) values(#{name}, #{age}, #{address}) RETURNING id")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int addCustomer(String name, Integer age, String address);
}




