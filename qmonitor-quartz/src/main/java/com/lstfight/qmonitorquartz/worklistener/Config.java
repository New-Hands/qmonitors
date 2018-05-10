package com.lstfight.qmonitorquartz.worklistener;



import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author lst
 * Created on 2018/5/6.
 */
@Configuration
public class Config {
    private final Scheduler quartSchedule;

    @Autowired
    public Config(Scheduler quartSchedule) {
        this.quartSchedule = quartSchedule;
    }

    @Bean
    public TriggerListener normalListener() throws SchedulerException {
        final ScheduleListener listener = new ScheduleListener();
        quartSchedule.getListenerManager().addTriggerListener(listener);

        return listener;
    }
}
