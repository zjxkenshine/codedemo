package test;

import com.kenshine.factoriesLoader.service.TestService;
import org.junit.Test;
import org.springframework.beans.BeanInfoFactory;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.util.ClassUtils;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/14 9:54
 * @description：测试
 * @modified By：
 * @version: $
 */
public class factoriesLoaderTest {
    @Test
    public void testLoadFactoryNames() {
        //获取所有META-INF/spring.factories中的value值
        List<String> applicationContextInitializers = SpringFactoriesLoader.loadFactoryNames(BeanInfoFactory.class, ClassUtils.getDefaultClassLoader());
        for (String applicationContextInitializer : applicationContextInitializers) {
            System.out.println(applicationContextInitializer);
        }
    }

    @Test
    public void testLoadFactories() {
        //实例化所有在META-INF/spring.factories配置的且实现BeanInfoFactory接口的类
        List<BeanInfoFactory> beanInfoFactories = SpringFactoriesLoader.loadFactories(BeanInfoFactory.class, ClassUtils.getDefaultClassLoader());

        //ExtendedBeanInfoFactory：springboot默认实现的BeanInfoFactory
        for (BeanInfoFactory beanInfoFactory : beanInfoFactories) {
            System.out.println(beanInfoFactory);
        }
    }

    /**
     * 加载TestService
     */
    @Test
    public void test02_loadFactoryNames() {
        //获取所有META-INF/spring.factories中的value值
        List<String> applicationContextInitializers = SpringFactoriesLoader.loadFactoryNames(TestService.class, ClassUtils.getDefaultClassLoader());
        for (String applicationContextInitializer : applicationContextInitializers) {
            System.out.println(applicationContextInitializer);
        }
    }

    @Test
    public void test02_testLoadFactories() {
        //实例化所有在META-INF/spring.factories配置的且实现BeanInfoFactory接口的类
        List<TestService> beanInfoFactories = SpringFactoriesLoader.loadFactories(TestService.class, ClassUtils.getDefaultClassLoader());

        //ExtendedBeanInfoFactory：springboot默认实现的BeanInfoFactory
        for (TestService testService : beanInfoFactories) {
            System.out.println(testService);
        }
    }

}
