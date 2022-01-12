package com.kenshine.log4j2;


import org.junit.Assert;
import org.junit.Test;

public class JunitTest {

    @Test
    public void test01(){
        Assert.assertEquals("a","b");
    }
    @Test
    public void test02(){
        Assert.assertFalse(false);
    }


}
