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

package com.zerf.demo.jpa.domain.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 〈一句话功能简述〉<br>
 * 〈jpa实体类〉
 *
 * @author Administrator
 * @create 19/4/30/0030
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "staff")
@Table(name = "staff")
public class Staff {
    @Id
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

}