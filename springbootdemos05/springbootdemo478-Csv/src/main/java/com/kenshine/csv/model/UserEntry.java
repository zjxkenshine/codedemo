package com.kenshine.csv.model;

import com.github.houbb.csv.annotation.CsvEntry;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 内嵌对象
 * @author Kenshine
 */
@Data
@Accessors(chain = true)
public class UserEntry {

    /**
     * 名称
     */
    private String name;

    /**
     * 内嵌的用户信息
     */
    @CsvEntry
    private User user;
}