package com.kenshine.jsonpath.domain;

import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/26 22:27
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class Book {
    private String category;
    private String author;
    private String title;
    private Double price;
}
