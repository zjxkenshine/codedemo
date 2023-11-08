package com.kenshine.datafactory.model;

import com.kenshine.datafactory.annotation.ConstStringData;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname UserDefineAnnotationData
 * @Description 自定义注解
 * @Date 2023-11-08 11:40
 * @modified By：
 * @version: 1.0$
 */
@Data
public class UserDefineAnnotationData {
    @ConstStringData("echo")
    private String name;

    @ConstStringData("game")
    private String hobby;
}
