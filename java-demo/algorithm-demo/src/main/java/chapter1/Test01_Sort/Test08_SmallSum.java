package chapter1.Test01_Sort;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/15 19:40
 * @description：小和问题
 * @modified By：
 * @version: $
 * 1 3 4 2 5
 * ↑
 * a
 * 位置a右移 计算每次左侧比该数小的数之和
 * - a=1 0
 * - a=3 1
 * - a=4 4
 * - a=2 1
 * - a=5 10
 * - 小和：16
 *
 * 要求：算法时间复杂度为O(n*logn)
 * 思路：
 * - a=1 右边有4个数比1大，产生小和4
 * - a=3 右边有2个数比3大，产生小和6
 * - a=4 右边有1个数比4大，产生小和4
 * - a=2 右边有1个数比2大，产生小和2
 * - a=5 右边没有数比5大，产生小和0
 * - 小和：16
 *
 * 引入归并思想：
 * 将数组归并排序，在归并排序比较大小时顺带计算小和
 * 如:
 * 1 3 4|2 5
 * ↑     ↑
 * a     b
 *
 * ## 这是最外面一轮，往下递归，其他轮次相同
 * a=1 b比a大 则右侧两个数都比1大 添加2个1=2，通过下标计算，而不是遍历
 * a右移=3 b比a小 b右移 b比a大 添加一个3
 * a右移=4 b比a大 添加一个4
 * 合并，得到总数 3+4+2=9
 * ## 下面的一轮 1 3|4
 * 得到总数 1+3=4
 * ## 2|5
 * 得到总数 2
 * ## 1|3
 * 得到总数1
 *
 * 将所有总数相加，得到：9+4+2+1=16
 * 注意：如果左侧=右侧，则右侧下标右移，不产生小和
 */
public class Test08_SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid)
                + mergeSort(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        // 复制数组
        int[] help = new int[r - l + 1];
        // help数组下标
        int i = 0;
        // 左侧初始位置
        int p1 = l;
        // 右侧初始位置
        int p2 = m + 1;
        // 求这个部分的小和
        int res = 0;

        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }

    // 暴力解法
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
