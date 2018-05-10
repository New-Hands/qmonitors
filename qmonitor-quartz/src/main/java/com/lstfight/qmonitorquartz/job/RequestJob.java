package com.lstfight.qmonitorquartz.job;

import com.lstfight.qmonitorquartz.request.AtomicIntergerResouce;
import com.lstfight.qmonitorquartz.request.Requester;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *<p>采用工作流的方式进行调度如何 需要进行这样的安排u</p>
 *
 * @author lst
 * Created on 2018/5/5.
 */
public class RequestJob extends QuartzJobBean {

    @Autowired
    private Requester requester;
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestJob.class);
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
       // LOGGER.info(requester.initialResouce(new AtomicIntergerResouce()).execute());
        requester.initialResource(new AtomicIntergerResouce()).execute();

    }
}
