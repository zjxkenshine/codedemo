package chapter1.Test06_ForceRec;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/1 18:35
 * @description：背包问题
 * @modified By：
 * @version: $
 */
public class Test08_Knapsack {
    public static int maxValue1(int[] weights, int[] values, int bag) {
        return process1(weights, values, 0, 0, bag);
    }

    /**
     * i往后的货物的最大价值并返回
     * 永远不要超过bag
     * @param weights
     * @param values
     * @param i
     * @param alreadyweight 之前做的决定的价值
     * @param bag
     * @return
     */
    public static int process1(int[] weights, int[] values, int i, int alreadyweight, int bag) {
        if (alreadyweight > bag) {
            return 0;
        }
        if (i == weights.length) {
            return 0;
        }
        return Math.max
                // 不要i号货的价值
                (process1(weights, values, i + 1, alreadyweight, bag),
                // 要i号货的价值
                values[i] + process1(weights, values, i + 1, alreadyweight + weights[i], bag));
    }

    // 动态规划 dp
    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 };
        int[] values = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue1(weights, values, bag));
        System.out.println(maxValue2(weights, values, bag));
    }
}
