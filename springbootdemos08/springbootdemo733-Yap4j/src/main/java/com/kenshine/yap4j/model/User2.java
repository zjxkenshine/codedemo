package com.kenshine.yap4j.model;

import com.polymathiccoder.yap4j.csv.annotation.CsvEntry;
import com.polymathiccoder.yap4j.csv.annotation.CsvFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author by kenshine
 * @Classname User2
 * @Description 不带表头解析
 * @Date 2024-03-09 11:08
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@CsvFile(fileName = "data/user2.csv", noHeader = true)
public class User2 {
    @CsvEntry(position = 0)
    private Integer id;
    @CsvEntry(position = 1)
    private String name;
    @CsvEntry(position = 2)
    private Integer age;
    @CsvEntry(position = 3)
    private Sex sex;
    @CsvEntry(position = 4, format = "yyyy/MM/dd")
    private Date birthday;
}
