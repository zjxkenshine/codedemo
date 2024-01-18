package com.kenshine.jqwik;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.PropertyDefaults;
import net.jqwik.api.ShrinkingMode;

/**
 * @author by kenshine
 * @Classname PropertyDefaultTest
 * @Description @PropertyDefaults 全局设置property参数
 * @Date 2024-01-18 10:22
 * @modified By：
 * @version: 1.0$
 */
@PropertyDefaults(tries = 10, shrinking = ShrinkingMode.FULL)
public class PropertyDefaultTest {
    @Property
    void aLongRunningProperty(@ForAll String aString) {}

    /**
     *  单独设置属性
     */
    @Property(tries = 100,shrinking = ShrinkingMode.OFF)
    void anotherLongRunningProperty(@ForAll String aString) {}
}
