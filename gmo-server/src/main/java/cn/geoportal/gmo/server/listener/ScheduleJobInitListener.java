package cn.geoportal.gmo.server.listener;

import cn.geoportal.gmo.server.service.impl.task.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.listener
 * @ClassName: ScheduleJobInitListener
 * @Author: chiangbt@geoportal.cn
 * @Description: ScheduleJobInitListener
 * @Date: 2021/6/7 11:02
 */
@Component
public class ScheduleJobInitListener implements CommandLineRunner {

    @Autowired
    private ScheduleJobService jobService;

    @Override
    public void run(String... strings) throws Exception {
        jobService.startJob();
    }
}
