package com.kenshine.cc;

import com.kidsoncoffee.cheesecakes.Parameter.Expectation;
import com.kidsoncoffee.cheesecakes.Parameter.Requisite;
import com.kidsoncoffee.cheesecakes.runner.Cheesecakes;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author by kenshine
 * @Classname CheeseCakeTest
 * @Description 使用测试
 * @Date 2024-02-02 19:10
 * @modified By：
 * @version: 1.0$
 * 以注释的方式绑定数据
 */
@RunWith(Cheesecakes.class)
public class CCTest {

    /**
     * 以注释的方式绑定数据
     *
     * <pre>
     * Examples:
     *
     * firstName | lastName | completeName
     * --------- | -------- | --------------
     * John      | Doe      | John Doe
     * Exene     | Cervenka | Exene Cervenka
     * </pre>
     */
    @Test
    public void test01(
            @Requisite final String firstName,
            @Requisite final String lastName,
            @Expectation final String completeName) {
        final String actualCompleteName;

        when:
        actualCompleteName = String.format("%s %s", firstName, lastName);

        then:
        assert actualCompleteName.equals(completeName);
    }

}
