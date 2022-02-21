package com.kenshine.designpattern.gof16_Template.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/21 22:17
 * @description：
 * @modified By：
 * @version: $
 */
public abstract class AbstractClass {
    public abstract void method1();
    public abstract void method2();

    public final void TemplateMethod() {
        System.out.println("步骤一.....................");
        method1();
        System.out.println("步骤二.....................");
        method2();
        System.out.println("步骤三.....................");
    }
}
