package chapter2.Test06_DP;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/9 9:16
 * @description：排成一条线的纸牌博弈问题
 * @modified By：
 * @version: $
 */
public class Test03_CardInLine {
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    // 先手函数
    // 当前该你拿，arr[i..j]
    // 返回你的最好分数
    public static int f(int[] arr, int i, int j) {
        // 仅剩一个数
        if (i == j) {
            return arr[i];
        }
        return Math.max(
                // 拿左边
                arr[i] + s(arr, i + 1, j),
                // 拿右边
                arr[j] + s(arr, i, j - 1)
        );
    }

    // 后手函数
    public static int s(int[] arr, int i, int j) {
        // 仅剩一个数
        if (i == j) {
            return 0;
        }
        // 给你剩的肯定是总和最小的
        return Math.min(
                        // 对手拿了左边剩下的
                        f(arr, i + 1, j),
                        // 对手拿了右边剩下的
                        f(arr, i, j - 1));
    }

    // 动态规划版本
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        // 先手和后手谁大谁获胜
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 9, 1 };
        System.out.println(win1(arr));
        System.out.println(win2(arr));

    }
}
