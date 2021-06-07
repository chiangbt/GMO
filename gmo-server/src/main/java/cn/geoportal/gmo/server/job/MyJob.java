package cn.geoportal.gmo.server.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.job
 * @ClassName: MyJob
 * @Author: chiangbt@geoportal.cn
 * @Description: MyJob
 * @Date: 2021/6/7 11:01
 */
public class MyJob implements Job{

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("定时任务开始:"+now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
