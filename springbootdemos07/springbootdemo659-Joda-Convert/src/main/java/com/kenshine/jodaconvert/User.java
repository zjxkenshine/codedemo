package com.kenshine.jodaconvert;

import lombok.Data;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

/**
 * @author by kenshine
 * @Classname User
 * @Description 用户类
 * @Date 2024-01-08 13:39
 * @modified By：
 * @version: 1.0$
 */
@Data
public class User {
    private String name;

    /**
     *  需要自定义转换方法
     */
    @FromString
    public static User parse(String str) {
        User user = new User();
        user.setName(str);
        return user;
    }

    @ToString
    public String getString() {
        return name;
    }
}
