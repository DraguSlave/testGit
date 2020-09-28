/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: StaffVo
 * Author:   Administrator
 * Date:     20/4/1/0001 15:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.jpa.domain.vo;

import com.zerf.demo.poi.entity.Staff;
import com.zerf.demo.util.PageableParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/4/1/0001
 * @since 1.0.0
 */

@Data
@ToString(callSuper = true)
@ApiModel(value = "staffVo", description = "staff页面参数")
public class StaffVo extends Staff {
    @ApiModelProperty(value = "分页")
    private PageableParam pageableParam;
}