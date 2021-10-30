package com.kenshine.jta.service.impl;

import com.kenshine.jta.dbAop.DataSource;
import com.kenshine.jta.dbAop.DataSourceNames;
import com.kenshine.jta.domain.User;
import com.kenshine.jta.mapper.UserMapper;
import com.kenshine.jta.service.TestJtaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 10:29
 * @description：测试JTA事务
 * @modified By：
 * @version: $
 */
@Service
public class TestJtaServiceImpl implements TestJtaservice {
    @Autowired
    UserMapper userMapper;


    public void testInsertUser(User user){
        int insertNum = userMapper.insert(user);
        System.out.println("插入成功,条数："+insertNum);
    }

    @DataSource(DataSourceNames.TWO)
    public void testInsertUser2(User user){
        int insertNum = userMapper.insert(user);
        System.out.println("插入成功,条数："+insertNum);
    }

}
