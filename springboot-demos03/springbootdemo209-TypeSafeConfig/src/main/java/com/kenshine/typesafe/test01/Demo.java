package com.kenshine.typesafe.test01;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/29 9:29
 * @description：Demo实体类，配置的某个键
 * @modified By：
 * @version: $
 */
@Data
public class Demo {
    private String name;
    private int age;
    private boolean men;
    // list类型
    private List<String> address;
    // map类型
    private Map<String, Object> family;
}
