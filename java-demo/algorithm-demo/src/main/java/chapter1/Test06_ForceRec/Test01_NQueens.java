package chapter1.Test06_ForceRec;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/24 17:04
 * @description：N皇后问题
 * @modified By：
 * @version: 1.0$
 */
public class Test01_NQueens {
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        // 第i行的皇后放在了第几列
        int[] record = new int[n];
        return process1(0, record, n);
    }

    // record[0..i-1] 的皇后一定不共行不共列不共斜线
    // 来到第i行
    // record[0..i-1] 表示之前的行，放了的皇后的位置
    // n代表整体一共多少行
    // 返回值，合法摆法有多少种
    public static int process1(int i, int[] record, int n) {
        // 终止行
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            // i行皇后放在j列，不会和其他皇后共行共列
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    // record[0...i-1]需要看，record[i...]不需要看
    // 返回i行皇后，放在j列，是否有效
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) { //之前某个K行的皇后
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }


    // 常数优化，位运算优化
    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int upperLim = n == 32 ? -1 : (1 << n) - 1;
        return process2(upperLim, 0, 0, 0);
    }

    public static int process2(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == upperLim) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(upperLim, colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 14;

        long start = System.currentTimeMillis();
        System.out.println(num2(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(num1(n));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

    }
}
