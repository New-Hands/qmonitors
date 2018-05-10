package com.lstfight.qmonitorquartz.config;

import com.lstfight.qmonitorquartz.job.NormalJob;
import com.lstfight.qmonitorquartz.job.RequestJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>重点配置miss fire策略</p>
 * @author lst
 * Created on 2018/5/4.
 */
@Configuration
public class ScheduleConfig {


    /**
     * 配置jobDetail 一定要写上自己的名字 否则就会生成随机的名字 然后每一次运行都会持久化一个相同的job
     * @return bean
     */
    @Bean
    public JobDetail testJobDetail() {
        return JobBuilder.newJob(NormalJob.class)
                .withIdentity("testJob", "test")
                .storeDurably()
                .build();
    }

    /**
     * 配置Trigger 同样一定要写上自己的名字
     * @return been
     */
    @Bean("testTrigger")
    public Trigger testTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(testJobDetail())
                .withIdentity("test","monitor")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/15 * * ? * *"))
                .build();
    }

    @Bean
    public JobDetail requestJob() {
        return JobBuilder.newJob(RequestJob.class)
                .withIdentity("requestJob", "request")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger requestTrigger() {
        return TriggerBuilder.newTrigger()
                .withIdentity("requestTrigger", "request")
                .forJob(requestJob())
                .build();
    }

/*    @Bean
    public Trigger requestTrigger1() {
        return TriggerBuilder.newTrigger()
                .withIdentity("requestTrigger1", "request")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * ? * *"))
                .forJob(requestJob())
                .build();
    }
    @Bean
    public Trigger requestTrigger2() {
        return TriggerBuilder.newTrigger()
                .withIdentity("requestTrigger2", "request")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * ? * *"))
                .forJob(requestJob())
                .build();
    }
    @Bean
    public Trigger requestTrigger3() {
        return TriggerBuilder.newTrigger()
                .withIdentity("requestTrigger3", "request")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * ? * *"))
                .forJob(requestJob())
                .build();
    }*/
}
