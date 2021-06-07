package cn.geoportal.gmo.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.geoportal.gmo.server.entity.MailLog;
import cn.geoportal.gmo.server.service.MailLogService;
import cn.geoportal.gmo.server.mapper.MailLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements MailLogService{

    @Autowired
    private MailLogMapper mailLogMapper;

    @Override
    public IPage<MailLog> selectPage(Page page, Wrapper<MailLog> wrapper) {
        return mailLogMapper.selectPage(page, wrapper);
    }
}




