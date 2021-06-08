package cn.geoportal.gmo.server.service;

import cn.geoportal.gmo.server.entity.MailLog;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface MailLogService extends IService<MailLog> {
    /**
     *
     * @param page
     * @param wrapper
     * @return
     */
    IPage<MailLog> selectPage(Page page, Wrapper<MailLog> wrapper);

    /**
     *
     * @param id
     * @return
     */
    int deleteMailLog(Integer id);
}
