package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysPosition;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SysPositionService extends IService<SysPosition> {

    /**
     *
     * @param sysPosition
     * @return
     */
    int addPosition(SysPosition sysPosition);

    /**
     *
     * @param sysPosition
     * @return
     */
    int updatePosition(SysPosition sysPosition);

    /**
     *
     * @param id
     * @return
     */
    SysPosition findPositionById(Integer id);

    /**
     *
     * @param id
     * @return
     */
    int deletePosition(Integer id);
}
