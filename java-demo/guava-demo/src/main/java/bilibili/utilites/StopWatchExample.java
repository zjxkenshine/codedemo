package bilibili.utilites;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 15:13
 * @description： StopWatch 日志测试
 * @modified By：
 * @version: $
 */
@Slf4j
public class StopWatchExample {

    public static void main(String[] args) throws InterruptedException {
        process("156848985");
    }

    public static void process(String orderNo) throws InterruptedException {
        log.info("order no [{}]",orderNo);
        //启动stopWatch
        Stopwatch stopwatch = Stopwatch.createStarted();
        //TimeUnit.SECONDS.sleep(1);
        TimeUnit.MILLISECONDS.sleep(100);
        //花费多少时间 stopwatch.stop() 单位会随着时间单位变化   .elapsed()指定时间单位
        log.info(" ther order [{}] process successful and elapsed [{}]",orderNo,stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
    }

    /**
     * Stopwatch
     * 扩展 ServiceLoader  java6之后本身的特性，不是guava的
     * 可以加载jar包中的Service
     */



}
