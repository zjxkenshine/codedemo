package com.kenshine.satoken.demo2.web;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 17:56
 * @description：测试
 * @modified By：
 * @version: $
 */
@Slf4j
public class TestController {

    /**
     * Sa-Token配置
     * @return
     */
    @GetMapping("getSaTokenConfig")
    public SaTokenConfig getSaTokenConfig() {
        log.info("Sa-Token配置：{}", SaManager.getConfig());
        return SaManager.getConfig();
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @GetMapping("doLogin")
    public String doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if ("kenshine".equals(username) && "123456".equals(password)) {
            StpUtil.logout();
            StpUtil.login(10001);
            return "登录成功" + StpUtil.getLoginId();
        }
        StpUtil.logout();
        return "登录失败";
    }

    /**
     * 查询登录状态
     * @return
     */
    @GetMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping("logout")
    public String logout(String loginId) {
        StpUtil.kickout(loginId);
        return "SUCCESS";
    }

    /**
     * 检查是否登录
     * @return
     */
    @GetMapping("checkLogin")
    public String checkLogin() {
        try {
            StpUtil.checkLogin();
        } catch (Exception e) {
            log.info("登录认证失效：{}", e.getMessage());
            return "FAIL:" + e.getMessage();
        }
        log.info("登录了...");
        return "SUCCESS";
    }

    /**
     * 查询Token信息
     * @return
     */
    @GetMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    /**
     * 获取账号id为10001的token令牌值
     * @return
     */
    @GetMapping("getTokenValueByLoginId")
    public String getTokenValueByLoginId() {
        return StpUtil.getTokenValueByLoginId(10001);
    }

}
