package com.kenshine.logrecord.controller;

import cn.monitor4all.logRecord.annotation.OperationLog;
import cn.monitor4all.logRecord.context.LogRecordContext;
import com.kenshine.logrecord.model.Order;
import com.kenshine.logrecord.model.TestUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试controller
 * @Date 2024-05-27 9:57
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    /**
     * 固定输出
     * localhost:8080/test01
     */
    @OperationLog(bizType = "'followerChange'", bizId = "'20211102001'", msg = "'用户 张三 修改了订单的跟进人：从 李四 修改到 王五'")
    @GetMapping("/test01")
   public String test01(){
        return "test01";
   }

    /**
     * 手动传递日志上下文
     * spel 传递方法值
     * localhost:8080/test02?orderId=111111&userId=1&newFollower=666
     */
    @OperationLog(bizType = "'followerChange'", bizId = "#orderId", msg = "'用户' + #userName + '修改了订单的跟进人：从' + #oldFollower + '修改到' + #newFollower")
   @GetMapping("/test02")
   public String test02(Long orderId,Long userId,Long newFollower){
        // 手动传递日志上下文：用户信息 地址旧值
        LogRecordContext.putVariable("userName", queryUserName(userId));
        LogRecordContext.putVariable("oldFollower", queryOldFollower(orderId));
        return "test02";
   }


    /**
     * 自定义函数 CustomFunctionStatic 必须是public静态方法
     * localhost:8080/test04?orderId=10086&userId=3&newFollower=888
     */
    @OperationLog(bizType = "'followerChange'", bizId = "#orderId", msg = "'用户' + #CustomFunctionStatic_queryUserName1(#userId) + '修改了订单的跟进人：从' + #CustomFunctionStatic_queryOldFollower1(#orderId) + '修改到' + #newFollower")
    @GetMapping("/test04")
    public String test04(Long orderId,Long userId,Long newFollower){
        return "test04";
    }


    /**
     * 条件输出
     * localhost:8080/test05?id=1
     */
    @OperationLog(bizId = "'1'", bizType = "'testCondition1'", condition = "#id!= null")
    @OperationLog(bizId = "'2'", bizType = "'testCondition2'", condition = "#id == 1")
    @OperationLog(bizId = "'3'", bizType = "'testCondition3'", condition = "#id == 2")
    @GetMapping("/test05")
    public String test05(Integer id){
        return "test05";
    }

    /**
     * 实体类diff
     * localhost:8080/test06
     */
    @OperationLog(bizId = "'1'", bizType = "'testObjectDiff'", msg = "#_DIFF(#oldObject, #testUser)", extra = "#_DIFF(#oldObject, #testUser)")
    @GetMapping("/test06")
    public String testObjectDiff() {
        LogRecordContext.putVariable("oldObject", new TestUser(1, "张三"));
        LogRecordContext.putVariable("testUser", new TestUser(2, "kenshine"));
        return "test06";
    }


    public static Long queryOldFollower(Long orderId) {
        return 12345L;
    }

    public static String queryUserName(Long userId) {
        return "kenshine"+userId;
    }


}
