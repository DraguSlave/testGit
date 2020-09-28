/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PageableParam
 * Author:   Administrator
 * Date:     20/4/3/0003 16:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/4/3/0003
 * @since 1.0.0
 */
@ApiModel("PageableParam")
public class PageableParam {
    private int page;
    private int size;
    private String[] sort;

    public PageableParam() {
    }

    public PageableParam(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public PageableParam(int page, int size, String[] sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    @ApiModelProperty(
            value = "指定第几页",
            dataType = "int",
            example = "0",
            allowableValues = "range[0, infinity]"
    )
    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @ApiModelProperty(
            value = "每页的记录数",
            dataType = "int",
            example = "15",
            allowableValues = "range[1, infinity]"
    )
    public int getSize() {
        return this.size == 0 ? 20 : this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @ApiModelProperty("属性排序以及排序顺序")
    public String[] getSort() {
        return this.sort;
    }

    public void setSort(String[] sort) {
        this.sort = sort;
    }
}
