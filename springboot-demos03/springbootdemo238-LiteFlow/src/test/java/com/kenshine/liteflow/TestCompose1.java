package com.kenshine.liteflow;

import com.yomahub.liteflow.core.FlowExecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TestChuan
 * @Description 基本编排测试
 * @Date 2023/3/8 15:45
 * @modified By：
 * @version: 1.0$
 */
@SpringBootTest(classes = LiteFlowApp.class )
@RunWith(SpringRunner.class)
public class TestCompose1 {

    @Resource
    private FlowExecutor flowExecutor;

    // 串行编排
    @Test
    public void testChuan(){
        flowExecutor.execute2Resp("chuan1");
    }

    // 并行编排
    @Test
    public void testBin1(){
        flowExecutor.execute2Resp("bin1");
    }

    // 并行编排 串行与并行
    @Test
    public void testBin2(){
        flowExecutor.execute2Resp("bin2");
    }

    // 并行编排 忽略错误
    @Test
    public void testBin3(){
        flowExecutor.execute2Resp("bin3");
    }

    //并行流程中，任一条分支先执行完即忽略其他分支
    @Test
    public void testBin4(){
        flowExecutor.execute2Resp("bin4");
    }

    //选择分支
    @Test
    public void testXuan1(){
        flowExecutor.execute2Resp("xuan1");
    }

    //选择流程，根据id选择分支
    @Test
    public void testXuan2(){
        flowExecutor.execute2Resp("xuan2");
    }

    //选择流程，根据tag选择分支
    @Test
    public void testXuan3(){
        flowExecutor.execute2Resp("xuan3");
    }


    //条件组件
    @Test
    public void testIf1(){
        flowExecutor.execute2Resp("if1");
    }

    //条件组件
    @Test
    public void testIf2(){
        flowExecutor.execute2Resp("if2");
    }

    //if3
    @Test
    public void testIf3(){
        flowExecutor.execute2Resp("if3");
    }

    //循环编排
    @Test
    public void testFor1(){
        flowExecutor.execute2Resp("for1");
    }

    //次数循环编排
    @Test
    public void testFor2(){
        flowExecutor.execute2Resp("for2");
    }

    //条件循环编排 while
    @Test
    public void testFor3(){
        flowExecutor.execute2Resp("for3");
    }

    //迭代循环编排 iterator
    @Test
    public void testFor4(){
        flowExecutor.execute2Resp("for4");
    }

    //退出循环
    @Test
    public void testFor5(){
        flowExecutor.execute2Resp("for5");
    }


}
