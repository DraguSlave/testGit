/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: StaffService
 * Author:   Administrator
 * Date:     19/4/30/0030 9:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.poi.service;

import com.zerf.demo.poi.entity.Staff;
import com.zerf.demo.poi.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19/4/30/0030
 * @since 1.0.0
 */
@Service
public class StaffService {
    @Autowired
    private StaffMapper staffMapper;

    public List<Staff> list(){
        return staffMapper.list();
    }

    public Integer saveByList(List<Staff> staffList) {
        return staffMapper.insertByList(staffList);
    }
}