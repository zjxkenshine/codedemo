package chapter1.Test01_Sort;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/17 9:35
 * @description： 快排基础 荷兰国旗问题
 * @modified By：
 * @version: $
 * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，等于num放在中间，大于num的放在右边
 * 思路：
 * 1 3 6 5 8 6 4
 * 效果：1 3 4|5|8 6 6 顺序无关，仅分组
 * <p>
 * ]1 3 6 5 8 6 4[
 * ↑           ↑
 * ai          b
 * - i<num i与a交换 i往下走，a往下走
 * - i>num i与b交换 i原地不动 b往前走
 * - i=num 不交换 i向右移动
 * <p>
 * 小于区域：a往左(不包含a)
 * 大于区域：b往右(不包含b)
 * 待定区域 i到b之间
 * 等于区域 a到i之间
 * <p>
 * 1] 3 6 5 8 6 4[
 * ↑         ↑
 * ai        b
 * 1 3] 4 5 8 6 6[
 * ↑       ↑
 * ai      b
 * 1 3 4] 5 8 6 [6
 * ↑ ↑ ↑
 * a i b
 * 1 3 4] 5 6 [8 6
 * ↑ ↑
 * a bi
 * 1 3 4] 5 [6 8 6  结束
 * ↑  ↑
 * ab i
 */
public class Test11_DutchNationalFlag {
    // 荷兰国旗问题
    public static void DutchNation(int num, int[] arr) {
        int a = 0;
        int b = arr.length - 1;
        int i = 0;
        while (i <= b) {
            if (arr[i] > num) {
                swap(arr, b, i);
                // b向左移动
                if (arr[b] > num) {
                    b--;
                }
            } else if (arr[i] < num) {
                swap(arr, a, i);
                // a和i向右移动
                if (arr[a] < num) {
                    a++;
                    // i向右移动
                    i++;
                }
            } else {  //arr[i]==num i向右移动
                i++;
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
        DutchNation(5, iarr);
        printArray(iarr);

        int maxSize = 100;
        int maxValue = 100;
        int arr[] = generateRandomArray(maxSize, maxValue);
        int num = generateNum(maxValue);
        // 排序
        DutchNation(num, arr);
        System.out.println(num);
        printArray(arr);
    }
}
