package com.kenshine.jadler.service;

import com.kenshine.jadler.Account;

/**
 * @author by kenshine
 * @Classname AccountServiceRestImpl
 * @Description 测试服务实现
 * @Date 2024-02-01 8:51
 * @modified By：
 * @version: 1.0$
 */
public class AccountServiceRestImpl implements AccountService{
    public AccountServiceRestImpl(String http, String localhost, int port){
    }

    @Override
    public Account getAccount(Integer id) {
        return new Account(2);
    }

    @Override
    public void deleteAccount(int i) {
    }
}
