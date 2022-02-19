package chapter1.Test01_Sort;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/14 21:38
 * @description： 找到奇数个数的数
 * @modified By：
 * @version: $
 * 一个数组，
 * 1.有一个数是奇数个，其他数都是偶数个，找到这个数
 * 要求：时间复杂度O(n) 空间复杂度O(1)
 * 思路：异或运算，a^a=0 0^a=a
 *
 * 2.有两个个数是奇数个，怎么找
 * 思路：eor1=所有数异或=a^b！=0,则eor1肯定有一位为1(a!=b)
 * 假设为第8位，则可以将数组中的数分为第8位为1和第8位不为1两组，求解任意一组的异或值，值为a或者b
 * eor2 = a or b
 * 另一个数 = eor1^eor2
 */
public class Test04_FindOddNumber {
    public static void printOddTimesNum1(int[] arr) {
        int eor1 = 0;
        for (int cur : arr) {
            eor1 ^= cur;
        }
        System.out.println(eor1);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor1 = 0, eor2 = 0;
        for (int curNum : arr) {
            eor1 ^= curNum;
        }
        // 找到最右侧的1值位置的值 如0000100
        int rightOne = eor1 & (~eor1 + 1);
        for (int cur : arr) {
            if ((cur & rightOne) != 0) {
                eor2 ^= cur;
            }
        }
        System.out.println(eor2 + " " + (eor1 ^ eor2));
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);
        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);
    }
}
