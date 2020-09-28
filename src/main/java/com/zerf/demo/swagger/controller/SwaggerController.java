/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SwaggerController
 * Author:   Administrator
 * Date:     20/1/6/0006 15:59
 * Description: swagger控制区
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.swagger.controller;

import com.zerf.demo.swagger.vo.SwaggerTestVO;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈swagger控制器〉
 *
 * @author Administrator
 * @create 20/1/6/0006
 * @since 1.0.0
 */
@Controller
@Api(value = "swagger使用", tags = "swagger的介绍")
public class SwaggerController {

    @ApiOperation(value = "右侧小介绍", notes = "这里是详细文档", tags = "标题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "name", required = false, dataType = "String", paramType = "query"),
    })
    @ResponseBody
    @PostMapping("/testSwagger")
    public SwaggerTestVO testSwagger(String id, String name, @RequestBody @ApiParam(name = "参数", value = "用来测试的参数") SwaggerTestVO swaggerTestVO) {
        Map<String, Object> result = new HashMap<>();
        result.put(id, name);
        result.put(swaggerTestVO.getKey(), swaggerTestVO.getValue());
        return swaggerTestVO;
    }
}