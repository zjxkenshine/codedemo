package com.kenshine.jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/31 22:57
 * @description：测试指令重排序
 * @modified By：
 * @version: $
 */
@JCStressTest
@State
@Outcome(id = {"1", "4"}, expect = Expect.ACCEPTABLE, desc = "这是期待的结果")
@Outcome(id = "0", expect = Expect.ACCEPTABLE_INTERESTING, desc = "这是不期待的结果")
public class TestJCStress {
    /**
     * 结果有三种可能 4， 1，0(这个0是因为指令重排）
     */
    private int a = 0;
    private boolean flag = false;
    @Actor
    public void method(I_Result result) {
        if (flag) {
            result.r1 = a * 2;
        } else {
            result.r1 = 1;
        }
    }

    @Actor
    public void method2(I_Result result) {
        a = 2;               //这个地方有可能会发生指令重排，也就是a=2和flag=true互换
        flag = true;
    }

}
