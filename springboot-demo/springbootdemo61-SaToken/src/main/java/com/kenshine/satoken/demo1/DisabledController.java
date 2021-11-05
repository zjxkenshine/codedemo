package com.kenshine.satoken.demo1;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 17:27
 * @description：踢人下线/强制注销
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping
public class DisabledController {

    /**
     * 强制注销
     */
    public void test01(){
        StpUtil.logout(10001);                    // 强制指定账号注销下线
        StpUtil.logout(10001, "PC");              // 强制指定账号指定端注销下线
        StpUtil.logoutByTokenValue("token");      // 强制指定 Token 注销下线
    }

    /**
     * 踢人下线
     */
    public void test02(){
        StpUtil.kickout(10001);                    // 将指定账号踢下线
        StpUtil.kickout(10001, "PC");              // 将指定账号指定端踢下线
        StpUtil.kickoutByTokenValue("token");      // 将指定 Token 踢下线
    }

    /**
     * 账号封禁
     */
    public void test03() {
        // 封禁指定账号
        // 参数一：账号id
        // 参数二：封禁时长，单位：秒  (86400秒=1天，此值为-1时，代表永久封禁)
        StpUtil.disable(10001, 86400);

        // 获取指定账号是否已被封禁 (true=已被封禁, false=未被封禁)
        StpUtil.isDisable(10001);

        // 获取指定账号剩余封禁时间，单位：秒
        StpUtil.getDisableTime(10001);

        // 解除封禁
        StpUtil.untieDisable(10001);

    }
}
