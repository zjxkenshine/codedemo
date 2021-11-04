package com.kenshine.pattern3.visitor.Dispatch;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 22:58
 * @description：猫
 * @modified By：
 * @version: $
 */
public class Cat extends Animal{
    @Override
    public void execute() {
        System.out.println("cat");
    }

    @Override
    public void accept(Execute exe) {
        exe.execute(this);
    }

}
