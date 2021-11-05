package com.kenshine.pattern.prototype.demo;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 21:37
 * @description：原型类
 * @modified By：
 * @version: $
 */
public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("具体的原型对象创建完成！");
    }

    @Override
    protected Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Realizetype) super.clone();
    }
}