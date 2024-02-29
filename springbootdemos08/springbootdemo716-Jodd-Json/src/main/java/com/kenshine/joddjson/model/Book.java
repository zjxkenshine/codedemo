package com.kenshine.joddjson.model;

import lombok.Data;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Book
 * @Description 序列化实例
 * @Date 2024-02-29 15:58
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Book {
    private String name;
    private Integer year;
    private List<String> authors;
}
