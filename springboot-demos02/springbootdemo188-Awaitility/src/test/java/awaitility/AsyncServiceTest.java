package awaitility;

import com.kenshine.awaitility.service.AsyncService;
import org.awaitility.Awaitility;
import org.awaitility.proxy.AwaitilityClassProxy;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static org.hamcrest.Matchers.equalTo;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/19 21:09
 * @description：测试
 * @modified By：
 * @version: $
 */
public class AsyncServiceTest {
    private AsyncService asyncService;

    @Before
    public void setUp() {
        asyncService = new AsyncService();
    }

    /**
     * 1.基本用法
     * Awaitility.await().until
     */
    @Test
    public void test01(){
        asyncService.initialize();
        //基本用法，不加这句直接测试完成
        Awaitility.await().until(asyncService::isInitialized);
    }

    /**
     * 2.自定义停止时间，轮询间隔时间等
     * 也可以使用Awaitility.setxxx来设置默认时间
     */
    @Test
    public void test02(){
        asyncService.initialize();
        //指定时间内isInitialized方法未执行完毕则测试失败
        Awaitility.await()
                //最少停止
                .atLeast(Duration.ofMillis(1000))
                //最长等待时间
                .atMost(Duration.ofSeconds(5))
                //with 返回ConditionFactory自身 this
                //轮询时间间隔
                .with().pollInterval(Duration.ofMillis(100))
                .until(asyncService::isInitialized);
    }

    /**
     * 3. 使用hamcrest匹配器检测结果
     */
    @Test
    public void test03(){
        asyncService.initialize();
        Awaitility.await().until(asyncService::isInitialized);
        long value = 5;
        asyncService.addValue(value);
        //断言执行结果
        Awaitility.await().until(asyncService::getValue, equalTo(value));
    }

    /**
     * 4.忽略异常
     * Awaitility.given().ignoreException
     */
    @Test
    public void test04(){
        asyncService.initialize();
        //没有等待初始化完成就指向getValue方法，会报IllegalStateException异常
        Awaitility.given().ignoreException(IllegalStateException.class)
                .await().atMost(Duration.ofSeconds(5))
                .atLeast(Duration.ofMillis(500))
                .until(asyncService::getValue, equalTo(0L));
    }

    /**
     * 5.使用代理
     * 4.1.1版本已经删除了utilCall方法，不是必须要使用代理
     *
     */
    @Test
    public void test05(){
        asyncService.initialize();
        //Awaitility.await().untilCall(to(asyncService).isInitialized(), equalTo(true));
        Awaitility.await().untilTrue(asyncService.isInitializedAtomic());
    }


    /**
     * 6.对字段使用断言
     */
    @Test
    public void test06(){
        asyncService.initialize();
        Awaitility.await()
                        //asyncService中的字段
                        .until(Awaitility.fieldIn(asyncService)
                        .ofType(boolean.class)
                         //字段名称
                        .andWithName("initialized"), equalTo(true));
    }


}
