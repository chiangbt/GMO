package cn.geoportal.gmo.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.geoportal.gmo.server.entity.TTaskConfig;
import cn.geoportal.gmo.server.service.TTaskConfigService;
import cn.geoportal.gmo.server.mapper.TTaskConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class TTaskConfigServiceImpl extends ServiceImpl<TTaskConfigMapper, TTaskConfig> implements TTaskConfigService{

    @Autowired
    private TTaskConfigMapper tTaskConfigMapper;

    @Override
    public IPage<TTaskConfig> selectPage(Page page, Wrapper<TTaskConfig> wrapper) {
        return tTaskConfigMapper.selectPage(page, wrapper);
    }
}




