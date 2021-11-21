package com.kenshine.trans.web;

import com.kenshine.trans.entity.Account;
import com.kenshine.trans.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/21 21:37
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class AccountController {
    @SuppressWarnings("all")
    @Autowired
    AccountService accountService;

    @GetMapping("/")
    public Account getAccount() {
        //查询账户
        return accountService.getAccount();
    }

    @GetMapping("/add")
    public Object addMoney() {
        try {
            accountService.addMoney();
        } catch (Exception e) {
            return "发生异常了：" + accountService.getAccount();
        }
        return getAccount();
    }
}
