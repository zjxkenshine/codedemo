package com.kenshine.jqwik.parameter;

import net.jqwik.api.*;

import java.util.List;

/**
 * @author by kenshine
 * @Classname ArbitraryTypesTest
 * @Description Arbitrary类型
 * @Date 2024-01-18 12:24
 * @modified By：
 * @version: 1.0$
 */
public class ArbitraryTypesTest {
    /**
     * 默认类型
     * @param stringList
     * @return
     */
    @Property
    boolean listWithWildcard(@ForAll("stringLists") List<?> stringList) {
        return stringList.isEmpty() || stringList.get(0) instanceof String;
    }

    @Provide
    Arbitrary<List> stringLists() {
        return Arbitraries.defaultFor(List.class, String.class);
    }



}
