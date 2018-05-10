package com.lstfight.qmonitorquartz.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


import java.io.IOException;
import java.util.Properties;

/**
 * <p>丢弃的配置文件  采用了已有的starter方式/p>
 * @author lst
 * Created on 2018/5/5.
 */

public class BaseConfig {

    @Bean(name="SchedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException, SchedulerException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        return factory;
    }

/*    @Bean("properties")
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("quartza.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }*/


 /* @Bean(name="quartzScheduler")
    public Scheduler scheduler() throws IOException, SchedulerException {
        final Scheduler scheduler = schedulerFactoryBean().getScheduler();
        scheduler.start();
        return scheduler;
    }*/

    /**
     * 这个listener会监听容器的启动 自动加载初始化一个scheduler
     * @return listener
     */
   /* @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }
    */



}
