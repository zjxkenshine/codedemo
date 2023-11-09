package com.kenshine.lombokex;

import com.github.houbb.lombok.ex.annotation.Modifiers;
import com.github.houbb.lombok.ex.constant.Flags;

/**
 * @author kenshine
 * @Modifiers 修饰符
 */
@Modifiers(Flags.FINAL)
public class ModifiersTest {

    @Modifiers(Flags.VOLATILE)
    private int value;

    @Modifiers(Flags.SYNCHRONIZED)
    public static void syncTest() {
        System.out.println("sync");
    }

}