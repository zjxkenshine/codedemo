package com.kenshine.compiletest;

/**
 * 测试编译期注解
 * @author kenshine
 */
public class AnnotationedExample {
    @AAA
    public int breakBuild() {
        return -1;
    }

    @AAA
    public String willCompile(StringBuilder sb) {
        return null;
    }
}