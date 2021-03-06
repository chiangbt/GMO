package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.entity.SysDepartment;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.service.SysDepartmentService;
import cn.geoportal.gmo.server.mapper.SysDepartmentMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements SysDepartmentService {

    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Override
    public List<SysDepartment> getAllDepartments() {
        return sysDepartmentMapper.getAllDepartments(-1);
    }

    @Override
    public RespBean addDepartment(SysDepartment sysDepartment) {
        Integer result = sysDepartmentMapper.addDep(sysDepartment.getName(), sysDepartment.getParentid(), sysDepartment.getEnabled());
//        System.out.println(result);
        if (result != null) {
            return RespBean.success("添加成功！", result);
        }
        return RespBean.error("添加失败！");
    }

    @Override
    public RespBean deleteDepartment(Integer id) {
        Integer result = sysDepartmentMapper.delDep(id);
        if (1 == result) {
            return RespBean.success("删除部门成功！", result);
        }
        if (result == -2) {
            return RespBean.error("删除失败，该部门存在下级部门！", result);
        }
        if (result == -1) {
            return RespBean.error("删除失败，该部门存在员工！", result);
        }
        return RespBean.success("删除成功！", result);
    }
}




