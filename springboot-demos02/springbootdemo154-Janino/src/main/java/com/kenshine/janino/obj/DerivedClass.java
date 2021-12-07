package com.kenshine.janino.obj;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/7 9:15
 * @description：
 * @modified By：
 * @version: $
 */
public class DerivedClass extends BaseClass {
    private String name;

    public DerivedClass(String baseId, String name) {
        super(baseId);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + "DerivedClass [name=" + name + "]";
    }
}
