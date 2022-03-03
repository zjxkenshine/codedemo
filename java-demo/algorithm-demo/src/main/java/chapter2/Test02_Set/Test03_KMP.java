package chapter2.Test02_Set;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/3 18:05
 * @description：KMP算法实现
 * @modified By：
 * @version: $
 */
public class Test03_KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            // str2比对位置无法再往前了
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        // i1或者i2越界了
        return i2 == str2.length ? i1 - i2 : -1;
    }

    // 获取str2的nextarr
    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        // next数组的位置
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            // 相等
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {    // 当前跳到cn位置的字符，和i-1位置的字符匹配不上
                cn = next[cn];
            } else {
                // 无法往前跳，K值为0
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));
    }
}
