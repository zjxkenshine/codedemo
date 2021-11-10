package com.kenshine.juc.blog.juc01;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 23:57
 * @description：Callable创建线程
 * @modified By：
 * @version: $
 *
 * 	创建线程的方式三: 实现callable接口 ---JDK 5.0 新增
 * 	1.创建一个实现Callable接口的实现类
 * 	2.实现call方法,将此线程需要执行的操作声明在call()中
 * 	3.创建callable接口实现类的对象
 * 	4.将此callable的对象作为参数传入到FutureTask构造器中,创建FutureTask的对象
 * 	5.将FutureTask对象作为参数传递到Thread类的构造器中,创建Thread对象,并调用star
 * 	6.获取callable接口中call方法的返回值
 */
public class CallableDemo {

    public static void main(String[] args) {
        //3.创建callable接口实现类的对象
        NumThead m=new NumThead();
        //4.将此callable的对象作为参数传入到FutureTask构造器中,创建FutureTask的对象

        FutureTask futureTask = new FutureTask(m);
        //5.将FutureTask对象作为参数传递到Thread类的构造器中,创建Thread对象,并调用start()方法
        //FutureTask类继承了Runnable接口
        //new Runnable = futureTask;
        new Thread(futureTask).start();

        //6.获取callable接口中call方法的返回值
        try {
            //get()方法返回值即为FutureTask构造器参数callable实现类重写的call方法的返回值
            Object sum = futureTask.get();
            System.out.println("总和是:"+sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

//1.创建一个实现Callable接口的实现类
class  NumThead implements Callable {
    // class  NumThead implements Callable<Integer>{
    //2.实现call方法,将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        //public Integer call() throws Exception {
        int sum=0;
        for(int i=1;i<=100;i++){
            System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}