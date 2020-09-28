/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SwaggerTestVO
 * Author:   Administrator
 * Date:     20/1/6/0006 16:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.swagger.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/1/6/0006
 * @since 1.0.0
 */
@ApiModel(value = "参数实体类", description = "这是参数类的介绍")
public class SwaggerTestVO {

    @ApiModelProperty(value = "这个是键", name = "key", example = "例如key")
    private String key;

    @ApiModelProperty(value = "这个是值", name = "value", example = "例如value")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}