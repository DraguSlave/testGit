/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Staff
 * Author:   Administrator
 * Date:     19/4/30/0030 8:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.poi.entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 19/4/30/0030
 * @since 1.0.0
 */
public class Staff {
    private Integer id;
    private String name;

    public Staff() {
    }

    public Staff(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}