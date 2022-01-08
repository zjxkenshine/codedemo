package com.kenshine.basic._01_base;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/8 23:07
 * @description：
 * @modified By：
 * @version: $
 */
public class test08_system {
    public static void main(String[] args) {
        int[] a={1,2,3,5,6};
        int[] b={15,16,17,18,19};

        /**
         * 修改b数组索引1位置开始的两个值为a数组索引2位置开始的两个值
         */
        System.arraycopy(a,2,b,1,2);
        for(int i:b){	//仅修改b数组，a不变
            System.out.println(i);
        }
    }
}
