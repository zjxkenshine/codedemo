package com.kenshine.basic._01_base;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/8 23:37
 * @description：跳出双重for循环
 * @modified By：
 * @version: $
 */
public class test11_DoubleFor {
    public static void main(String[] args) {
        int n =10;
        for1:
        for (int i = 0; i < n; i++) {
            for2:
            for (int j = 0; j < n; j++) {
                if (n == 0) {
                    //跳出外层for循环
                    break for1;
                }
            }
        }
    }
}
