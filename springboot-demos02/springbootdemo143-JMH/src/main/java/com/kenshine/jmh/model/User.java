package com.kenshine.jmh.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/4 9:05
 * @description：测试模型
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    //id
    private Integer id;
    //名称
    private String name;
    //年龄
    private String age;
    //描述
    private String desc;

}
