/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: JpaController
 * Author:   Administrator
 * Date:     20/4/1/0001 14:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.jpa.controller;

import com.zerf.demo.jpa.domain.entity.Staff;
import com.zerf.demo.jpa.domain.vo.StaffVo;
import com.zerf.demo.jpa.repository.StaffDao;
import com.zerf.demo.jpa.repository.StaffRepository;
import io.swagger.annotations.*;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/4/1/0001
 * @since 1.0.0
 */
@Api(value = "测试jpa", description = "jpa接口", tags = "jpa的使用")
@RestController("/staff")
public class JpaController {
    private final Logger logger = LoggerFactory.getLogger(JpaController.class);

    @Autowired
    private Mapper dozerMapper;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private StaffDao staffDao;

    @ApiOperation(value = "staff", notes = "查询全部staff")
    @GetMapping("/findAll")
    public List<Staff> queryAll() {
        return staffRepository.findAll();
    }

    @ApiOperation(value = "staff", notes = "分页查询staff")
    @GetMapping("/list")
    public Page<Staff> queryStaffList() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return staffRepository.findAll(PageRequest.of(0, 2, sort));
    }

    @ApiOperation(value = "staff", notes = "按name查询staff")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staff", required = false, dataType = "String", paramType = "query"),
    })
    @GetMapping("/searchByName")
    public List<Staff> queryByName(Staff staff) {
        return staffRepository.queryByName(staff.getName());
    }


    @ApiOperation(value = "staff", notes = "按id和name查询staff")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staff", required = false, dataType = "String", paramType = "query"),
    })
    @GetMapping("/search")
    public List<Staff> queryByIdAndName(Staff staff) {
        return staffRepository.queryByIdAndName(staff.getId(), staff.getName());
    }

    @ApiOperation(value = "新增staff", notes = "新增staff")
    @PostMapping("/add")
    public String addStaff(@RequestBody @ApiParam(name = "需要新增的staff", value = "需要新增的staffValue") StaffVo staffVo) {
        logger.info("===>新增staff对象为{}", staffVo.toString());
        Staff staff = dozerMapper.map(staffVo, Staff.class);
        logger.info("===>vo转entity staff对象为{}", staff.toString());
        staffRepository.save(staff);
        return "保存成功";
    }


    @ApiOperation(value = "staff", notes = "使用hql查询全部staff")
    @GetMapping("/findAllByHql")
    public List<Staff> queryAllByHql() {
        return staffRepository.queryAllByHql();
    }

    @ApiOperation(value = "staff", notes = "使用sql查询全部staff")
    @GetMapping("/findAllBySql")
    public List<Staff> queryAllBySql() {
        return staffRepository.queryAllBySql();
    }

    @ApiOperation(value = "staff", notes = "使用sql分页查询staff")
    @GetMapping("/findAllBySqlAndPage")
    public Page<Staff> queryAllBySqlAndPage() {
        return staffRepository.queryAllBySqlAndPage(PageRequest.of(0, 2, new Sort(Sort.Direction.DESC, "id")));
    }

    @ApiOperation(value = "staff", notes = "使用sql本地分页查询staff")
    @PostMapping("/nativeFindAll")
    public List<Staff> nativeFindAll(@RequestBody @ApiParam(name = "需要查询的staff条件", value = "需要查询的staff条件Value") StaffVo staffVo) {
        logger.info("===>查询条件staff对象为{}", staffVo.toString());
        Staff staff = dozerMapper.map(staffVo, Staff.class);
        logger.info("===>vo转entity staff对象为{}", staff.toString());
        Pageable pageable = PageRequest.of(staffVo.getPageableParam().getPage(), staffVo.getPageableParam().getSize());
        return staffDao.nativeFindAll(staff, pageable);
    }

}