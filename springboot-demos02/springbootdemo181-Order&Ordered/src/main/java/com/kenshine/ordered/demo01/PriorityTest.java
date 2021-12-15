package com.kenshine.ordered.demo01;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.Priority;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/15 10:18
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class PriorityTest {

    /**
     * @Priority 越大优先执行
     */
    @Service
    @Priority(2)
    public class Test1 implements IPriority {
        @Override
        public void test() {
            System.out.println(1);
        }
    }

    @Service
    @Priority(3)
    public class Test2 implements IPriority {
        @Override
        public void test() {
            System.out.println(2);
        }
    }

    @Service
    @Priority(1)
    public class Test3 implements IPriority{
        @Override
        public void test() {
            System.out.println(3);
        }
    }
}
