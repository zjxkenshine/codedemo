package com.kenshine.basic._01_base;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/8 22:52
 * @description：内部类
 * @modified By：
 * @version: $
 *
 * 权限修饰符定义规则：
 *
 * 	* 1.外部类：public / (default)
 * 	* 2.成员内部类：public / protected / (default) / private
 * 	* 3.局部内部类：什么都不能写
 *
 * 局部内部类，如果希望访问所在方法的局部变量，如上面的num，那么这个局部变量必须是有效final的
 * 有效final：Java8新特性
 * 只有局部变量事实不变，final关键字可以省略
 *
 */
public class test07_inner {
    public static void main(String[] args) {
        //其他地方调用外部类方法
        Body body=new Body();
        body.methodBody();

        //内部非静态类
        Body.Heart heart=new Body().new Heart();
        heart.methodHeart();

        //局部内部类
        new Outer().methodOuter();

        //匿名内部类
        new Thread(){
            @Override
            public void run() {
                System.out.println("start");
            }
        }.start();
    }
}

class Body {

    public class Heart{
        public void methodHeart(){
            //内部类可访问外部类静态成员变量
            System.out.println("内部类方法 "+name);
        }
    }

    //外部类成员变量
    private String name="外部类成员";
    public void methodBody(){
        System.out.println("外部类方法");
    }
}

//局部内部类
//一个类是定义在一个方法内部的
 class Outer {
    public void methodOuter(){
        //final问题 java8新特性 有效final
        int num=10;
        class Inner{
            public void methodInner(){
                //访问外部类局部变量
                System.out.println("内部类方法，num="+num);
            }
        }
        Inner inner=new Inner();
        inner.methodInner();
    }
}