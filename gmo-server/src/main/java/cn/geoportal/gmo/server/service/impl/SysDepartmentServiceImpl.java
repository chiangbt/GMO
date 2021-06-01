package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.entity.common.RespBean;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.geoportal.gmo.server.entity.SysDepartment;
import cn.geoportal.gmo.server.service.SysDepartmentService;
import cn.geoportal.gmo.server.mapper.SysDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements SysDepartmentService{

    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Override
    public List<SysDepartment> getAllDepartments() {
        return sysDepartmentMapper.getAllDepartments(-1);
    }

    @Override
    public RespBean addDepartment(SysDepartment sysDepartment) {
        sysDepartment.setEnabled(true);
        sysDepartmentMapper.addDepartment(sysDepartment);
        Integer result = sysDepartment.getResult();
        System.out.println(result);
        return RespBean.success("添加成功！");
    }
}




