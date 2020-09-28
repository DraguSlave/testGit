/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: StaffDao
 * Author:   Administrator
 * Date:     20/4/3/0003 15:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.jpa.repository;

import com.zerf.demo.jpa.domain.entity.Staff;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 20/4/3/0003
 * @since 1.0.0
 */
public interface StaffDao {

    List<Staff> nativeFindAll(Staff staff, Pageable pageable);
}