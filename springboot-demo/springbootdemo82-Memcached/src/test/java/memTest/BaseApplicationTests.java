package memTest;

import com.kenshine.memcached.MemApp;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/14 20:27
 * @description：基础测试
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MemApp.class)
public class BaseApplicationTests {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    private Long time;

    @Before
    public void setUp() {
        this.time = System.currentTimeMillis();
        log.info("==> 测试开始执行 <==");
    }

    @After
    public void tearDown() {
        log.info("==> 测试执行完成，耗时：{} ms <==", System.currentTimeMillis() - this.time);
    }

}
