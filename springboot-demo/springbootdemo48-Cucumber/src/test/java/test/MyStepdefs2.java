package test;

import com.kenshine.cucumber.CucumberApp;
import com.kenshine.cucumber.service.TestService;
import cucumber.api.java8.Zh_cn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 9:16
 * @description：第二个用例实现类文件
 * @modified By：
 * @version: $
 */
//注意：FuturesApplication引入的是springboot中的启动入口文件，此处为cucumber整合springBoot的关键所在
@SpringBootTest(classes = CucumberApp.class)
//其中SpringBootTest注解即可表示 测试的springBoot项目
public class MyStepdefs2 implements Zh_cn {
    //通过 Autowired注解 注入springBoot中的service层，从而实现在cucumber用例中调用被测项目的service层进行测试
    @Autowired
    TestService testService;

    public MyStepdefs2() {

        /*
         *	其中 假设 当 那么 这样的方法是由 feature文件中自动生成的。
         */
        假设("^today is Sunday$", () -> {
            System.out.println("1");

        });

        当("^I ask whether it's Friday yet$", () -> {
            System.out.println("2");

        });

        那么("^I should be told \"Nop$", () -> {
            System.out.println("3");
            //在用例文件中调用被测项目的service层进行测试
            testService.test("8d018b2027b711ea9a3100163e00a5d2");
        });
    }
}
