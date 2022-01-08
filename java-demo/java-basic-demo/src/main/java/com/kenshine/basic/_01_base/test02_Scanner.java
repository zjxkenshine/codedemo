package com.kenshine.basic._01_base;

import java.util.Scanner;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/8 22:21
 * @description：
 * @modified By：
 * @version: $
 */
public class test02_Scanner {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int i=scan.nextInt();
        String str=scan.next();
        System.out.println(i);
        System.out.println(str);
    }
}

