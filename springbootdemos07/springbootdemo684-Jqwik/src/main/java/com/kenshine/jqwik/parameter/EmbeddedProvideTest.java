package com.kenshine.jqwik.parameter;

import net.jqwik.api.*;

import java.util.List;

/**
 * @author by kenshine
 * @Classname EmbeddedProvideTest
 * @Description 嵌入式类型provide
 * @Date 2024-01-18 11:56
 * @modified By：
 * @version: 1.0$
 */
public class EmbeddedProvideTest {
    @Property
    boolean concatenatingStringWithInt(
            @ForAll @From("shortStrings") String aShortString,
            @ForAll @From("10 to 99") int aNumber
    ){return true;}

    @Property
    boolean joiningListOfStrings(@ForAll List<@From("shortStrings") String> listOfStrings) {
        String concatenated = String.join("", listOfStrings);
        return concatenated.length() <= 8 * listOfStrings.size();
    }

    @Property
    boolean joiningListOfStrings1(@ForAll List<@From(supplier=ShortStrings.class) String> listOfStrings) {
        String concatenated = String.join("", listOfStrings);
        return concatenated.length() <= 8 * listOfStrings.size();
    }

    class ShortStrings implements ArbitrarySupplier<String> {
        @Override
        public Arbitrary<String> get() {
            return Arbitraries.strings().withCharRange('a', 'z')
                    .ofMinLength(1).ofMaxLength(8);
        }
    }


    @Provide
    Arbitrary<String> shortStrings() {
        return Arbitraries.strings().withCharRange('a', 'z')
                .ofMinLength(1).ofMaxLength(8);
    }

    /**
     * 可以为provide设置名称
     */
    @Provide("10 to 99")
    Arbitrary<Integer> numbers() {
        return Arbitraries.integers().between(10, 99);
    }
}
