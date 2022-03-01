package chapter1.Test06_ForceRec;

import java.util.ArrayList;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/1 10:22
 * @description：打印所有字符串排列
 * @modified By：
 * @version: $
 * abc 排列
 * 1 位置为a
 * a b c
 * a c b
 *
 * 1 位置为b
 * b c a
 * b a c
 *
 * 1 位置为c
 * c b a
 * c a b
 */
public class Test04_PrintAllPermutations {

    // 排列方法
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        res.sort(null);
        return res;
    }

    // 递归
    /**
     * str[i...]范围上，所有的字符都可以在i位置上，都去尝试
     * str[0...i-1]范围上，是之前所做的选择
     * 所有字符串行程的全排列加入到res中
     * @param chs
     * @param i
     * @param res 所有排列字符串
     */
    public static void process(char[] chs, int i, ArrayList<String> res) {
        if (i == chs.length) {
            res.add(String.valueOf(chs));
        }
        // 已经访问过的字符，不能重复
        boolean[] visit = new boolean[26];
        for (int j = i; j < chs.length; j++) {
            // 不重复才进行排列
            if (!visit[chs[j] - 'a']) {
                visit[chs[j] - 'a'] = true;
                // 之后的所有都放到i位置上
                swap(chs, i, j);
                // 继续尝试，直到所有字符访问完
                process(chs, i + 1, res);
                // 换回来，用于下一次交换
                swap(chs, i, j);
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
