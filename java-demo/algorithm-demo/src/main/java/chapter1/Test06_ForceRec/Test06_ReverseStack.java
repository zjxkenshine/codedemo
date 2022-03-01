package chapter1.Test06_ForceRec;

import java.util.Stack;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/1 17:58
 * @description：不使用额外数据结构逆序输出栈
 * @modified By：
 * @version: $
 *
 * 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数。如何实现?
 * 栈 1 2 3 4
 * 定义一个函数，弹出栈底元素，弹出3，栈变为 1 2 3
 */
public class Test06_ReverseStack {

    // 逆序函数
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        // 逆序压入栈中
        reverse(stack);
        // 最后压入栈底元素，变为栈顶元素
        stack.push(i);
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        // 使用临时变量接收pop的值
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            // 获取栈底元素
            int last = getAndRemoveLastElement(stack);
            // 其他的压回栈中
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }
}
