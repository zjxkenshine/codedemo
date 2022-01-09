package com.kenshine.basic._04_Annotation.test08_AnnoLocalVariable;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 17:24
 * @description： 局部变量注解
 * @modified By：
 * @version: $
 */
public class Test08 {
    public static void test(){
        @LocalVariableAnno("局部变量注解")
        int aaaa = 1;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        //TODO 暂时找不到获取该注解信息的方法
    }
}
