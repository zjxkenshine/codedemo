package chapter2.Test05_Bit;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/6 10:39
 * @description：
 * @modified By：
 * @version: $
 *
 * 给定两个有符号32位整数a和b，不能使用算术运算符，分别实现a和b的加、减、乘、除运算
 *
 * 【要求】
 * 如果给定a、b执行加减乘除的运算结果就会导致数据的溢出，那么你实现的函数不必对此负责，除此之外请保证计算过程不发生溢出
 */
public class Test03_AddMinusMultiDivideByBit {
    // 加法
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;        // 无进位相加结果
            b = (a & b) << 1;   // 进位信息
            a = sum;
        }
        return sum;
    }

    // 求反
    public static int negNum(int n) {
        return add(~n, 1);
    }

    // 减法
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    // 乘法
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    // 是否负数
    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    // 出发
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("divisor is 0");
        }
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            int res = div(add(a, 1), b);
            return add(res, div(minus(a, multi(res, b)), b));
        } else {
            return div(a, b);
        }
    }

    public static void main(String[] args) {
        int a = (int) (Math.random() * 100000) - 50000;
        int b = (int) (Math.random() * 100000) - 50000;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println(add(a, b));
        System.out.println(a + b);
        System.out.println("=========");
        System.out.println(minus(a, b));
        System.out.println(a - b);
        System.out.println("=========");
        System.out.println(multi(a, b));
        System.out.println(a * b);
        System.out.println("=========");
        System.out.println(divide(a, b));
        System.out.println(a / b);
        System.out.println("=========");

        a = Integer.MIN_VALUE;
        b = 32;
        System.out.println(divide(a, b));
        System.out.println(a / b);

    }
}
