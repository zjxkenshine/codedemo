package com.kenshine.pattern3.visitor.Dispatch;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 22:58
 * @description：狗
 * @modified By：
 * @version: $
 */
public class Dog extends Animal{
    @Override
    public void execute() {
        System.out.println("dog");
    }

    @Override
    public void accept(Execute exe) {
        exe.execute(this);
    }
}
