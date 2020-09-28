/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SwaggerConfig
 * Author:   Administrator
 * Date:     20/1/6/0006 15:42
 * Description: swagger配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 〈一句话功能简述〉<br>
 * 〈swagger配置〉
 *
 * @author Administrator
 * @create 20/1/6/0006
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    ///**
    // * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    // */
    //@Bean
    //public Docket createRestApi() {
    //
    //    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
    //            .select()
    //            .apis(RequestHandlerSelectors.basePackage("com.zerf.demo"))
    //            /*       .apis(RequestHandlerSelectors.withClassAnnotation(Controller.class))*/
    //            .paths(PathSelectors.any())
    //            .build();
    //}

    /**
     * 创建API应用 apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     */
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zerf.demo"))
                .paths(PathSelectors.any())
                .build();
    }


    /**
     * 构建 api文档的信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格")
                //.termsOfServiceUrl("https://")
                .version("1.0")
                .build();
    }
}