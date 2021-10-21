package com.kenshine.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 8:55
 * @description：用户实体类
 * @modified By：
 * @version: $
 */
@Entity
@Data
public class User {
    @Id //主键
    private Integer id;

    private String name;

    private String sex;
}
