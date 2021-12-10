package com.kenshine.fastjson.pojo.test;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/10 11:03
 * @description：测试实体类
 * @modified By：
 * @version: $
 */
@lombok.Data
public class Data implements Serializable {
    private static final long serialVersionUID = -6957361951748382519L;
    private String id;
    private String suborderNo;
    private String organUnitType;
    private String action;
    private String parent;
    private String organUnitFullName;
    private Long ordinal;
}
