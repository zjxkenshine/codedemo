package com.kenshine.jqwik;

import net.jqwik.api.Example;
import org.assertj.core.data.Offset;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author by kenshine
 * @Classname ExampleBasedTests
 * @Description @Example,仅执行一次
 * @Date 2024-01-18 10:28
 * @modified By：
 * @version: 1.0$
 */
public class ExampleBasedTests {
    @Example
    void squareRootOf16is4() {
        assertThat(Math.sqrt(16)).isCloseTo(4.0, Offset.offset(0.01));
    }

    @Example
    boolean add1plu3is4() {
        return (1 + 3) == 4;
    }
}
