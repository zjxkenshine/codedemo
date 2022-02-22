package chapter1.Test03_Tree;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/22 11:57
 * @description：折纸问题
 * @modified By：
 * @version: $
 *
 */
public class Test12_PaperFolding {
    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }
    // 递归过程
    // i是节点层数，n是一共的层数，
    public static void printProcess(int i, int N, boolean down) {
        // 超过深度，折了N次，直接返回
        if (i > N) {
            return;
        }
        // 左子树都为凹
        printProcess(i + 1, N, true);
        System.out.println(down ? "down " : "up ");
        // 右子树都为凸
        printProcess(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 5;
        printAllFolds(N);
    }
}
