package awaitility;

import com.kenshine.awaitility.schedule.Counter;
import com.kenshine.awaitility.schedule.ScheduledConfig;
import org.awaitility.Awaitility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/19 22:03
 * @description：测试定时任务
 * @modified By：
 * @version: $
 */
@SpringJUnitConfig(ScheduledConfig.class)
@RunWith(SpringRunner.class)
public class ScheduledTest {

    /**
     * @SpyBean 生成不受spring管理的bean并调用真实方法
     * @MockBean 调用mock方法
     */
    @SpyBean
    private Counter counter;

    /**
     * 测试定时任务
     */
    @Test
    public void test07() {
        Awaitility.await()
                  .atMost(Duration.ofSeconds(2))
                  //2秒内至少调用了10次counter中的scheduled方法
                  .untilAsserted(() -> Mockito.verify(counter, Mockito.atLeast(10)).scheduled());
    }
}
