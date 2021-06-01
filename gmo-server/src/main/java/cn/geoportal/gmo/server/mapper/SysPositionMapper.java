package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.SysPosition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @Entity cn.geoportal.gmo.server.entity.SysPosition
 */
public interface SysPositionMapper extends BaseMapper<SysPosition> {

    @Select("INSERT INTO t_sys_position(name) values(#{name}) RETURNING id")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int addPosition(String name);
}




