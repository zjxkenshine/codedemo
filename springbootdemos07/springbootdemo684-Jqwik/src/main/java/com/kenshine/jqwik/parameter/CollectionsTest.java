package com.kenshine.jqwik.parameter;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname CollectionsTest
 * @Description 集合相关约束
 * @Date 2024-01-18 11:23
 * @modified By：
 * @version: 1.0$
 */
public class CollectionsTest {
    @Property
    public void uniqueInList(@ForAll @Size(5) @UniqueElements List<@IntRange(min = 0, max = 10) Integer> aList) {
        Assertions.assertThat(aList).doesNotHaveDuplicates();
        Assertions.assertThat(aList).allMatch(anInt -> anInt >= 0 && anInt <= 10);
    }

    @Property
    void listOfStringsTheFirstCharacterOfWhichMustBeUnique(
            @ForAll @Size(max = 25) @UniqueElements(by = FirstChar.class)
                    List<@AlphaChars @StringLength(min = 1, max = 10) String> listOfStrings
    ) {
        Iterable<Character> firstCharacters = listOfStrings.stream().map(s -> s.charAt(0)).collect(Collectors.toList());
        Assertions.assertThat(firstCharacters).doesNotHaveDuplicates();
    }

    private class FirstChar implements Function<String, Object> {
        @Override
        public Object apply(String aString) {
            return aString.charAt(0);
        }
    }

    /**
     * 约束List
     */
    @Property
    void aProperty(@ForAll @Size(min= 1) List<@StringLength(max=10) String> listOfStrings) {
    }

    /**
     * 约束数组
     */
    @Property
    void myProperty(@ForAll("stringArrays") String[] aStringArray) {}

    @Provide
    Arbitrary<String[]> stringArrays() {
        return Arbitraries.strings().injectNull(0.05).array(String[].class).injectNull(0.05);
    }
}
