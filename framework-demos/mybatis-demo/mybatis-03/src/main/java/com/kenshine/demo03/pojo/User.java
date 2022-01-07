package com.kenshine.demo03.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author kenshine
 * @create 2020-10-30 15:50
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
//自定义Mybatis别名为hello
//@Alias("hello")
public class User {
    private int id;
    private String name;
    private String password;

}
