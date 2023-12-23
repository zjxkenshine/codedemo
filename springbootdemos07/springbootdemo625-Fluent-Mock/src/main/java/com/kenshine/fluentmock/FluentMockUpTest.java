package com.kenshine.fluentmock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.test4j.annotations.Mocks;

import java.util.Calendar;
import java.util.Locale;

/**
 * @author by kenshine
 * @Classname FluentMockUpTest
 * @Description 使用Fluent API方式
 * @Date 2023-12-23 14:15
 * @modified By：
 * @version: 1.0$
 *
 * 指明在fluent接口中要mock的类, Annotation Processor会根据@Mocks定义
 * 生成Test类+Mocks命名的指导类, 在这里是：FluentMockUpTestMocks
 */
@Mocks({Calendar.class})
public class FluentMockUpTest {
    private FluentMockUpTestMocks mocks = new FluentMockUpTestMocks();

    @DisplayName("使用fluent方式对自带类Calendar的get方法进行定制")
    @Test
    public void testMockUp() {
        mocks.Calendar(faker -> {
            /**
             * 指定要mock get方法, 同时实现get的mock逻辑
             */
            faker.get.restAnswer(inv -> {
                int unit = inv.arg(0);
                switch (unit) {
                    case Calendar.YEAR:
                        return 2023;
                    case Calendar.MONDAY:
                        return 12;
                    case Calendar.DAY_OF_MONTH:
                        return 23;
                    case Calendar.HOUR_OF_DAY:
                        return 14;
                    default:
                        return 0;
                }
            });
        });
        // 从此Calendar的get方法，就沿用你定制过的逻辑，而不是它原先的逻辑。
        Calendar cal = Calendar.getInstance(Locale.FRANCE);
        Assertions.assertEquals(cal.get(Calendar.YEAR), 2023);
        Assertions.assertEquals(cal.get(Calendar.MONTH), 12);
        Assertions.assertEquals(cal.get(Calendar.DAY_OF_MONTH), 23);
        Assertions.assertEquals(cal.get(Calendar.HOUR_OF_DAY), 14);
        // Calendar的其它方法，不受影响
        Assertions.assertTrue((cal.getFirstDayOfWeek() == Calendar.MONDAY));
    }
}
