package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysDepartment;
import cn.geoportal.gmo.server.entity.common.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface SysDepartmentService extends IService<SysDepartment> {

    /**
     * 1、获取所有部门
     * @return
     */
    List<SysDepartment> getAllDepartments();

    /**
     * 2、添加department
     * @param sysDepartment
     * @return
     */
    RespBean addDepartment(SysDepartment sysDepartment);

    /**
     * 3、删除部门
     * @param id
     * @return
     */
    RespBean deleteDepartment(Integer id);
}
