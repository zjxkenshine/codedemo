package com.kenshine.jqwik;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.assertj.core.api.Assertions;

/**
 * @author by kenshine
 * @Classname JqwikTest02
 * @Description 测试2
 * @Date 2024-01-18 9:25
 * @modified By：
 * @version: 1.0$
 */
public class JqwikTest02 {

    /**
     * 所有数字绝对值大于0
     */
    @Property
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        return Math.abs(anInteger) >= 0;
    }

    /**
     * 串联字符串的长度大于每个字符串的长度
     */
    @Property
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(
            @ForAll String string1, @ForAll String string2
    ) {
        String conc = string1 + string2;
        Assertions.assertThat(conc.length()).isGreaterThan(string1.length());
        Assertions.assertThat(conc.length()).isGreaterThan(string2.length());
    }
}
