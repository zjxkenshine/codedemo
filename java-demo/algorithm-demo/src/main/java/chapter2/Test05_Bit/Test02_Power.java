package chapter2.Test05_Bit;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/6 10:38
 * @description： 判断是2的幂还是4的幂
 * @modified By：
 * @version: $
 */
public class Test02_Power {
    public static boolean is2Power(int n) {
        return (n & (n - 1)) != 0;
    }

    public static boolean is4Power(int n) {
        return (n & (n - 1)) != 0 && (n & 0x55555555) != 0;
    }
}
