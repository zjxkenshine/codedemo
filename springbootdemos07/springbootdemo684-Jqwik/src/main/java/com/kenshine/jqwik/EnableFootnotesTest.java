package com.kenshine.jqwik;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.footnotes.EnableFootnotes;
import net.jqwik.api.footnotes.Footnotes;
import org.assertj.core.api.Assertions;

/**
 * @author by kenshine
 * @Classname EnableFootnotesTest
 * @Description EnableFootnotes 开启失败报表打印
 * @Date 2024-01-18 9:39
 * @modified By：
 * @version: 1.0$
 */
@EnableFootnotes
public class EnableFootnotesTest {
    @Property
    void differenceShouldBeBelow42(@ForAll int number1, @ForAll int number2, Footnotes footnotes) {
        int difference = Math.abs(number1 - number2);
        footnotes.addFootnote(Integer.toString(difference));
        Assertions.assertThat(difference).isLessThan(42);
    }
}
