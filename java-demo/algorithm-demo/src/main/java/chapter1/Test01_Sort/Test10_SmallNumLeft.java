package chapter1.Test01_Sort;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/16 10:47
 * @description： 快排基础 将小于等于num的数放到数组左侧
 * @modified By：
 * @version: $
 * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的
 * 数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)
 * <p>
 * 1 3 6 5 8 6 4  num=5
 * 最终效果：1 3 4 5|6 6 8 左边都是小于等于5的，右边都是大于等于5的
 * 算法流程：
 * 1 3 6 5 8 6 4
 * ↑
 * ai
 * i位置数小于5时，数和a位置交换，i右移 先执行
 * i位置大于5时，i右移
 * i一直右移，移动到最右端结束
 * a位置数小于等于5时，a右移 后执行
 */
public class Test10_SmallNumLeft {

    /**
     * @param num 目标数字
     * @param arr 数组
     */
    public static void findSmallNum(int num, int[] arr) {
        // a指针
        int a = 0;
        // i指针右移
        for (int i = 0; i < arr.length; i++) {
            // i比num小
            if (arr[i] <= num) {
                swap(arr, a, i);
            }
            // a<=5时a向右移动
            if (arr[a] <= num) {
                a++;
            }
        }
    }

    /**
     * 交换a和i位置的值
     */
    public static void swap(int[] arr, int a, int i) {
        int swap = arr[a];
        arr[a] = arr[i];
        arr[i] = swap;
    }

    // 生成随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // 生成随机比较数字
    public static int generateNum(int maxValue) {
        return (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] iarr = {1, 3, 6, 5, 8, 6, 4, 1, 5, 6, 4, 88, 46, 3, 1, 4, 613, 46, 8, 6, 7, 5, 9, 8};
        findSmallNum(5, iarr);
        printArray(iarr);

        int maxSize = 100;
        int maxValue = 100;
        int arr[] = generateRandomArray(maxSize, maxValue);
        int num = generateNum(maxValue);
        // 排序
        findSmallNum(num, arr);
        System.out.println(num);
        printArray(arr);
    }

}
