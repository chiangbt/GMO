package cn.geoportal.gmo.server.config.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.config.task
 * @ClassName: ExecutorConfig
 * @Author: chiangbt@geoportal.cn
 * @Description: ExecutorConfig
 * @Date: 2021/6/7 10:49
 */
@Configuration
public class ExecutorConfig {

    @Bean(name = "taskExecutor")
    public Executor getAsyncExecutor() throws InterruptedException{
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(1024);
        executor.setKeepAliveSeconds(4);
        executor.setQueueCapacity(0);
        executor.setRejectedExecutionHandler((Runnable r, ThreadPoolExecutor exe) -> {
            // 利用BlockingQueue的特性，任务队列满时等待放入
            try {
                if (!exe.getQueue().offer(r, 30, TimeUnit.SECONDS)) {
                    throw new Exception("Task offer failed after 30 sec");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return executor;
    }
}
