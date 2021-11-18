package com.kenshine.kryo.demo01;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 15:05
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class TestSerialization implements Serializable {

    private static final long serialVersionUID = -5592083260077139114L;
    private String text;
    private String name;
    private Integer id;
    private Boolean flag;
    private List<String> list;
    private SubTestSerialization subTestSerialization;

}
