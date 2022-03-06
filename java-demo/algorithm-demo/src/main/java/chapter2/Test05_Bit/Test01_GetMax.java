package chapter2.Test05_Bit;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/6 10:08
 * @description：位运算获取最大值
 * @modified By：
 * @version: $
 */
public class Test01_GetMax {
    // 保证参数不是1就是0的情况下
    // 0变1,1变0 方法
    public static int flip(int n) {
        return n ^ 1;
    }

    // n是非负数，返回1
    // n是负数，返回0
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int getMax1(int a, int b) {
        // 有问题，a-b会溢出
        int c = a - b;
        // 差值的符号
        int scA = sign(c);
        int scB = flip(scA);
        // scA为0，scB必为1;scA为1，scB必为0
        return a * scA + b * scB;
    }

    // 考虑了a-b溢出的情况
    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;   // ab符号不一样，为1；一样，为0
        int sameSab = flip(difSab);  // ab符号不一样，为0；一样，为1
        // 返回a的条件 ab符号不同，a为非负 或者 ab符号相同,a-b非负
        int returnA = difSab * sa + sameSab * sc;
        // 其他情况返回B
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        int a = -16;
        int b = 1;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
        a = 2147483647;
        b = -2147480000;
        System.out.println(getMax1(a, b)); // wrong answer because of overflow
        System.out.println(getMax2(a, b));

    }
}
