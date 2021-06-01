package cn.geoportal.gmo.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.geoportal.gmo.server.entity.SysJoblevel;
import cn.geoportal.gmo.server.service.SysJoblevelService;
import cn.geoportal.gmo.server.mapper.SysJoblevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SysJoblevelServiceImpl extends ServiceImpl<SysJoblevelMapper, SysJoblevel> implements SysJoblevelService{

    @Autowired
    private SysJoblevelMapper sysJoblevelMapper;

    @Override
    public int addJoblevel(SysJoblevel sysJoblevel) {
        return sysJoblevelMapper.addJoblevel(sysJoblevel.getName(), sysJoblevel.getTitlelevel());
    }

    @Override
    public int updateJoblevel(SysJoblevel sysJoblevel) {
        return sysJoblevelMapper.updateById(sysJoblevel);
    }

    @Override
    public SysJoblevel findJoblevelById(Integer id) {
        return sysJoblevelMapper.selectById(id);
    }

    @Override
    public int deleteJoblevel(Integer id) {
        return sysJoblevelMapper.deleteById(id);
    }
}




