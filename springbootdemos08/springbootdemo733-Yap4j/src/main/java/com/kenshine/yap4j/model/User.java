package com.kenshine.yap4j.model;

import com.polymathiccoder.yap4j.csv.annotation.CsvEntry;
import com.polymathiccoder.yap4j.csv.annotation.CsvFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author by kenshine
 * @Classname User
 * @Description 测试类
 * @Date 2024-03-09 10:39
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@CsvFile(fileName = "data/user.csv")
public class User {
    @CsvEntry(header = "id")
    private Integer id;
    @CsvEntry(header = "name")
    private String name;
    @CsvEntry(header = "age")
    private Integer age;
    @CsvEntry(header = "sex")
    private Sex sex;
    @CsvEntry(header = "birthday", format = "yyyy/MM/dd")
    private Date birthday;
}
