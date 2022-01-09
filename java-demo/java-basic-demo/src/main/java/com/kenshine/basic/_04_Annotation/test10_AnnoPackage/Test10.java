package com.kenshine.basic._04_Annotation.test10_AnnoPackage;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 18:36
 * @description：
 * @modified By：
 * @version: $
 */
public class Test10 {
    public static void main(String[] args) {
        // 获取包信息
        Package packageInfo = Package.getPackage("com.kenshine.basic._04_Annotation.test10_AnnoPackage");
        // 获取包注解
        PackageAnno packageAnno = packageInfo.getAnnotation(PackageAnno.class);
        System.out.println(packageAnno.version());
    }
}
