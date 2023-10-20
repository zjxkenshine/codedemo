package com.kenshine.jsonsmart;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 7:46
 * @description：
 * @modified By：
 * @version: $
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
