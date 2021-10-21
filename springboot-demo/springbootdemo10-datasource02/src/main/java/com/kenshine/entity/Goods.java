package com.kenshine.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 10:26
 * @description：商品类
 * @modified By：
 * @version: $
 */
@Entity
@Table(name = "goods")
@Data
public class Goods {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

}
