package jmhtest;

import com.alibaba.fastjson.JSON;
import com.kenshine.jmh.JMHApp;
import com.kenshine.jmh.model.User;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/4 8:41
 * @description：JSON基准测试
 * @modified By：
 * @version: $
 */
@Slf4j
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Threads(2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
//指定字段的共享域，指定@State(Scope.Thread)则每个线程共享域不同
@State(Scope.Benchmark)
public class BenchmarkTest {


    /**
     * 指定基准测试参数数组
     */
    @Param(value ={"kenshine","jaken","qin"})
    private String name;



    //    //使用多少个线程来执行基准测试方法 可以执行每秒5*2次基准测试，根据@Measurement指定参数
//    @Threads(2)
//    //不需要多个进程
//    @Fork(1)
//    // 指定输出的耗时时长的单位,时间粒度
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    //基准测试前的预热
//    @Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
//    //每秒测试5次
//    @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
//    // 指定mode为Mode.AverageTime平均时长
//    @BenchmarkMode(Mode.AverageTime)
    //说明是基准测试
    @Benchmark
    public String testBenchMark() {
        User user = new User().setId(1).setName(name).setDesc("躺平程序员").setAge("25");
        return JSON.toJSONString(user);
    }


    /**
     * IDEA安装了JMH Plugin插件则不用执行这个
     * 三种执行方式：
     *  - jar包
     *  - Options
     *  - JMH插件
     *
     * @param args
     * @throws RunnerException
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkTest.class.getSimpleName())
                //输出地址
                //.output();
                .build();
        new Runner(opt).run();
    }



}
