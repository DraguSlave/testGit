/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuartzService
 * Author:   Administrator
 * Date:     19/4/10/0010 16:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.scheduled.service;

import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 19/4/10/0010
 * @since 1.0.0
 */
//@Service
public class ScheduledService {
    private Integer count = 0;

    public void output() {
        System.out.println("第" + count++ + "次运行" + new Date());
    }
}