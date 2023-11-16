package com.kenshine.mutabilitydetector;
import org.junit.Test;

import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

/**
 * @author by kenshine
 * @Classname TestImmutable
 * @Description 可变性检测
 * @Date 2023-11-16 11:41
 * @modified By：
 * @version: 1.0$
 */
public class TestImmutable {

    @Test
    public void testString(){
        // java.lang.String is actually NOT_IMMUTABLE ？？？
        assertImmutable(String.class);
    }

    /**
     * User为不可变类
     */
    @Test
    public void testUser(){
        assertImmutable(User.class);
    }
}
