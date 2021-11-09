package com.kenshine.influxdb.utils;

import org.nutz.lang.Lang;

import java.lang.reflect.Field;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 16:42
 * @description：反射工具类
 * @modified By：
 * @version: $
 */
public class ReflectUtils {
    /**
     * 类中获取使用了某个注解的字段
     * @param object
     * @param annotation
     */
    public static String getField(Object object, Class annotation) {
        Object first = Lang.first(object);
        Class clazz = first.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Boolean isAnon = field.isAnnotationPresent(annotation);
            if (isAnon) {
                return field.getName();
            }
        }
        return null;
    }
}
