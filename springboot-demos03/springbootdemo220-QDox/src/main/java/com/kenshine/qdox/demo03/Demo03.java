package com.kenshine.qdox.demo03;

import java.io.Serializable;
import java.util.List;

/**
 * @author kenshine
 */
public abstract class Demo03 extends SuperClass implements Serializable,CustomInterface {
    private List<List> list;
    private String name;
    public void doStuff() {
        System.out.println("do something");
    }
    private int getNumber() {
        return 1;
    }
}
