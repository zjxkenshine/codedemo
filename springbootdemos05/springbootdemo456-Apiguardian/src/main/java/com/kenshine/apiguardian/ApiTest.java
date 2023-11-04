package com.kenshine.apiguardian;

import org.apiguardian.api.API;

import static org.apiguardian.api.API.Status.*;

/**
 * @author by kenshine
 * @Classname ApiTest
 * @Description @Api注解
 * @Date 2023-11-04 12:23
 * @modified By：
 * @version: 1.0$
 */
public class ApiTest {

    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Byte expected, Byte actual) {
        System.out.println("1");
    }

}
