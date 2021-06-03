package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysEmployee;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.entity.vo.SysEmployeeSearch;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface SysEmployeeService extends IService<SysEmployee> {

    /**
     * 分页查询员工
     * @param ipage
     * @param wrapper
     * @param sysEmployeeSearch
     * @return
     */
    IPage<SysEmployee> selectPage(Page ipage, QueryWrapper<SysEmployee> wrapper, SysEmployeeSearch sysEmployeeSearch);

    /**
     * 添加员工
     * @param sysEmployee
     * @return
     */
    RespBean addEmployee(SysEmployee sysEmployee);

    /**
     * 查询员工
     * @param id
     * @return
     */
    List<SysEmployee> getEmployee(Integer id);

    /**
     * 删除员工
     * @param id
     * @return
     */
    int deletePosition(Integer id);
}
