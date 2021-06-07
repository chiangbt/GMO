package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.Customer;
import cn.geoportal.gmo.server.entity.TTaskConfig;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface TTaskConfigService extends IService<TTaskConfig> {
    IPage<TTaskConfig> selectPage(Page page, Wrapper<TTaskConfig> wrapper);
}
