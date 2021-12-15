package com.kenshine.ordered.demo02;

import org.springframework.core.OrderComparator;
import org.springframework.core.PriorityOrdered;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/15 10:29
 * @description：测试提供类
 * @modified By：
 * @version: $
 */
public class TestProvider implements OrderComparator.OrderSourceProvider {
    private Map<String, PriorityOrdered> map= new HashMap<>();

    public TestProvider(){
        map.put("a",new Order01());
        map.put("b",new Order02());
    }

    @Override
    public Object getOrderSource(Object obj) {
        return map.get(obj);
    }

}
