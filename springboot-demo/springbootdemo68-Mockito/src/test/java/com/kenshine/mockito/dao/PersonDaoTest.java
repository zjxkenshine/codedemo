package com.kenshine.mockito.dao;

import com.kenshine.mockito.domain.Person;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 13:55
 * @description：
 * @modified By：
 * @version: $
 */
class PersonDaoTest {
    private PersonDao mockDao;


    @BeforeEach
    public void setUp() throws Exception {
        //模拟PersonDao对象
        mockDao = mock(PersonDao.class);
    }


    @Test
    void getPerson() throws InterruptedException {
        Person result = mockDao.getPerson(1);
        //此时调用为空
        System.out.println(result);

        // 模拟获取第一个元素时，返回字符串first。  给特定的方法调用返回固定值在官方说法中称为stub。
        when(mockDao.getPerson(1)).thenReturn(new Person().setId(1).setName("dogdog"));
        Person result1 = mockDao.getPerson(1);
        //返回stub
        System.out.println(result1);

        //模拟方法调用抛出异常
//        when(mockDao.getPerson(1)).thenThrow(new RuntimeException());
//        // 此时将会抛出RuntimeException
//        System.out.println(mockDao.getPerson(1));

        //无返回值方法模拟抛出异常
//        doThrow(new RuntimeException("clear exception")).when(mockDao).clear();
//        mockDao.clear();


        /**
         * 模拟调用方法时的参数匹配
         */
        // anyInt()匹配任何int参数，这意味着参数为任意值，其返回值均是number
        when(mockDao.getPerson(anyInt())).thenReturn(new Person(1,"number"));
        System.out.println(mockDao.getPerson(2));





    }


    @Test
    void update() {

    }
}