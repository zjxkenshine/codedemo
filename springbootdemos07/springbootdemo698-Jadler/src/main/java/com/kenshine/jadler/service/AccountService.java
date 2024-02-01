package com.kenshine.jadler.service;

import com.kenshine.jadler.Account;

/**
 * @author kenshine
 */
public interface AccountService {

   Account getAccount(Integer id);

    void deleteAccount(int i);
}