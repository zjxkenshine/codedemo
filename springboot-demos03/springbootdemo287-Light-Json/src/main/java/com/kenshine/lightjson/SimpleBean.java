package com.kenshine.lightjson;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname SimpleBean
 * @Description 测试Bean
 * @Date 2023-10-20 13:30
 * @modified By：
 * @version: 1.0$
 */
@Data
public class SimpleBean {
    private int id;
    private long version;
    private double percent;
    private String name;

    private Date date;
    private SimpleEnum simpleEnum;
    private Map<String, String> mapInstance;
    private List<String> list;

    enum SimpleEnum {
        EnumOne,
        EnumTwo,
        EnumThree
    }
}
