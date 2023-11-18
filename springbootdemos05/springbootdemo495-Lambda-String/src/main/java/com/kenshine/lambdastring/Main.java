package com.kenshine.lambdastring;

/**
 * @author by kenshine
 * @Classname Main
 * @Description 测试toString注入Lambda
 * @Date 2023-11-18 12:18
 * @modified By：
 * @version: 1.0$
 */
public class Main {

    @FunctionalInterface
    interface Foo {
        void foo();
    }

    public static Foo createFoo(int param) {
        switch (param) {
            case 1:
                return () -> { /* do 1 */ };
            case 2:
                return () -> { /* do 2 */ };
            /* ... */
            default:
                return () -> { /* do default */ };
        }
    }

    public static void main(String[] args) {
        Integer param = Integer.valueOf(args[0]);
//        int param = 1;
        Foo foo = createFoo(param);
        // lambda-string 会注入toString，告诉你选择了哪个foo
        // 输出 Main:21 选择了第21行的方法
        System.out.println(foo.toString());
    }
}
