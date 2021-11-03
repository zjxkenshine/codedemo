package test;

import com.kenshine.cucumber.CucumberApp;
import com.kenshine.cucumber.service.TestService;
import cucumber.api.java8.Zh_cn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 9:08
 * @description：第一个用例实现文件
 * @modified By：
 * @version: $
 *
 * * 注意：在这个用例实现文件中可以不用导入 springBoot的启动入口文件，也就是不管
 * * 有多少个用例文件时，只需要保证有一个用例文件导入了 springBoot的启动入口文件即可，比如我这就只
 * * 在 MyStepdefs2.java 进行了 导入：@SpringBootTest(classes = CucumberApp.class)
 * 导入多个会报错
 */
//@SpringBootTest(classes = CucumberApp.class)
public class MyStepdefs1 implements Zh_cn {
    String name;

    @Autowired
    TestService testService;

    public MyStepdefs1() {
        当("^the client calls \\/greeting", () -> {
            System.out.println("-----Cucumber框架 即将调用spring boot框架 中的代码----");

            //此处为调用 springBoot中service层代码，从而得到返回数据可进行被测项目的测试
            testService.test("8d018b2027b711ea9a3100163e00a5d2");
        });

        假设("名字是 {string}", (String name) -> {
            this.name = name;
        });

        那么("客户端返回码 {int}", (Integer statusCode) -> {
            assert true;
        });

        同时("the client receives content {string}", (String greeting) -> {
            assert true;
        });
    }

}
