package chapter1.Test001;

import java.util.Arrays;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/17 17:42
 * @description：堆排序
 * @modified By：
 * @version: $
 */
public class Test13_HeapSort {
    public static void heapSort(int[] arr) {
        // 堆大小于2
        if (arr == null || arr.length < 2) {
            return;
        }
        // 构建堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // size
        int size = arr.length;
        // 1.交换堆顶和最后一个数，0~n-1继续堆化
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    // 插入数据到大根堆
    public static void heapInsert(int[] arr, int index) {
        // 比顶点大
        while (arr[index] > arr[(index - 1) / 2]) {
            // 交换这个数据和顶点
            swap(arr, index, (index - 1) /2);
            // 当前顶点移动到父节点
            index = (index - 1)/2 ;
        }
    }

    /**
     * 堆化
     * @param arr 数组
     * @param index 索引
     * @param HeapSize 堆长度
     */
    public static void heapify(int[] arr, int index, int HeapSize) {
        // 左孩子下标
        int left = index * 2 + 1;
        // 下方还有孩子时 左孩子比右孩子下标小
        while (left < HeapSize) {
            // 两个孩子中大的值
            int largest = left + 1 < HeapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 父节点与孩子之间较大值的下标
            largest = arr[largest] > arr[index] ? largest : index;
            // 父节点大，结束
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
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

    // 测试
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }
}
