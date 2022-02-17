package chapter1.Test001;

import java.util.Arrays;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/17 14:58
 * @description：快速排序
 * @modified By：
 * @version: $
 */
public class Test12_QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // 快排递归
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 随机选择一个数放到分区最后 r位置
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            // 分区，将小于r的数放在左侧，大于r的数放在右侧，等于r的放在中间，返回等于r分区的左右边界
            int[] p = partition(arr, l, r);
            // 递归处理小于r分区
            quickSort(arr, l, p[0] - 1);
            // 递归处理大于r分区
            quickSort(arr, p[1] + 1, r);
        }
    }

    // 快排分区
    public static int[] partition(int[] arr, int l, int r) {
        // 小于r分区边界
        int less = l - 1;
        // 大于r分区边界
        int more = r;
        // l~more之间
        while (l < more) {
            // 小于 less 和l右移
            if (arr[l] < arr[r]) {
                // 交换
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                // 大于 more 左移
                swap(arr, --more, l);
            } else {
                // 等于 l 右移
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    // 两数交换
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 用于比较的方法
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // 生成随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // 复制数组
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

    // 相同
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

    // 打印数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 名称
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }
}
