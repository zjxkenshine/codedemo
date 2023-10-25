package com.kenshine.cosid;

import com.kenshine.cosid.mapper.OrderMapper;
import com.kenshine.cosid.pojo.Order;
import me.ahoo.cosid.IdGenerator;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author by kenshine
 * @Classname CosidTest
 * @Description 测试
 * @Date 2023-10-25 9:44
 * @modified By：
 * @version: 1.0$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CosidApp.class)
public class CosidTest {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 自动注入 测试不通过
     */
    @Test
    public void testAdd(){
        Order order=new Order();
        order.setUserId(1L);
        orderMapper.insert(order);
    }

}
