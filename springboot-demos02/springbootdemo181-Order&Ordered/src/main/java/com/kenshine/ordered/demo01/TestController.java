package com.kenshine.ordered.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/15 10:15
 * @description：测试顺序
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {
    @Autowired
    public List<IOrder> testList;

    @Autowired
    public List<IPriority> priorityList;

    /**
     * http://localhost:8080/testOrder
     */
    @GetMapping("/testOrder")
    public void testOrder(){
        for(IOrder test:testList){
            test.test();
        }
    }

    /**
     * http://localhost:8080/testPriority
     */
    @GetMapping("/testPriority")
    public void testPriority(){
        for(IPriority test:priorityList){
            test.test();
        }
    }


}
