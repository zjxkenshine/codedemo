package base;

import com.kenshine.testng.TestNgApp;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 8:32
 * @description：测试基类
 * @modified By：
 * @version: $
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestNgApp.class)
public abstract class BaseCase extends AbstractTestNGSpringContextTests {
    /**
     * 若是引用Junit的@Test，import org.junit.Test;则不用继承AbstractTestNGSpringContextTests类
     *
     * 若用的是TestNG框架的，import org.testng.annotations.Test;创建测试类的时候则要继承AbstractTestNGSpringContextTests类
     */
}
