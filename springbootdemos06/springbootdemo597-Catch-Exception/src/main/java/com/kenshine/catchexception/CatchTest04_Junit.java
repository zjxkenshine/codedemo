package com.kenshine.catchexception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.ArrayList;

import static com.googlecode.catchexception.CatchException.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

/**
 * @author by kenshine
 * @Classname CatchTest04_Junit
 * @Description catchexception整合junit
 * @Date 2023-12-18 8:39
 * @modified By：
 * @version: 1.0$
 */
public class CatchTest04_Junit {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    /**
     * catchexception整合junit
     */
    @Test
    public void test04(){
        // 第一个错
        collector.checkThat("a", equalTo("b"));
        // 第二个错
        catchException(() -> new ArrayList().get(1));
        collector.checkThat(caughtException(), instanceOf(IllegalArgumentException.class));
        // 第三个错
        collector.checkThat(1, equalTo(2));
    }


}
