package com.kenshine.javaslang;

import javaslang.control.Option;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author by kenshine
 * @Classname OptionTest
 * @Description Option null校验
 * @Date 2024-01-11 8:42
 * @modified By：
 * @version: 1.0$
 */
public class OptionTest {

    /**
     * 不会因为NPE而崩溃
     */
    @Test
    public void test01(){
        Option<Object> noneOption = Option.of(null);
        Option<Object> someOption = Option.of("val");
        // null也有返回值
        assertEquals("None", noneOption.toString());
        assertEquals("Some(val)", someOption.toString());
    }

    /**
     * null值处理，不会崩溃
     */
    @Test
    public void test02(){
        String name = null;
        Option<String> nameOption = Option.of(name);
        assertEquals("baeldung", nameOption.getOrElse("baeldung"));

        String name1 = "baeldung";
        Option<String> nameOption1 = Option.of(name1);
        assertEquals("baeldung", nameOption1.getOrElse("notbaeldung"));
    }
}
