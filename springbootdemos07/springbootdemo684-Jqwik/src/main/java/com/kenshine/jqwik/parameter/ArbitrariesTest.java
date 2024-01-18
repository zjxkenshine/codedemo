package com.kenshine.jqwik.parameter;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Provide;

import java.util.Random;

/**
 * @author by kenshine
 * @Classname ArbitrariesTest
 * @Description Arbitraries静态方法提供数据
 * @Date 2024-01-18 12:01
 * @modified By：
 * @version: 1.0$
 */
public class ArbitrariesTest {

    @Provide
    Arbitrary<Integer> primesGenerated() {
        // randomValue 随机值
        return Arbitraries.randomValue(random -> generatePrime(random));
    }

    private Integer generatePrime(Random random) {
        int candidate;
        do {
            candidate = random.nextInt(10000) + 2;
        } while (candidate>9900);
        return candidate;
    }
}
