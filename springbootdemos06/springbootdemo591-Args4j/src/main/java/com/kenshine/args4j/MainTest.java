package com.kenshine.args4j;

import org.junit.Test;

/**
 * @author by kenshine
 * @Classname MainTest
 * @Description 参数解析测试
 * @Date 2023-12-16 10:40
 * @modified By：
 * @version: 1.0$
 */
public class MainTest {

    /**
     * 参数解析测试
     */
    @Test
    public void test(){
        String[] args=new String[]{
          "-r","-str","kenshine","-n","2","-hidden-str2","hong","-custom","other1","other2"
        };
        Main.main(args);
    }
}
