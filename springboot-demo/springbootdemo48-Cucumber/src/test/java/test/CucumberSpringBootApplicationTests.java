package test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 9:03
 * @description：测试
 * @modified By：
 * @version: $
 */
@RunWith(Cucumber.class) //通过Cucumber方式运行这个类
@CucumberOptions(features = "classpath:features/") //classpath:features/ 表示要运行用例描述文件的目录
public class CucumberSpringBootApplicationTests {

}
