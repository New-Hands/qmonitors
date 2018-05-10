package com.lstfight.qmonitorquartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author lst
 * Created on 2018/5/5.
 */
public class NormalJob extends QuartzJobBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(NormalJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LOGGER.info("normal job");
    }
}
