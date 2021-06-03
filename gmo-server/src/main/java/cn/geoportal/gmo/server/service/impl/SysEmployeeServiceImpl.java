package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.entity.SysEmployee;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.entity.vo.SysEmployeeSearch;
import cn.geoportal.gmo.server.mapper.SysEmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.geoportal.gmo.server.service.SysEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class SysEmployeeServiceImpl extends ServiceImpl<SysEmployeeMapper, SysEmployee> implements SysEmployeeService{

    @Autowired
    private SysEmployeeMapper sysEmployeeMapper;

    @Override
    public IPage<SysEmployee> selectPage(Page ipage, QueryWrapper<SysEmployee> wrapper, SysEmployeeSearch sysEmployeeSearch) {
        System.out.println("**************************************************");
        System.out.println(sysEmployeeSearch.getDepartement());
        return sysEmployeeMapper.getEmployeeByPage(ipage, wrapper, sysEmployeeSearch);
    }

    @Override
    public RespBean addEmployee(SysEmployee sysEmployee) {
        // 处理合同期限
        Date beginDt = sysEmployee.getBegincontract();
        Date endDt = sysEmployee.getEndcontract();
        long days = (endDt.getTime() - beginDt.getTime())/(60*60*24*1000);
        sysEmployee.setWorkage((int) days);
        if(1 == sysEmployeeMapper.insert(sysEmployee)){
            return RespBean.success("雇员插入成功");
        }
        return RespBean.error("雇员插入失败");
    }

    @Override
    public List<SysEmployee> getEmployee(Integer id) {
        return sysEmployeeMapper.getEmployee(id);
    }

    @Override
    public int deletePosition(Integer id) {
        return sysEmployeeMapper.deleteById(id);
    }
}




