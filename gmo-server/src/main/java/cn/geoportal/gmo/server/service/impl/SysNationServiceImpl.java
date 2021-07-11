package cn.geoportal.gmo.server.service.impl;

import cn.geoportal.gmo.server.entity.SysNation;
import cn.geoportal.gmo.server.mapper.SysNationMapper;
import cn.geoportal.gmo.server.service.SysNationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SysNationServiceImpl extends ServiceImpl<SysNationMapper, SysNation> implements SysNationService {
    @Autowired
    SysNationMapper sysNationMapper;

    @Override
    public List<SysNation> getAllNation() {
        return sysNationMapper.selectList(null);
    }
}




