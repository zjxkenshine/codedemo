package com.kenshine.jmockit.service;

import javax.annotation.Resource;

public class OrderService {
    // 邮件服务类，用于向某用户发邮件。
    @Resource
    MailService mailService;
    // 用户身份校验类，用于校验某个用户是不是合法用户
    UserCheckService userCheckService;

    // 构造函数
    public OrderService(UserCheckService userCheckService) {
        this.userCheckService = userCheckService;
    }

    public boolean submitOrder(long buyerId, long itemId) {
        // 先校验用户身份
        if (!userCheckService.check(buyerId)) {
            // 用户身份不合法
            return false;
        }
        if (!this.mailService.sendMail(buyerId, "下单成功")) {
            // 邮件发送成功
            return false;
        }
        return true;
    }
}