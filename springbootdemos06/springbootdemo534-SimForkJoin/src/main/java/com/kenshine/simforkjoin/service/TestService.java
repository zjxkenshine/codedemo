package com.kenshine.simforkjoin.service;

import cn.langpy.simforkjoin.annotation.ForkJoin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author by kenshine
 * @Classname TestService
 * @Description 测试Service
 * @Date 2023-12-04 14:52
 * @modified By：
 * @version: 1.0$
 */
@Service
public class TestService {

    /**
     * ForkJoin 注解表示fork join任务
     */
    @ForkJoin
    public <T> List<T> test(List<T> list){
        for(int i=0;i<list.size();i++){
            T t = list.get(i);
            /*其他操作*/
            System.out.println(Thread.currentThread().getName()+t);
        }
        return list;
    }
}
