package com.lstfight.qmonitorquartz.worklistener;

import com.lstfight.qmonitorquartz.mail.EmailImp;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lst
 * Created on 2018/5/6.
 */

public class ScheduleListener implements TriggerListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleListener.class);

    @Autowired
    private EmailImp emailImp;

    @Override
    public String getName() {
        return "ScheduleListener";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        System.out.println("fire" + trigger.getKey().getName());
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        String name = trigger.getKey().getName();
        LOGGER.info(name + "have miss fire ");
        emailImp.sendSimpleMail("1053611095@qq.com",name+"监控情况报告","任务missfire请及时处理");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        String name = trigger.getKey().getName();
        LOGGER.info(name + "完成工作");
        if ("requestTrigger".equals(name)) {
            emailImp.sendSimpleMail("1053611095@qq.com",name+"监控情况报告","完成获取流量使用记录");
        }
    }
}
