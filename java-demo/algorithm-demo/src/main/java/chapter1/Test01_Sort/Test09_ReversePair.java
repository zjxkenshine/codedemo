package chapter1.Test01_Sort;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/15 21:05
 * @description：逆序对问题
 * @modified By：
 * @version: $
 * 一个数组中，如果左边的数比右边的数大，则这两个数构成一对逆序对，求数组中所有逆序对(非相邻也可)
 * 如：3 2 4 5 0
 * 包含的逆序对为：
 * - 3-2 3-0
 * - 2-0
 * - 4-0
 * - 5-0
 * <p>
 * 要求：时间复杂度O(n*logn)
 * 暴力解法：遍历两遍
 * <p>
 * 归并扩展：
 * 思路：
 * 2 3 4|0 5
 * ↑   ↑ ↑
 * a   p1b
 * ## 最外层循环
 * b比a小，则b比a之后所有数都小，加上 p1-a+1个数，b右移
 * b与a相同，a右移，不加数
 * b比a大，a右移，不加数
 * 边界：b超出边界，不加数
 * a超出边界，不加数
 * <p>
 * 3|2|4|5|0
 * \/    \/
 * 23|4|05     2个
 * \/
 * 234|05      0个
 * \/
 * 23405       3个
 * 总数：5个
 */
public class Test09_ReversePair {

    // 暴力解法
    public static int comparator(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (arr[i] > arr[j]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static int reversePair(int[] arr) {
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

    // 归并排序
    // arr数组 l左边位置，m中间位置，r右边位置
    public static int merge(int[] arr, int l, int m, int r) {
        // 复制的数组
        int[] help = new int[r - l + 1];
        // 逆序对数量
        int sum = 0;
        // help数组下标
        int i = 0;
        // 左侧初始位置
        int p1 = l;
        // 右侧初始位置
        int p2 = m + 1;

        // 都处在边界内
        while (p1 <= m && p2 <= r) {
            // 左>右
            if (arr[p1] > arr[p2]) {
                // 将arr[p2]放入help数组,p2右移
                help[i++] = arr[p2++];
                // 添加逆序对 (num-p1+1)
                sum += (m - p1 + 1);
            } else {
                // 将arr[p1] p1右移
                help[i++] = arr[p1++];
            }
        }

        // 左侧处在边界内 右侧超出边界，添加剩余的数
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }

        // 右侧处在边界内 左侧超出边界，添加剩余的数
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        // 复制数组
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

        return sum;
    }

    // 生成随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // 拷贝数组
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
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // main方法
    public static void main(String[] args) {
        //int[] arr = {3, 2, 4, 5, 0,0};
        int[] arr = {-71, -2, -32, -78, 57, 7, -5, -4, 34, 6, 39, -4, 72, -27, -33, 7, 5, -49, 8, 52, -6, -42, 0, -18, 1, -27, 24, -76, 15, -1, 12, -5};
        System.out.println(comparator(arr));
        System.out.println(reversePair(arr));

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (reversePair(arr1) != comparator(arr2)) {
                succeed = false;
                System.out.println(reversePair(arr1));
                printArray(arr1);
                System.out.println(comparator(arr2));
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
