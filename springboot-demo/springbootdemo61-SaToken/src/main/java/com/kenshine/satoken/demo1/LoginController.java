package com.kenshine.satoken.demo1;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 15:48
 * @description：登录测试
 * @modified By：
 * @version: $
 *
 */
@RestController
@RequestMapping("/acc/")
public class LoginController {
    /**
     * 登录
     *  http://localhost:8080/acc/doLogin?name=kenshine&pwd=123456
     * @param name
     * @param pwd
     */
    @RequestMapping("doLogin")
    public SaResult doLogin(String name, String pwd) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("kenshine".equals(name) && "123456".equals(pwd)) {
            StpUtil.login(10001);
            return SaResult.data(StpUtil.getTokenInfo());
        }
        return SaResult.error("登录失败");
    }

    /**
     * 查询登录状态
     *  http://localhost:8080/acc/isLogin
     */
    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }
    
    /**
     * 查询token
     * http://localhost:8080/acc/tokenInfo
     */
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    /**
     * 注销
     *  http://localhost:8080/acc/logout
     */
    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    /**
     * 检验当前会话是否已经登录, 如果未登录，则抛出异常：`NotLoginException`
     * checkLogin
     * http://localhost:8080/acc/checkLogin
     */
    @RequestMapping("checkLogin")
    public SaResult checkLogin() {
        StpUtil.checkLogin();
        return SaResult.ok();
    }


    /**
     * 会话查询测试
     * checkLogin
     * http://localhost:8080/acc/testLoginId
     */
    @RequestMapping("testLoginId")
    public SaResult testLoginId(){

        // 获取当前会话账号id, 如果未登录，则抛出异常：`NotLoginException`
        Long id = (Long) StpUtil.getLoginId();

        // 类似查询API还有：
        String loginIdAsString = StpUtil.getLoginIdAsString();// 获取当前会话账号id, 并转化为`String`类型
        int loginIdAsInt = StpUtil.getLoginIdAsInt();// 获取当前会话账号id, 并转化为`int`类型
        long loginIdAsLong = StpUtil.getLoginIdAsLong();// 获取当前会话账号id, 并转化为`long`类型


        // ---------- 指定未登录情形下返回的默认值 ----------

        // 获取当前会话账号id, 如果未登录，则返回null
        Object loginIdDefaultNull = StpUtil.getLoginIdDefaultNull();

        // 获取当前会话账号id, 如果未登录，则返回默认值 （`defaultValue`可以为任意类型）
        String aDefault = StpUtil.getLoginId("default");

        return SaResult.ok();
    }

    /**
     * 其他api测试
     * checkLogin
     * http://localhost:8080/acc/testOther
     */
    @RequestMapping("testOther")
    public SaResult testOther(){
        // 获取指定token对应的账号id，如果未登录，则返回 null
        StpUtil.getLoginIdByToken("e7a0e181-c18b-4529-a5d7-4b1360dbd74e");

        // 获取当前`StpLogic`的token名称
        String tokenName = StpUtil.getTokenName();

        // 获取当前会话的token值
        String token = StpUtil.getTokenValue();

        // 获取当前会话的token信息参数
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

        return SaResult.ok();
    }



}
