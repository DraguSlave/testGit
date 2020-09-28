/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuartzConfig
 * Author:   Administrator
 * Date:     19/4/11/0011 13:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.config;

import com.zerf.demo.scheduled.component.QuartzJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 19/4/11/0011
 * @since 1.0.0
 */
//@Configuration
public class QuartzConfig {
    //1.创建job
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(QuartzJob.class);
        return factory;
    }

    //2.trigger,简单
//    @Bean
//    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
//        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
//        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
//        //参数表示一个执行毫秒数
//        factoryBean.setRepeatInterval(2000);
//        //重复次数
//        factoryBean.setRepeatCount(5);
//        return factoryBean;
//    }

    //2.trigger,cron
    @Bean
    public CronTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //参数表示一个执行毫秒数
        factoryBean.setCronExpression("0/2 * * * * ?");
        return factoryBean;
    }

    //3.scheduled
//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean) {
//        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
//        factoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
//        return factoryBean;
//    }
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean, MyAdaptableFactory myAdaptableFactory) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        //将MyAdaptableFactory注入
        factoryBean.setJobFactory(myAdaptableFactory);
        return factoryBean;
    }

}