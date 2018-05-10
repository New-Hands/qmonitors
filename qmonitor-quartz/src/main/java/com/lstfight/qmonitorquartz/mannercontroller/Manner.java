package com.lstfight.qmonitorquartz.mannercontroller;

import com.lstfight.qmonitorquartz.request.Resulter;
import org.quartz.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lst
 * Created on 2018/5/6.
 */
@RestController
@RequestMapping("manner")
public class Manner {

    private final Scheduler quartzScheduler;

    public Manner(Scheduler quartzScheduler) {
        this.quartzScheduler = quartzScheduler;
    }


    @RequestMapping("reScheduleJob/{name}/{group}/{cron}")
    public String  reScheduleTrigger(@PathVariable("name") String name,
                                     @PathVariable("group") String group,
                                     @PathVariable("cron") String cron) throws SchedulerException {

        if (cron == null) {
            cron = "0 03/30 * ? * *";
        }
        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .withIdentity(new TriggerKey(name, group))
                .build();
        quartzScheduler.rescheduleJob(new TriggerKey(name,group), trigger);
        return  quartzScheduler.getTriggerState(new TriggerKey(name, group)).toString();
    }

    @RequestMapping("{code}/{name}/{group}")
    public String control(@PathVariable("code") String code,
                          @PathVariable("name") String name,
                          @PathVariable("group") String group)
            throws SchedulerException {

        Code instruction = Code.valueOf(code.toUpperCase());
        switch (instruction){
            case PAUSE:
                quartzScheduler.pauseTrigger(new TriggerKey(name,group));
                return "";
            case RESUME:
                quartzScheduler.resumeTrigger(new TriggerKey(name,group));
                return "";
            case STATE:
                quartzScheduler.getTriggerState(new TriggerKey(name, group));
                return quartzScheduler.getTriggerState(new TriggerKey(name, group)).toString();
            case RESCHEDULE:
                return reScheduleTrigger(name, group, null);
                default:
                    return "命令错误";
        }
    }

    @RequestMapping("testredis")
    public String  testRedis() {
        return new Resulter().toString();
    }


    enum Code{
        /**
         * 暂停
         */
        PAUSE("pause"),
        /**
         * 唤醒
         */
        RESUME("resume"),

        /**
         *
         */
        STATE("State"),

        /**
         *
         */
        RESCHEDULE("reschedule");

        Code(String state) {
            this.state = state;
        }

        String state;
    }
}
