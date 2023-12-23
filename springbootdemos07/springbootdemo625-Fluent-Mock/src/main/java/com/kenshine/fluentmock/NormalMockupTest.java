package com.kenshine.fluentmock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.test4j.annotations.Mock;
import org.test4j.mock.MockUp;

import java.util.Calendar;
import java.util.Locale;

/**
 * @author by kenshine
 * @Classname NormalMockupTest
 * @Description 传统方式使用mock
 * @Date 2023-12-23 13:37
 * @modified By：
 * @version: 1.0$
 */
public class NormalMockupTest {

    @DisplayName("对Java自带类Calendar的get方法进行定制")
    @Test
    public void test01(){
        /**
         * 只需要把Calendar类传入MockUp类的构造函数即可
         */
        new MockUp<Calendar>(Calendar.class) {
            /**
             * 想Mock哪个方法，就给哪个方法加上@Mock，没有@Mock的方法，不受影响
             */
            @Mock
            public int get(int unit) {
                if (unit == Calendar.YEAR) {
                    return 2023;
                }
                if (unit == Calendar.MONDAY) {
                    return 12;
                }
                if (unit == Calendar.DAY_OF_MONTH) {
                    return 23;
                }
                if (unit == Calendar.HOUR_OF_DAY) {
                    return 14;
                }
                return 0;
            }
        };
        // 从此Calendar的get方法，就沿用你定制过的逻辑，而不是它原先的逻辑。
        Calendar cal = Calendar.getInstance(Locale.FRANCE);
        Assertions.assertEquals(cal.get(Calendar.YEAR), 2023);
        Assertions.assertEquals(cal.get(Calendar.MONTH), 12);
        Assertions.assertEquals(cal.get(Calendar.DAY_OF_MONTH), 23);
        Assertions.assertEquals(cal.get(Calendar.HOUR_OF_DAY), 14);
        // Calendar的其它方法，不受影响
        Assertions.assertTrue((cal.getFirstDayOfWeek() == Calendar.MONDAY));
        System.out.println(cal);
    }


}
