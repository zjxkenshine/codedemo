package com.kenshine.ordered.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Priority;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/15 10:09
 * @description：测试Order顺序
 * @modified By：
 * @version: $
 */
@Configuration
public class OrderTest {

    @Service
    @Order(3)
    public class Test1 implements IOrder {
        @Override
        public void test() {
            System.out.println(1);
        }
    }

    @Service
    @Order(2)
    public class Test2 implements IOrder {
        @Override
        public void test() {
            System.out.println(2);
        }
    }

    @Service
    @Order(1)
    public class Test3 implements IOrder,Ordered {
        @Override
        public void test() {
            System.out.println(3);
        }

        /**
         * 会覆盖@Order 在最后执行
         * @return
         */
        @Override
        public int getOrder() {
            return 4;
        }
    }

}
