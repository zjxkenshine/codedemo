package com.kenshine.fauxflake;

import com.github.rholder.fauxflake.IdGenerators;
import com.github.rholder.fauxflake.api.IdGenerator;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname FauxflakeTest
 * @Description 使用测试
 * @Date 2024-03-06 12:03
 * @modified By：
 * @version: 1.0$
 */
public class FauxflakeTest {

    /**
     * 简单使用
     */
    @Test
    public void test01() throws InterruptedException {
        IdGenerator snowflake = IdGenerators.newSnowflakeIdGenerator();
        // 1000 放弃前等待的最长时间（毫秒）
        String id = snowflake.generateId(1000).asString();
        System.out.println(id);
    }
}
