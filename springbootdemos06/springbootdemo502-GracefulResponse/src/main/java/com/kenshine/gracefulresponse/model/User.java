package com.kenshine.gracefulresponse.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author by kenshine
 * @Classname User
 * @Description 測試類
 * @Date 2023-11-24 13:57
 * @modified By：
 * @version: 1.0$
 */
@Accessors(chain = true)
@Data
public class User {
    private Integer id;
    private String name;
}
