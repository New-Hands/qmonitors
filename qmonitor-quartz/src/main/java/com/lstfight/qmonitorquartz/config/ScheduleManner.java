package com.lstfight.qmonitorquartz.config;

import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lst
 * Created on 2018/5/4.
 */
public class ScheduleManner {
    private final Scheduler quartzScheduler;

    private final Trigger testTrigger;

    @Autowired
    public ScheduleManner(Scheduler quartzScheduler, Trigger testTrigger) {
        this.testTrigger = testTrigger;
        this.quartzScheduler = quartzScheduler;
    }


}
