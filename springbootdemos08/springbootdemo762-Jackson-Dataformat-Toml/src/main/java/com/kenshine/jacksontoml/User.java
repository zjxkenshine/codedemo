package com.kenshine.jacksontoml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author by kenshine
 * @Classname User
 * @Description 测试类
 * @Date 2024-03-31 8:42
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private List<String> hobbies;
    private User friend;
}
