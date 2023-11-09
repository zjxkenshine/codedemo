package com.kenshine.lombokex;

import com.github.houbb.lombok.ex.annotation.ToString;
import com.github.houbb.lombok.ex.constant.ToStringType;

/**
 * @author by kenshine
 * @Classname ToStringConcat
 * @Description concat方式 toString
 * @Date 2023-11-09 8:30
 * @modified By：
 * @version: 1.0$
 */
@ToString(ToStringType.CONCAT)
public class ToStringConcat {
    private String name;
}
