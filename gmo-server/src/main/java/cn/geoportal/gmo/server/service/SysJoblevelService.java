package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysJoblevel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SysJoblevelService extends IService<SysJoblevel> {
    /**
     *
     * @param sysJoblevel
     * @return
     */
    int addJoblevel(SysJoblevel sysJoblevel);

    /**
     *
     * @param sysJoblevel
     * @return
     */
    int updateJoblevel(SysJoblevel sysJoblevel);

    /**
     *
     * @param id
     * @return
     */
    SysJoblevel findJoblevelById(Integer id);

    /**
     *
     * @param id
     * @return
     */
    int deleteJoblevel(Integer id);
}
