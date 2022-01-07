package test;

import com.kenshine.scope.demo02.MyBean;
import com.kenshine.scope.demo02.ScopeProxyBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 10:18
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestScope.class)
public class TestScope {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        //注册bean
        applicationContext.register(MyBean.class);
        applicationContext.register(ScopeProxyBean.class);
        //刷新
        applicationContext.refresh();
        MyBean bean = applicationContext.getBean(MyBean.class);
        for (int i = 0; i < 10; i++) {
            bean.test();
        }

    }

}

