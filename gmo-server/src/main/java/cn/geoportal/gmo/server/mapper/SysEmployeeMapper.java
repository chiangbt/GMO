package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.SysEmployee;
import cn.geoportal.gmo.server.entity.vo.SysEmployeeSearch;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Entity cn.geoportal.gmo.server.entity.SysEmployee
 */
public interface SysEmployeeMapper extends BaseMapper<SysEmployee> {

    IPage<Map> getEmployeeByPage(Page<Map> page, @Param(Constants.WRAPPER) QueryWrapper<SysEmployee> wrapper,
                                 @Param("employee") SysEmployeeSearch employee);

    /**
     * 获取employee数据
     * @param id
     * @return
     */
    List<SysEmployee> getEmployee(Integer id);
}




