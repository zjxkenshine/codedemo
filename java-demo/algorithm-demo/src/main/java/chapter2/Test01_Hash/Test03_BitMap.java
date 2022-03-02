package chapter2.Test01_Hash;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/2 10:56
 * @description：位图
 * @modified By：
 * @version: $
 */
public class Test03_BitMap {
    public static void main(String[] args) {
        // a 32bit
        int a = 0;

        // 32bit*10 -> 320bit的数组
        int[] arr = new int[10];
        // arr[0] int 0~31
        // arr[1] int 32~63
        // arr[2] int 64~95

        // 想取得第178个bit的状态信息
        int i= 178;

        // 第几个int
        int numIndex = 178/32;
        // 第几个bit
        int bitIndex = 178%32;

        // 获取第178位的状态
        // arr[numIndex]>>(bitIndex) 跑到了最右侧位置 和1&一下就提取出了状态
        int s = ((arr[numIndex]>>(bitIndex))&1);

        // 把178位的状态改为1
        arr[numIndex] = arr[numIndex] | (1<<(bitIndex));

        // 把178位状态改成0
        i= 178;
        arr[numIndex] = arr[numIndex] & (~(1<<bitIndex));

        //把178位的状态拿出来
        int bit = arr[i/32] >> (i/32) & i;
    }
}
