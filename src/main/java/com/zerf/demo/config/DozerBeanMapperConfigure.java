/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DozerBeanMapperConfigure
 * Author:   Administrator
 * Date:     20/4/2/0002 16:03
 * Description: dozer配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈dozer配置〉
 *
 * @author Administrator
 * @create 20/4/2/0002
 * @since 1.0.0
 */
@Configuration
public class DozerBeanMapperConfigure {
    @Bean
    public DozerBeanMapper mapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper;
    }
}
