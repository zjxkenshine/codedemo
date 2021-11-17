package com.kenshine.cf.test;

import org.apache.commons.lang3.text.StrBuilder;
import org.checkerframework.checker.nullness.qual.KeyFor;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 22:34
 * @description：测试
 * @modified By：
 * @version: $
 */
public class CFTest {
    public static @Nullable Object nullable = null;
    public Map<Object, Object> map = new HashMap<>();

    public static void main(final String[] args) {
        System.out.println("Hello World!");

        StrBuilder stb = new StrBuilder();

        // 执行 complie 这行会报错
        @NonNull Object nn = nullable;
        System.out.println(nn);
    }

    // Test for -J--add-opens=jdk.compiler/com.sun.tools.javac.comp=ALL-UNNAMED.
    void mapTest(@KeyFor("map") Object k) {}
}
