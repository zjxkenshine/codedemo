package com.kenshine.lombokex;

import com.github.houbb.lombok.ex.annotation.Serial;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname User
 * @Description @Serial注解
 * @Date 2023-11-09 8:20
 * @modified By：
 * @version: 1.0$
 */
@Data
@Serial
public class User {
    private String name;
}
