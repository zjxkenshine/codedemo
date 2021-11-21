package com.kenshine.trans.service;

import com.kenshine.trans.entity.Account;
import com.kenshine.trans.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/21 21:37
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class AccountService {
    @SuppressWarnings("all")
    @Autowired
    AccountMapper accountMapper;

    public Account getAccount() {
        return accountMapper.getAccount();
    }

    /**
     * 配置全局事务后可以不用使用@Transactional注解
     * @throws Exception
     */
    //@Transactional(rollbackFor = SQLException.class)
    public void addMoney() throws Exception {
        //先增加余额
        accountMapper.addMoney();
        //然后遇到故障
        throw new Exception("发生异常了..");
    }
}
