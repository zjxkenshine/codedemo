package com.kenshine.crane4j.Test03;

import cn.crane4j.annotation.AssembleEnum;
import cn.crane4j.annotation.Mapping;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author by kenshine
 * @Classname Test02Enum03
 * @Description 选项式Enum
 * @Date 2023-10-16 13:14
 * @modified By：
 * @version: 1.0$
 */
public class Test02Enum03 {
    @RequiredArgsConstructor
    @Data
    private static class Foo {
        // 选项式风格配置
        @AssembleEnum(
                type = Gender.class, enumKey = "code",
                props = @Mapping(ref = "cnName")
        )
        private final Integer id;
        private String cnName;
        private Gender gender;
    }

    @Getter
    @RequiredArgsConstructor
    private enum Gender {
        FEMALE(0, "女", "female"), MALE(1, "男", "male");
        private final Integer code;
        private final String cnName;
        private final String enName;
    }
}
