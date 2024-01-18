package com.kenshine.jqwik.parameter;

import net.jqwik.api.*;
import net.jqwik.api.providers.TypeUsage;

import java.math.BigInteger;

/**
 * @author by kenshine
 * @Classname ProvideTest
 * @Description provide自定义数据提供
 * @Date 2024-01-18 11:43
 * @modified By：
 * @version: 1.0$
 */
public class ProvideTest {

    @Property
    boolean concatenatingStringWithInt(
            @ForAll("shortStrings") String aShortString,
            @ForAll("10 to 99") int aNumber
    ) {
        String concatenated = aShortString + aNumber;
        return concatenated.length() > 2 && concatenated.length() < 11;
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

    /**
     * 多个Property使用同一个Provide
     */
    @Property
    void favouritePrimesAsInts(@ForAll("favouritePrimes") int aFavourite) {  }

    @Property
    void favouritePrimesAsBigInts(@ForAll("favouritePrimes") BigInteger aFavourite) {  }

    @Provide
    Arbitrary<?> favouritePrimes(TypeUsage targetType) {
        Arbitrary<Integer> ints = Arbitraries.of(3, 5, 7, 13, 17, 23, 41);
        if (targetType.getRawType().equals(BigInteger.class)) {
            return ints.map(BigInteger::valueOf);
        }
        return ints;
    }
}
