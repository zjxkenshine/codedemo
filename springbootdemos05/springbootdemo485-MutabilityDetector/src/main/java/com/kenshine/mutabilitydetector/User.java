package com.kenshine.mutabilitydetector;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname User
 * @Description 不可变类
 * @Date 2023-11-16 11:44
 * @modified By：
 * @version: 1.0$
 */
@AllArgsConstructor
public final class User {
    private final String name;
    private final String value;
}
