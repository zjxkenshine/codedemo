package com.kenshine.pattern3.visitor.Dispatch;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 22:58
 * @description：动物
 * @modified By：
 * @version: $
 */
public class Animal {
    public void execute() {
        System.out.println("Animal");
    }

    /**
     * 双分派
     * 在选择一个方法的时候，不仅仅要根据消息接收者（receiver）的运行时区别，还要根据参数的运行时区别
     * @param exe
     */
    public void accept(Execute exe) {
        exe.execute(this);
    }
}
