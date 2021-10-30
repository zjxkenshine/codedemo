package com.kenshine.jta.config.transaction;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 10:21
 * @description：XAT事务管理器
 * @modified By：
 * @version: $
 */
@Configuration
@EnableTransactionManagement
public class XATransactionManagerConfig {

    @Bean
    public UserTransaction userTransaction() throws Throwable {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(10000);
        return userTransactionImp;
    }

    @Bean
    public TransactionManager atomikosTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(true);
        return userTransactionManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager(UserTransaction userTransaction,
                                                         TransactionManager transactionManager) {
        return new JtaTransactionManager(userTransaction, transactionManager);
    }


}
