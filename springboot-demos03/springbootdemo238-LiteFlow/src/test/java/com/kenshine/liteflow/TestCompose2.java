package com.kenshine.liteflow;

import com.kenshine.liteflow.context.CustomContext;
import com.yomahub.liteflow.builder.el.LiteFlowChainELBuilder;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.flow.entity.CmpStep;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author by kenshine
 * @Classname TestCompose2
 * @Description 高级编排功能测试
 * @Date 2023/3/17 8:28
 * @modified By：
 * @version: 1.0$
 */
@SpringBootTest(classes = LiteFlowApp.class )
@RunWith(SpringRunner.class)
public class TestCompose2 {
    @Resource
    private FlowExecutor flowExecutor;

    // catch捕获异常 V2.10.0上线
    @Test
    public void testCatch(){
        flowExecutor.execute2Resp("ca1");
    }


    // 规则检验
    @Test
    public void yourMethod() {
        boolean isValid = LiteFlowChainELBuilder.validate("THEN(a, b, c)");
        System.out.println(isValid);
    }

    // 自定义上下文 流程入参
    @Test
    public void testContext(){
//        CustomContext ctx1 = new CustomContext();
//        ctx1.setData("key1","value1");
        // 流程入参，是整个流程的入参。需要通过reqeustData去取，而上下文的作用主要是给组件之间的保存参数和传递参数用的。
        // 这里获取不到ctx1数据 第二个参数为流程入参
        LiteflowResponse response = flowExecutor.execute2Resp("ctx1", "这是流程入参", CustomContext.class);

        // 多参数
        //LiteflowResponse response1 = flowExecutor.execute2Resp("ctx1", null, CustomContext.class, CustomContext2.class);
    }

    // future返回值
    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        //参数为流程ID，无初始流程入参，上下文类型为默认的DefaultContext
//        public LiteflowResponse execute2Resp(String chainId)
//        //第一个参数为流程ID，第二个参数为流程入参。上下文类型为默认的DefaultContext
//        public LiteflowResponse execute2Resp(String chainId, Object param);
//        //第一个参数为流程ID，第二个参数为流程入参，后面可以传入多个上下文class
//        public LiteflowResponse execute2Resp(String chainId, Object param, Class<?>... contextBeanClazzArray)
//        //第一个参数为流程ID，第二个参数为流程入参，后面可以传入多个上下文的Bean
//        public LiteflowResponse execute2Resp(String chainId, Object param, Object... contextBeanArray)

        // Future
        Future<LiteflowResponse> responseFuture= flowExecutor.execute2Future("future1", "流程入参", CustomContext.class);
        LiteflowResponse response=responseFuture.get();
        System.out.println(response.isSuccess());
    }

    // response对象详解
    @Test
    public void testResponse(){
        LiteflowResponse response = flowExecutor.execute2Resp("future1", "流程入参", CustomContext.class);
        // 是否执行成功
        boolean isSuccess = response.isSuccess();
        System.out.println(isSuccess);

        // 执行步骤详情
        Map<String, CmpStep> stepMap = response.getExecuteSteps();
        stepMap.forEach((s, cmpStep) -> System.out.println(cmpStep));
        // 执行步骤队列
        Queue<CmpStep> stepQueue = response.getExecuteStepQueue();

        //上下文数据  多上下文也一样
        CustomContext context = response.getContextBean(CustomContext.class);
        System.out.println(context.getData("key2"));

        // 获取步骤字符串 组件ID[组件别名]<耗时毫秒>
        String stepStr = response.getExecuteStepStrWithTime();
        System.out.println(stepStr);

    }



}
