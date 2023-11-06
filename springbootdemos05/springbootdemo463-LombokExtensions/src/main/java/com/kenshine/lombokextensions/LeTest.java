package com.kenshine.lombokextensions;

import de.phoenixmitx.lombokextensions.ArrayExtension;
import lombok.experimental.ExtensionMethod;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname LeTest
 * @Description 测试
 * @Date 2023-11-06 16:36
 * @modified By：
 * @version: 1.0$
 *
 * 使用ArrayExtension中的扩展方法
 */
@ExtensionMethod({ ArrayExtension.class })
public class LeTest {

    @Test
    public  void test01() {
        int[] array = new int[] {1, 2, 3, 4, 5};
        long sum = array.sum();
        System.out.println("Sum of array elements: " + sum);
    }

}
