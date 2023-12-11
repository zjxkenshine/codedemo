package com.kenshine.streamex.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author by kenshine
 * @Classname Role
 * @Description 角色
 * @Date 2023-12-11 13:12
 * @modified By：
 * @version: 1.0$
 */
@Data
@Accessors(chain = true)
public class Role {
    private String name;
    private Boolean enable;
}
