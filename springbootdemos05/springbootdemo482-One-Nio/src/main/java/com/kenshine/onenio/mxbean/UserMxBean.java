package com.kenshine.onenio.mxbean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname UserMxBean
 * @Description UserMxBean
 * @Date 2023-11-15 12:11
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
public class UserMxBean implements UserBean{
    private String name;
}
