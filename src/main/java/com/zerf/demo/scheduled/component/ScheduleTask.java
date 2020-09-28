/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuartzController
 * Author:   Administrator
 * Date:     19/4/10/0010 16:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.scheduled.component;

import com.zerf.demo.scheduled.service.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19/4/10/0010
 * @since 1.0.0
 */
//@Component
public class ScheduleTask {

    @Autowired
    private ScheduledService scheduledService;

    @Scheduled(cron = "3/2 * * * * ?")
    public void schedulezTest(){
     scheduledService.output();
    }

//    @Scheduled(cron = "0/3 * * * * *")
//    public void scheduleTest2(){
//     scheduledService.output();
//    }
}