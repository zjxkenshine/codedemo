package com.kenshine.classgraph;

import io.github.classgraph.*;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname ClassgraphTest
 * @Description 基本使用
 * @Date 2023-12-20 11:46
 * @modified By：
 * @version: 1.0$
 */
public class ClassgraphTest {

    /**
     * 基本使用 遍历某个包下的方法，信息列表
     */
    @Test
    public void test01(){
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages("com.kenshine.classgraph").scan()) {
            ClassInfoList allClasses = scanResult.getAllClasses();
            // allClass.getInterfaces(); 获取所有接口
            for (ClassInfo allClass : allClasses) {
                ClassInfoList methodInfo = allClass.getAnnotations();
                MethodInfoList methodInfos = allClass.getMethodInfo();
                String className = allClass.getName();

                System.out.println("方法信息:\n" + methodInfo);
                System.out.println("方法信息列表:\n" + methodInfos);
                System.out.println("类名\n" + className);
            }
        }
    }

    /**
     * 查找某个路径下，被@xx注解标识的所有类
     */
    @Test
    public void test02(){
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages("com.kenshine.classgraph")
                .scan()) {
            // 返回所有被@Data修饰的类
            ClassInfoList allClasses = scanResult.getClassesWithAnnotation("com.kenshine.classgraph.TT");

            for (ClassInfo allClass : allClasses) {
                ClassInfoList methodInfo = allClass.getAnnotations();
                MethodInfoList methodInfos = allClass.getMethodInfo();
                String className = allClass.getName();

                System.out.println("方法信息:\n" + methodInfo);
                System.out.println("方法信息列表:\n" + methodInfos);
                System.out.println("类名\n" + className);
            }
        }
    }
}
