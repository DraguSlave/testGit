/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: StaffRepository
 * Author:   Administrator
 * Date:     20/4/1/0001 15:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.jpa.repository;

import com.zerf.demo.jpa.domain.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/4/1/0001
 * @since 1.0.0
 */
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    List<Staff> queryByName(String name);

    List<Staff> queryByIdAndName(Integer id, String name);

    @Query("from staff")
    List<Staff> queryAllByHql();

    @Query(nativeQuery = true, value = "select * from staff")
    List<Staff> queryAllBySql();

    @Query(nativeQuery = true, value = "select * from staff")
    Page<Staff> queryAllBySqlAndPage(Pageable pageable);
}