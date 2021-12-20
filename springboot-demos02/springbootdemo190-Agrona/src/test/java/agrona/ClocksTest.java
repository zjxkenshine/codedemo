package agrona;

import org.agrona.concurrent.CachedEpochClock;
import org.agrona.concurrent.EpochClock;
import org.agrona.concurrent.SystemEpochClock;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 10:34
 * @description：Clock测试
 * @modified By：
 * @version: $
 */
public class ClocksTest {

    /**
     * CachedEpochClock
     */
    @Test
    public void test01(){
        CachedEpochClock clock = new CachedEpochClock();
        clock.update(1L);
        System.out.println(clock.time());

        clock.update(2L);
        System.out.println(clock.time());

        clock.advance(98L);
        System.out.println(clock.time());
    }

    /**
     * SystemEpochClock
     */
    @Test
    public void test02(){
        EpochClock clock = SystemEpochClock.INSTANCE;
        System.out.println(clock.time());
    }

}
