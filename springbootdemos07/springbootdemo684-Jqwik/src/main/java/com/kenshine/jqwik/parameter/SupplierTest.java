package com.kenshine.jqwik.parameter;

import net.jqwik.api.*;

/**
 * @author by kenshine
 * @Classname SupplierTest
 * @Description 实现ArbitrarySupplier作为提供者
 * @Date 2024-01-18 11:47
 * @modified By：
 * @version: 1.0$
 */
public class SupplierTest {
    @Property
    boolean concatenatingStringWithInt(
            @ForAll(supplier = ShortStrings.class) String aShortString,
            @ForAll(supplier = TenTo99.class) int aNumber
    ) {
        String concatenated = aShortString + aNumber;
        return concatenated.length() > 2 && concatenated.length() < 11;
    }

    class ShortStrings implements ArbitrarySupplier<String> {
        @Override
        public Arbitrary<String> get() {
            return Arbitraries.strings().withCharRange('a', 'z')
                    .ofMinLength(1).ofMaxLength(8);
        }
    }

    class TenTo99 implements ArbitrarySupplier<Integer> {
        @Override
        public Arbitrary<Integer> get() {
            return Arbitraries.integers().between(10, 99);
        }
    }
}
