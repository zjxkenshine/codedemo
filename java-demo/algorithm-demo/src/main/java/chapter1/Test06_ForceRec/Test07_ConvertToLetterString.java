package chapter1.Test06_ForceRec;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/1 18:22
 * @description：数字串转字符串
 * @modified By：
 * @version: $
 *
 * 题目：规定1和A对应、2和B对应、3和C对应...
 * - 那么一个数字字符串比如"111"，就可以转化为"AAA"、"KA"和"AK"
 * - 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 */
public class Test07_ConvertToLetterString {
    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    // i之前的位置都已经记录了
    // i往后如何决定 多少种有效的
    public static int process(char[] chs, int i) {
        // 返回一种有效的转换
        if (i == chs.length) {
            return 1;
        }
        // i位置字符串为0 i及i之后不能有效转换为字符串，返回0种结果
        if (chs[i] == '0') {
            return 0;
        }
        // i位置字符串为1
        if (chs[i] == '1') {
            // i自己作为单独部分，后续有多少种选择
            int res = process(chs, i + 1);
            // i+1不越界
            if (i + 1 < chs.length) {
                // i和i+1共同作为一部分有多少种选择
                res += process(chs, i + 2);
            }
            return res;
        }
        // i位置字符串为2
        if (chs[i] == '2') {
            // i作为单独整体有多少种选择
            int res = process(chs, i + 1);
            // i+1是0~6
            if (i + 1 < chs.length && (chs[i + 1] >= '0' && chs[i + 1] <= '6')) {
                // i和i+1作为一个整体有多少种选择
                res += process(chs, i + 2);
            }
            return res;
        }
        // 当前字符是3~9范围内
        return process(chs, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(number("11111"));
    }
}
