package cn.geoportal.gmo.server.mapper;

import cn.geoportal.gmo.server.entity.SysJoblevel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @Entity cn.geoportal.gmo.server.entity.SysJoblevel
 */
public interface SysJoblevelMapper extends BaseMapper<SysJoblevel> {

    @Select("INSERT INTO t_sys_joblevel(name, titlelevel) values(#{name},#{titlelevel}) RETURNING id")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int addJoblevel(String name, String titlelevel);
}




