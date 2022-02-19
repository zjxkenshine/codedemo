package chapter1.Test01_Sort;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/15 14:47
 * @description：递归获取最大值
 * @modified By：
 * @version: $
 */
public class Test06_GetMax {
    public static int GetMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    // arr[L..R] 范围上求最大值 N
    public static int process(int[] arr,int L,int R){
        if(L == R){
            return arr[L];
        }

        // 加上这句master公式最后一项变为O(n）
//        for(int i:arr){
//            System.out.println(i);
//        }

        // master公式中的O(1)
        // 求中点，不会溢出 (R+L)/2容易溢出
        int mid = L + ((R-L)>>1);
        int leftMax = process(arr,L,mid);
        int rightMax = process(arr,mid +1,R);
        return Math.max(leftMax,rightMax);
    }

}
