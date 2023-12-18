package com.kenshine.catchtest;

import org.junit.Test;

import java.util.ArrayList;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author by kenshine
 * @Classname BddTest
 * @Description BddCatchException
 * @Date 2023-12-18 8:42
 * @modified By：
 * @version: 1.0$
 */
public class CatchTest {
    @Test
    public void test(){
        when(()->new ArrayList<String>().get(1));
        then(caughtException())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasMessageStartingWith("Runtime")
                .hasMessageEndingWith("occured")
                .hasMessageContaining("exception")
                .hasNoCause();
    }
}
