package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.entity.SysPoliticsStatus;
import cn.geoportal.gmo.server.mapper.SysNationMapper;
import cn.geoportal.gmo.server.mapper.SysPoliticsStatusMapper;
import cn.geoportal.gmo.server.service.SysPoliticsStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SysPoliticsStatusServiceImpl extends ServiceImpl<SysPoliticsStatusMapper, SysPoliticsStatus> implements SysPoliticsStatusService {

    @Autowired
    private SysPoliticsStatusMapper sysPoliticsStatusMapper;

    @Override
    public List<SysPoliticsStatus> getAllPoliticsStatus() {
        return sysPoliticsStatusMapper.selectList(null);
    }
}




