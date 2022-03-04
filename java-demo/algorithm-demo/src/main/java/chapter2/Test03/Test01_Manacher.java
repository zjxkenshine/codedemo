package chapter2.Test03;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/4 10:19
 * @description：Manacher算法实现回文结构
 * @modified By：
 * @version: $
 * 具体流程见笔记
 */
public class Test01_Manacher {
    // 把 12321 变为 #1#2#3#2#1# 这种形式
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // 处理后的字符数组
        char[] charArr = manacherString(str);
        // 回文半径数组
        int[] pArr = new int[charArr.length];
        // 达到最右边界时的中心点
        int C = -1;
        // 最右边界为R-1,这里的R为最后一个有效位置+1
        int R = -1;
        int max = Integer.MIN_VALUE;
        // 每个位置回文长度验证
        for (int i = 0; i != charArr.length; i++) {
            // i 至少的回文区域 不用验证也知道的区域
            // 四种不用验的情况都是这一句话
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            // 最右边界扩充
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            // 最大回文半径
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }
}
