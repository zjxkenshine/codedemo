package com.kenshine.basic._03_reflect;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 13:33
 * @description：
 * @modified By：
 * @version: $
 */
public class Student {

    public String name;
    private int age;

    public Student(){
    }
    public Student(String name){
        System.out.println("录入的名字是： " + name);
    }
    private Student(int age){
        System.out.println("录入的年龄是： " + age);
    }

    public void show1(){
        System.out.println("公共的空参方法");
    }

    public void show2(int a){
        System.out.println("公共的带参方法");
    }

    private int show3(int a,int b){
        System.out.println("私有的带参方法");
        return a+b;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
