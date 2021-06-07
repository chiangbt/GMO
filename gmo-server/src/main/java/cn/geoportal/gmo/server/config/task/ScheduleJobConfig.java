package cn.geoportal.gmo.server.config.task;

import org.quartz.Scheduler;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.config.task
 * @ClassName: ScheduleJobConfig
 * @Author: chiangbt@geoportal.cn
 * @Description: ScheduleJobConfig
 * @Date: 2021/6/7 10:50
 */
@Configuration
public class ScheduleJobConfig {

    @Resource(name = "taskExecutor")
    private Executor taskExecutor;

    @Bean("schedulerFactoryBean")
    public SchedulerFactoryBean createFactoryBean(JobFactory jobFactory){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setJobFactory(jobFactory);
        factoryBean.setTaskExecutor(taskExecutor);
        factoryBean.setOverwriteExistingJobs(true);
        return factoryBean;
    }

    //通过这个类对定时任务进行操作
    @Bean
    public Scheduler scheduler(@Qualifier("schedulerFactoryBean") SchedulerFactoryBean factoryBean) {
        return factoryBean.getScheduler();
    }
}
