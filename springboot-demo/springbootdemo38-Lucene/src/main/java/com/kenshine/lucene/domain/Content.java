package com.kenshine.lucene.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/1 9:27
 * @description：内容
 * @modified By：
 * @version: $
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String price;

    private String img;

    private String descs;

}
