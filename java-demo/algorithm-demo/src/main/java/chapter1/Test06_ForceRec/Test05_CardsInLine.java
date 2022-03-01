package chapter1.Test06_ForceRec;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/1 10:59
 * @description：
 * @modified By：
 * @version: $
 *
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸
 * 牌，规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A
 * 和玩家B都绝顶聪明。请返回最后获胜者的分数。
 *
 * 【举例】
 * arr=[1,2,100,4]。
 * 开始时，玩家A只能拿走1或4。如果开始时玩家A拿走1，则排列变为[2,100,4]，接下来
 * 玩家 B可以拿走2或4，然后继续轮到玩家A... 如果开始时玩家A拿走4，则排列变为[1,2,100]，接下来玩家B可以拿走1或100，然后继
 * 续轮到玩家A... 玩家A作为绝顶聪明的人不会先拿4，因为拿4之后，玩家B将拿走100。所以玩家A会先拿1，
 * 让排列变为[2,100,4]，接下来玩家B不管怎么选，100都会被玩家 A拿走。玩家A会获胜，
 * 分数为101。所以返回101。
 * arr=[1,100,2]。
 * 开始时，玩家A不管拿1还是2，玩家B作为绝顶聪明的人，都会把100拿走。玩家B会获胜，
 * 分数为100。所以返回100
 *
 * 思路：
 * f(arr,L,R)：先手函数
 * arr[L]=arr[R] 仅剩一个数返回arr[L]
 * 情况1：arr[L] + s(arr,L+1,R) s为后手函数
 * 情况2：arr[R] + s(arr,L,R-1)
 * 两种情况最大值比较，选择比较大的一方
 *
 * s(arr,L,R)：后手函数
 * arr[L]=arr[R] 返回0
 * 情况1:f(arr,L+1,R)  拿L
 * 情况2:f(arr,L,R-1)  拿R
 * 情况1和情况2较小的一方，别人决定的
 *
 */
public class Test05_CardsInLine {
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // f(arr, 0, arr.length - 1) 玩家A 先手
        // s(arr, 0, arr.length - 1)) 玩家B 后手
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    // 先手函数
    public static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    // 后手函数
    public static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

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
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 9, 1 };
        System.out.println(win1(arr));
        System.out.println(win2(arr));
    }
}
