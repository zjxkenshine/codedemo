package com.kenshine.catchexception;


import static com.googlecode.catchexception.CatchException.*;
import static com.googlecode.catchexception.apis.CatchExceptionHamcrestMatchers.*;

import com.googlecode.catchexception.apis.CatchExceptionHamcrestMatchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author by kenshine
 * @Classname CatchTest03_Hamcrest
 * @Description Hamcrest捕获异常
 * @Date 2023-12-18 8:24
 * @modified By：
 * @version: 1.0$
 */
public class CatchTest03_Hamcrest {

    /**
     * catch-exception 整合
     * Hamcrest 异常验证
     */
    @Test
    public void test03(){
        List<String> myList = new ArrayList<>();
        catchException(()->myList.get(1));
        assertThat(
                caughtException(),
                allOf(
                        instanceOf(IndexOutOfBoundsException.class),
                        CatchExceptionHamcrestMatchers.hasMessage("Index: 1, Size: 0"),
                        CatchExceptionHamcrestMatchers.hasNoCause()
                )
        );
    }
}
