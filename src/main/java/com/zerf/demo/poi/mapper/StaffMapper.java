package com.zerf.demo.poi.mapper;

import com.zerf.demo.poi.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StaffMapper {
    List<Staff> list();

    Integer insertByList(@Param("staffList") List<Staff> staffList);
}