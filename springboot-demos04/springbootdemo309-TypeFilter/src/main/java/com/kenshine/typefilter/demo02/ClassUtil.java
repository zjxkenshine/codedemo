package com.kenshine.typefilter.demo02;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 9:24
 * @description：
 * @modified By：
 * @version: $
 */
public class ClassUtil {
    private ClassUtil() {}

    public static Class loadClass(String className) throws ClassNotFoundException {
        Class theClass = null;
        try {
            theClass = Class.forName(className);
        }
        catch (ClassNotFoundException e1) {
            try {
                theClass = Thread.currentThread().getContextClassLoader().loadClass(className);
            }
            catch (ClassNotFoundException e2) {
                theClass = ClassUtil.class.getClassLoader().loadClass(className);
            }
        }
        return theClass;
    }
}
