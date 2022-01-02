package com.kenshine.springshell.method;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 19:28
 * @description：
 * @modified By：
 * @version: $
 */
@ShellComponent
public class HelloWorld {
    /**
     * hello命令 描述为 say hello
     *
     * hello kenshine
     */
    @ShellMethod("Say hello")
    public void hello(String name) {
        System.out.println("hello, " + name + "!");
    }

    // 1.使用属性value定义命令描述
    // 2.使用属性key定义命令名称
    // 3.使用属性prefix定义参数前缀
    // 4.使用属性group定义命令分组
    // sum 1 2
    // sum -a 1 -b 2
    @ShellMethod(value = "Add numbers.", key = {"sum", "addition"}, prefix = "-", group = "Cal")
    public void add(int a,int b){
        int sum = a + b;
        System.out.println(String.format("%d + %d = %d", a, b, sum));
    }


    /**
     * ShellOption("--third") 为第三个参数指定名称为“third”
     * echo --a 1 --b 2 --third 3
     */
    @ShellMethod("Echo params")
    public void echo(int a, int b, @ShellOption("--third") int c) {
        System.out.println(String.format("a=%d, b=%d, c=%d", a, b, c));
    }

    /**
     * ShellOption 为命令参数指定多个名称
     * myhelp -C echo
     * myhelp --command 1
     */
    @ShellMethod("Echo command help")
    public void myhelp(@ShellOption({"-C", "--command"}) String cmd) {
        System.out.println(cmd);
    }

    /**
     * @ShellOption(defaultValue = "World")
     * 指定默认参数值
     * hello2
     * hello2 kenshine
     */
    @ShellMethod("Say hello")
    public void hello2(@ShellOption(defaultValue = "World") String name) {
        System.out.println("hello, " + name + "!");
    }


    /**
     * 参数为一个数组
     * add-by-array 1 2 3
     * 只能传递三个参数
     */
    @ShellMethod("Add by array")
    public void addByArray(@ShellOption(arity = 3) int[] numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        System.out.println(String.format("sum=%d", sum));
    }

    // 参数为集合
    // add-by-list 4 5 6
    @ShellMethod("Add by list")
    public void addByList(@ShellOption(arity = 3) List<Integer> numbers) {
        int s = 0;
        for(int number : numbers) {
            s += number;
        }
        System.out.println(String.format("s=%d", s));
    }


    // 参数为Boolean类型
    //shutdown  结果为false
    //shutdown --shutdown  结果为true
    //shutdown --shutdown true 出错
    @ShellMethod("Shutdown action")
    public void shutdown(boolean shutdown) {
        System.out.println(String.format("shutdown=%s", shutdown));
    }


    // 带空格的参数需要使用引号引起来
    //echo1 'Hello World'
    @ShellMethod("Echo.")
    public void echo1(String what) {
        System.out.println(what);
    }



}
