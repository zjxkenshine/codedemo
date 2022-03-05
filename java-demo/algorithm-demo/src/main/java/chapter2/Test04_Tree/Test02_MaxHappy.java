package chapter2.Test04_Tree;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/5 19:26
 * @description：最大快乐值
 * @modified By：
 * @version: $
 */
public class Test02_MaxHappy {
    public static int maxHappy(int[][] matrix) {
        int[][] dp = new int[matrix.length][2];
        boolean[] visited = new boolean[matrix.length];
        int root = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == matrix[i][0]) {
                root = i;
            }
        }
        process(matrix, dp, visited, root);
        // 头节点来的时候和不来的时候的最大快乐值
        return Math.max(dp[root][0], dp[root][1]);
    }

    public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
        visited[root] = true;
        dp[root][1] = matrix[root][1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == root && !visited[i]) {
                process(matrix, dp, visited, i);
                dp[root][1] += dp[i][0];
                dp[root][0] += Math.max(dp[i][1], dp[i][0]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
        System.out.println(maxHappy(matrix));
    }
}
