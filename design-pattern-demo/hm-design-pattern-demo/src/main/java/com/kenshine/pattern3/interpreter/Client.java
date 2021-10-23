package com.kenshine.pattern3.interpreter;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 解释器模式
 * @Author: kenshine
 *
 * 优点：
 * 易于改变和扩展文法。实现文法较为容易。增加新的解释表达式较为方便。
 *
 * 缺点：
 * 对于复杂文法难以维护。
 * 执行效率较低。
 *
 * 使用场景
 * * 当语言的文法较为简单，且执行效率不是关键问题时。
 * * 当问题重复出现，且可以用一种简单的语言来进行表达时。
 * * 当一个语言需要解释执行，并且语言中的句子可以表示为一个抽象语法树的时候
 *
 */
public class Client {
    public static void main(String[] args) {
        //创建环境对象
        Context context = new Context();

        //创建多个变量对象
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Variable d = new Variable("d");

        //将变量存储到环境对象中
        context.assign(a,1);
        context.assign(b,2);
        context.assign(c,3);
        context.assign(d,4);

        //获取抽象语法树    a + b - c + d
        AbstractExpression expression = new Minus(a,new Minus(new Minus(b,c),d));

        //解释（计算）
        int result = expression.interpret(context);

        System.out.println(expression + " = " + result);
    }
}
