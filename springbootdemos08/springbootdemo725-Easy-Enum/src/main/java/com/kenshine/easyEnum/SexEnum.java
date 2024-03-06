package com.kenshine.easyEnum;

import com.robot.dict.Dict;

/**
 * @author by kenshine
 * @Classname SexEnum
 * @Description 性别枚举
 * @Date 2024-03-06 8:12
 * @modified By：
 * @version: 1.0$
 */
public enum SexEnum implements Dict<Integer> {
    MALE(1, "男"),
    FEMALE(2, "女"),
    UNKNOWN(3, "未知"),
    @Deprecated
    OTHER(4, "其他");

    SexEnum(Integer code, String text) {
        // 一个init方法搞定，该方法来自Dict接口
        init(code, text);
    }
}
