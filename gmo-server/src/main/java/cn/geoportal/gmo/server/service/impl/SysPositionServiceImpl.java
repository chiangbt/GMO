package cn.geoportal.gmo.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.geoportal.gmo.server.entity.SysPosition;
import cn.geoportal.gmo.server.service.SysPositionService;
import cn.geoportal.gmo.server.mapper.SysPositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SysPositionServiceImpl extends ServiceImpl<SysPositionMapper, SysPosition> implements SysPositionService{

    @Autowired
    private SysPositionMapper sysPositionMapper;

    @Override
    public int addPosition(SysPosition sysPosition) {
        return sysPositionMapper.addPosition(sysPosition.getName());
    }

    @Override
    public int updatePosition(SysPosition sysPosition) {
        return sysPositionMapper.updateById(sysPosition);
    }

    @Override
    public SysPosition findPositionById(Integer id) {
        return sysPositionMapper.selectById(id);
    }

    @Override
    public int deletePosition(Integer id) {
        return sysPositionMapper.deleteById(id);
    }
}




