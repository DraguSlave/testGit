/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuartzMain
 * Author:   Administrator
 * Date:     19/4/11/0011 11:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.scheduled;

import com.zerf.demo.scheduled.component.QuartzJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 19/4/11/0011
 * @since 1.0.0
 */
public class QuartzMain {
    public static void main(String args[]) throws SchedulerException {
        //1.创建job对象
        JobDetail job = JobBuilder.newJob(QuartzJob.class).build();

        //2.创建trigger触发器 参数:1简单触发时间(quartz自身提供的方式),2cron表达式
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();

        //3.创建scheduled对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job, trigger);

        scheduler.start();
    }

}