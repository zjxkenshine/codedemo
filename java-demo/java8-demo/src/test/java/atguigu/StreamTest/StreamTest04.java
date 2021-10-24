package atguigu.StreamTest;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 18:20
 * @description：并行流测试
 * @modified By：
 * @version: $
 *
 * test01 自定义ForkJoin测试
 * test02 普通for循环
 * test03 Java8 并行流/串行流
 *
 */
public class StreamTest04 {
    /**
     * ForkJoin 框架
     * 有误
     */
    @Test
    public void test01(){
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinCalculate task = new ForkJoinCalculate(0, 100000000L);

        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getNano());
    }

    /**
     * 普通 for循环
     */
    @Test
    public void test02(){
        Instant start = Instant.now();

        Long sum = 0L;
        for (long i = 0; i < 100000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getNano());
    }

    @Test
    public void test03(){
        //串行流(单线程)：切换为并行流 parallel()
        //并行流：切换为串行流 sequential()
        //rangeClose生成的顺序流会包含最大的数
        Long sum =LongStream.range(0, 100000000L)
                .parallel() //底层：ForkJoin
                .reduce(0, Long::sum);
        System.out.println(sum);
    }


}
