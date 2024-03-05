package com.kenshine.easyretry.controller;

import com.kenshine.easyretry.model.OrderVo;
import com.kenshine.easyretry.service.ExecutorMethodService;
import com.kenshine.easyretry.service.LocalRetryService;
import com.kenshine.easyretry.service.RemoteRetryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试接口
 * @Date 2024-03-05 9:22
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class RetryController {
    @Resource
    private LocalRetryService localRetryService;
    @Resource
    private RemoteRetryService remoteRetryService;
    @Resource
    private ExecutorMethodService executorMethodService;

    /**
     * 重试测试
     * localhost:8080/test01
     */
    @GetMapping("/test01")
    public void test01(){
        localRetryService.localRetry();
    }

    /**
     * 重试4次
     * localhost:8080/test02
     */
    @GetMapping("/test02")
    public void test02(){
        localRetryService.localRetryWithBasicParams();
    }

    /**
     * 非指定异常不重试
     * localhost:8080/test03
     */
    @GetMapping("/test03")
    public void test03(){
        localRetryService.localRetryExcludeException();
    }

    /**
     * 指定异常重试
     * localhost:8080/test04
     */
    @GetMapping("/test04")
    public void test04(){
        localRetryService.localRetryIncludeException();
    }

    /**
     * 远程上报重试
     * localhost:8080/test05
     */
    @GetMapping("/test05")
    public void test05(){
        remoteRetryService.remoteRetry();
    }


    /**
     * 自定义幂等id生成
     */
    @PostMapping("/test06")
    public void test06(@RequestBody OrderVo orderVo){
        remoteRetryService.remoteRetryWithIdempotentId(orderVo);
    }

    /**
     * 自定义回调方法
     */
    @PostMapping("/test07")
    public void test07(@RequestBody OrderVo orderVo){
        remoteRetryService.remoteRetryWithCompleteCallback(orderVo);
    }

    /**
     * 自定义重试方法
     */
    @PostMapping("/test08")
    public void test08(@RequestBody OrderVo orderVo){
        remoteRetryService.remoteRetryWithRetryMethod(orderVo);
    }

    /**
     * BizNo 标记业务号
     */
    @PostMapping("/test09")
    public void test09(@RequestBody OrderVo orderVo){
        remoteRetryService.remoteRetryWithBizNo(orderVo);
    }

    /**
     * 手动上报
     */
    @GetMapping("/test10")
    public void test10(){
        executorMethodService.myExecutorMethod();
    }


}
