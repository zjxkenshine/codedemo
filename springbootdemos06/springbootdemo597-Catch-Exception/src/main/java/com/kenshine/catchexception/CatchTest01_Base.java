package com.kenshine.catchexception;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.catchexception.CatchException.*;


/**
 * @author by kenshine
 * @Classname CatchBaseUse
 * @Description 基本使用
 * @Date 2023-12-18 8:04
 * @modified By：
 * @version: 1.0$
 */
public class CatchTest01_Base {
    /**
     * 捕获异常并验证
     */
    @Test
    public void test01(){
        List<String> myList = new ArrayList<>();
        catchException(() -> myList.get(1));
        assert caughtException() instanceof IndexOutOfBoundsException;
        //verifyException(myList, IndexOutOfBoundsException.class).get(1);
    }
}
