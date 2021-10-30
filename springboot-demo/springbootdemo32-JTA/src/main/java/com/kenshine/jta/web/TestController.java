package com.kenshine.jta.web;

import com.kenshine.jta.domain.User;
import com.kenshine.jta.service.TestJtaservice;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 10:36
 * @description：测试接口
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {
    @Resource
    private TestJtaservice testJtaservice;

    /**
     * 插入到数据库1
     * @return
     */
    @GetMapping("/testInsert1")
    @Transactional
    public String testInsertOne(){
        User user = new User();
        user.setUsername("kenshine");
        user.setAge(25);
        try{
            testJtaservice.testInsertUser(user);
            //错误回滚
            //int num=100/0;
        }catch (Exception e){
            System.out.println("触发事务回滚");
            System.out.println(e.getMessage());
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "ok";
    }

    /**
     * 插入到数据库2
     * @return
     */
    @GetMapping("/testInsert2")
    @Transactional
    public String testInsertTwo(){
        User user = new User();
        user.setUsername("qin");
        user.setAge(25);
        try{
            testJtaservice.testInsertUser2(user);
            //错误回滚
            //int num=100/0;
        }catch (Exception e){
            System.out.println("触发事务回滚");
            System.out.println(e.getMessage());
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "ok";
    }


    /**
     * 同时插入两条数据
     */
    @GetMapping("/testInsert")
    @Transactional
    public String testInsert(){
        User user = new User();
        user.setUsername("test");
        user.setAge(25);
        try{
            testJtaservice.testInsertUser(user);
            testJtaservice.testInsertUser2(user);
            //错误回滚
            int num=100/0;
        }catch (Exception e){
            System.out.println("触发事务回滚");
            System.out.println(e.getMessage());
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "ok";
    }






}
