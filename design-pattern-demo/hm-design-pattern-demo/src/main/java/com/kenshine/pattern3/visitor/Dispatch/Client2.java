package com.kenshine.pattern3.visitor.Dispatch;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 23:01
 * @description：静态分派
 * @modified By：
 * @version: $
 *
 * 重载方法的分派是根据静态类型进行的，这个分派过程在编译时期就完成了
 */
public class Client2 {

    public static void main(String[] args) {
        Animal a = new Animal();
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        //静态分派
        Execute exe = new Execute();
        exe.execute(a);
        exe.execute(a1);
        exe.execute(a2);

        //双分派
        Execute exe1 = new Execute();
        a.accept(exe1);
        a1.accept(exe1);
        a2.accept(exe1);
    }

}
