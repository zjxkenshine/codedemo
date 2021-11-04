package com.kenshine.framework.utils;

/**
 * @version v1.0
 * @ClassName: StringUtils
 * @Description: 字符串工具类
 * @Author: kenshine
 */
public class StringUtils {
    private StringUtils() {
    }

    // userDao   ==>   setUserDao
    public static String getSetterMethodByFieldName(String fieldName) {
        String methodName = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
        return methodName;
    }
}
