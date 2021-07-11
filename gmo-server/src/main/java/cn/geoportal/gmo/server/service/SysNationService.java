package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.SysNation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface SysNationService extends IService<SysNation> {
    List<SysNation> getAllNation();
}
