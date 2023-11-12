package com.kenshine.csv.model;

import com.github.houbb.csv.annotation.CsvEntry;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 特殊字符支持
 * @author Kenshine
 */
@Data
public class UserEscape {

    /**
     * 使用 ,
     */
    private String name;

    /**
     * 使用 map =
     */
    private Map<String, String> map;

    /**
     * 使用 |
     */
    private List<String> nameList;

    /**
     * 使用 :
     */
    @CsvEntry
    private User user;
}