package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.SysDepartment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * @Entity cn.geoportal.gmo.server.entity.SysDepartment
 */
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {

    /**
     * 1、获取所有的部门
     * @param parentId
     * @return
     */
    List<SysDepartment> getAllDepartments(Integer parentId);

    /**
     * 2、添加department
     * @param depName
     * @param parentId
     * @param enabled
     * @return
     */
    Integer addDep(String depName, Integer parentId, Boolean enabled);


    /**
     * 3、删除部门
     * @param did
     * @return
     */
    Integer delDep(Integer did);
}




