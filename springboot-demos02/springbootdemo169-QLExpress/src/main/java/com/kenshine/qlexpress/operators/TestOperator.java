package com.kenshine.qlexpress.operators;

import com.ql.util.express.Operator;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/11 9:01
 * @description：测试自定义操作符
 * @modified By：
 * @version: $
 */
public class TestOperator extends Operator {

    @Override
    public Object executeInner(Object[] list){
        //两个参数
        int a = (Integer)list[0];
        int b = (Integer)list[1];
        return a + b * b;
    }

}
