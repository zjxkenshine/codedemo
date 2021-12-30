package com.kenshine.vavr.value;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/30 9:39
 * @description：
 * @modified By：
 * @version: $
 */
public class Person {
    public final String name;
    public final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person(" + name + ", " + age + ")";
    }
}
