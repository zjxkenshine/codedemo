package com.kenshine.ecj;

import org.eclipse.jdt.internal.compiler.batch.Main;

/**
 * @author by kenshine
 * @Classname ECJTest
 * @Description Ecj使用测试
 * @Date 2024-03-20 14:23
 * @modified By：
 * @version: 1.0$
 */
public class ECJTest {

    public static void main(String[] args) {
        // ECJ编译
        Main.main(new String[]{"springbootdemo753-ECJ/src/main/java/com/kenshine/ecj/User.java"});
    }


}
