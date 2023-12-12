package com.kenshine.redisx.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author by kenshine
 * @Classname OrderDo
 * @Description 测试类
 * @Date 2023-12-12 9:46
 * @modified By：
 * @version: 1.0$
 */
@Data
public class OrderDo  implements Serializable {
    private static final long SerialVersionUID=7788999100L;
    private Integer id;
    private String traceId;
    private String note;
}
