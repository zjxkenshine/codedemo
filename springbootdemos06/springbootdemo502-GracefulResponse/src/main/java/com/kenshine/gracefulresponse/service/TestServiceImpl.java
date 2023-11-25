package com.kenshine.gracefulresponse.service;

import com.kenshine.gracefulresponse.exception.NotFoundException;
import com.kenshine.gracefulresponse.model.User;
import org.springframework.stereotype.Service;

/**
 * @author by kenshine
 * @Classname TestServiceImpl
 * @Description 测试Service实现
 * @Date 2023-11-25 8:28
 * @modified By：
 * @version: 1.0$
 */
@Service
public class TestServiceImpl implements TestService{

    @Override
    public User query1(String id) {
        if(id==null){
            //自定义异常
            throw new NotFoundException();
        }
        return new User().setId(2).setName("qin");
    }
}
