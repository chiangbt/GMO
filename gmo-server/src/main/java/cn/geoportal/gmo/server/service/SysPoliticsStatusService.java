package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysPoliticsStatus;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface SysPoliticsStatusService extends IService<SysPoliticsStatus> {
    List<SysPoliticsStatus> getAllPoliticsStatus();
}
