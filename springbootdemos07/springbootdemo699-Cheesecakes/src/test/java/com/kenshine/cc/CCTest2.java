package com.kenshine.cc;

import com.kidsoncoffee.cheesecakes.Example;
import com.kidsoncoffee.cheesecakes.Parameter;
import com.kidsoncoffee.cheesecakes.runner.Cheesecakes;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author by kenshine
 * @Classname CCTest2
 * @Description 编程方式绑定数据
 * @Date 2024-02-02 19:20
 * @modified By：
 * @version: 1.0$
 */
@RunWith(Cheesecakes.class)
public class CCTest2 {
    // 自动生成的CCTest2_ExampleBuilder类中的方法进行绑定
    private static Example.Builder JOHN_DOE_EXAMPLE =
            CCTest2_ExampleBuilder.ConcatenatesSuccessfully.given()
                    .firstName("John")
                    .lastName("Doe")
                    .then()
                    .completeName("John Doe")
                    .getExample();

    private static Example.Builder EXENE_CERVENKA_EXAMPLE =
            CCTest2_ExampleBuilder.ConcatenatesSuccessfully.given()
                    .firstName("Exene")
                    .lastName("Cervenka")
                    .then()
                    .completeName("Exene Cervenka")
                    .getExample();

    @Test
    public void concatenatesSuccessfully(
            @Parameter.Requisite final String firstName,
            @Parameter.Requisite final String lastName,
            @Parameter.Expectation final String completeName) {
        final String actualCompleteName;

        when:
        actualCompleteName = String.format("%s %s", firstName, lastName);

        then:
        assert actualCompleteName.equals(completeName);
    }
}
