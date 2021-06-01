package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.SysDepartment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @Entity cn.geoportal.gmo.server.entity.SysDepartment
 */
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {

    List<SysDepartment> getAllDepartments(Integer parentId);

    void addDepartment(SysDepartment sysDepartment);

}




