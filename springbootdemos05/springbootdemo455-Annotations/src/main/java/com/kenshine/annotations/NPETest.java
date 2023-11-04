package com.kenshine.annotations;

import org.junit.Test;

/**
 * @author by kenshine
 * @Classname NPETest
 * @Description 空异常测试
 * @Date 2023-11-04 8:06
 * @modified By：
 * @version: 1.0$
 */
public class NPETest {

    @Test
    public void test01(){
        testNull("kenshine");
        testNull(null);
    }

    public boolean testNull(String name){
        return name.equals("kenshine");
    }
}
