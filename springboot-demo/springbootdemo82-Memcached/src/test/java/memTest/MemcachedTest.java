package memTest;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeoutException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/14 20:28
 * @description：测试
 * @modified By：
 * @version: $
 */
public class MemcachedTest extends BaseApplicationTests{
    @Autowired
    private MemcachedClient memcachedClient;

    @Test
    public void test() throws InterruptedException, TimeoutException, MemcachedException {
        // 放入缓存
        boolean flag = memcachedClient.set("a", 0,  1);

        // 取出缓存
        Object a = memcachedClient.get("a");
        log.warn("a is [{}]", a);

        // 3s后过期
        memcachedClient.set("b", 3, 2);
        Object b = memcachedClient.get("b");
        log.warn("b is [{}]", b);

        Thread.sleep(3000);
        b = memcachedClient.get("b");
        log.warn("b is [{}]", b);
    }

}
