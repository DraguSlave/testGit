/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyAdaptableFactory
 * Author:   Administrator
 * Date:     19/4/11/0011 14:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.config;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 19/4/11/0011
 * @since 1.0.0
 */

/**
 * 该方法需要将需要实例化的对象放入spring中
 */
//@Component("myAdaptableFactory")
public class MyAdaptableFactory extends AdaptableJobFactory {

    //AutowireCapableBeanFactory 可以将对象添加到spring容器中
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object object = super.createJobInstance(bundle);
        //注入对象
        autowireCapableBeanFactory.autowireBean(object);
        return object;
    }
}