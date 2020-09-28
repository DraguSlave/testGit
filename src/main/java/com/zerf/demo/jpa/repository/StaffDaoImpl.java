/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: StaffDaoImpl
 * Author:   Administrator
 * Date:     20/4/3/0003 15:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.jpa.repository;

import com.zerf.demo.jpa.domain.entity.Staff;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/4/3/0003
 * @since 1.0.0
 */
@Repository
public class StaffDaoImpl implements StaffDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Staff> nativeFindAll(Staff staff, Pageable pageable) {
        StringBuffer sql = new StringBuffer();
        Map<String, Object> params = new HashMap<>();
        sql.append("select t.id, t.name from staff t")
                .append(" where 1=1");
        if (staff.getId() != null) {
            sql.append(" and t.id = :id");
            params.put("id", staff.getId());
        }
        if (StringUtils.isNotEmpty(staff.getName())) {
            sql.append(" and t.name = :name");
            params.put("name", staff.getName());
        }
        Query query = entityManager.createQuery(sql.toString());
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        query.setFirstResult((int)pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();
    }
}