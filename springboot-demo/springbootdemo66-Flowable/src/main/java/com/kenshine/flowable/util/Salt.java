package com.kenshine.flowable.util;

import java.util.Random;

/**
 * 随机数生成盐值
 * @author: kenshine
 * @create: 2019-04-17 14:36
 * @throw
 **/
public class Salt {

    // 设置盐值的位数
    private final static int NUM = 20;

    /**
     * 生成随机数 数字+字母组合
     * n ： 需要的长度
     * @return
     */
    public static String salt() {
        String val = "";
        Random random = new Random();
        for ( int i = 0; i < NUM; i++ )
        {
            String str = random.nextInt( 2 ) % 2 == 0 ? "num" : "char";
            if ( "char".equalsIgnoreCase( str ) )
            { // 产生字母
                int nextInt = random.nextInt( 2 ) % 2 == 0 ? 65 : 97;
                // System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
                val += (char) ( nextInt + random.nextInt( 26 ) );
            }
            else if ( "num".equalsIgnoreCase( str ) )
            { // 产生数字
                val += String.valueOf( random.nextInt( 10 ) );
            }
        }
        return val;
    }
}
