package com.kenshine.tinylog;

import org.junit.Test;
import org.tinylog.Logger;
import org.tinylog.TaggedLogger;
import org.tinylog.ThreadContext;

import java.time.LocalDate;

/**
 * @author by kenshine
 * @Classname TinylogTest
 * @Description 使用测试
 * @Date 2024-03-09 11:24
 * @modified By：
 * @version: 1.0$
 */
public class TinylogTest {

    /**
     * 入门
     */
    @Test
    public void test01(){
        Logger.info("Hello {}!", "world");

        Logger.debug("Hello World!");
        Logger.info("Hello World!");
        Logger.warn("Hello World!");
        Logger.error("Hello World!");
    }

    /**
     * 消息格式处理
     */
    @Test
    public void test02(){
        Logger.info("Hello World!");
        String a = "a1";
        String b = "b1";
        // 占位
        Logger.info("Divide {} by {}", a, b);
        Double amount=5.235;
        // 金额
        Logger.info("Income: {0.00} EUR", amount);
        // 条件格式设置
        Logger.info("There {0#are no files|1#is one file|1<are {} files}", 3);
        // 可以通过使用单引号来转义大括号或整个短语
        Logger.info("Curly brackets as placeholder {} or escaped '{}'", "A");
        // 对象
        Logger.info(LocalDate.now());
        // 异常
        Logger.info(new Exception("test"));
        // 异常信息设置
        Logger.info(new Exception("test"), "Cannot divide {} by {}", a, b);
    }

    /**
     * 其他消息
     */
    @Test
    public void test03(){
        // 懒日志
        Logger.info(this::compute);
        // tag
        Logger.tag("SYSTEM").info("Hello World!");
        TaggedLogger logger = Logger.tags("FOO", "BAR", "BAZ");
        logger.info("Hello World!");
        // 设置context 可以在配置文件的输出格式配置中使用
        ThreadContext.put("user", "kenshine");
        // 清除
        ThreadContext.clear();
    }

    private Object compute() {
        return LocalDate.now();
    }
}
