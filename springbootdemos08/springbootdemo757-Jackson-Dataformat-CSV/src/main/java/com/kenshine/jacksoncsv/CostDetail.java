package com.kenshine.jacksoncsv;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author by kenshine
 * @Classname CostDetail
 * @Description 测试类
 * @Date 2024-03-27 10:33
 * @modified By：
 * @version: 1.0$
 */
@Data
public class CostDetail {
    private BigDecimal amount;
    private Long applyId;
    private Long costCenterId;
    private Date createdTime;
    private Long status;
    private Long typeId;
    private String typeName;
    private Long userId;
}
