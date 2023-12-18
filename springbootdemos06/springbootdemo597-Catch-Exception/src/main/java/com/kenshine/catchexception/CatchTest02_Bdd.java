package com.kenshine.catchexception;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.catchexception.apis.BDDCatchException.*;

/**
 * @author by kenshine
 * @Classname CatchBDDUse
 * @Description BDD测试使用
 * @Date 2023-12-18 8:11
 * @modified By：
 * @version: 1.0$
 */
public class CatchTest02_Bdd {

    /**
     * BDDCatchException
     * 完整版参照src/test/java/com/kenshine/catchtest/CatchTest.java
     */
    @Test
    public void test02(){
        List<String> myList = new ArrayList<>();
        when(() -> myList.get(1));
        thenThrown(IndexOutOfBoundsException.class);
    }
}
