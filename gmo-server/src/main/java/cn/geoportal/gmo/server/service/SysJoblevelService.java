package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysJoblevel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SysJoblevelService extends IService<SysJoblevel> {
    /**
     * 1、添加joblevel
     * @param sysJoblevel
     * @return
     */
    int addJoblevel(SysJoblevel sysJoblevel);

    /**
     * 2、更新joblevel
     * @param sysJoblevel
     * @return
     */
    int updateJoblevel(SysJoblevel sysJoblevel);

    /**
     * 3、寻找指定id的joblevel
     * @param id
     * @return
     */
    SysJoblevel findJoblevelById(Integer id);

    /**
     * 4、删除joblevel
     * @param id
     * @return
     */
    int deleteJoblevel(Integer id);
}
