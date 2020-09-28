/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuartzJob
 * Author:   Administrator
 * Date:     19/4/11/0011 11:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.scheduled.component;

import com.zerf.demo.scheduled.service.ScheduledService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 19/4/11/0011
 * @since 1.0.0
 */
//@Component
public class QuartzJob implements Job {

    @Autowired
    private ScheduledService scheduledService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        scheduledService.output();
    }
}