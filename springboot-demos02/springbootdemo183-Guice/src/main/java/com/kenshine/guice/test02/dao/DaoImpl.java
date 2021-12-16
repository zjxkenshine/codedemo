package com.kenshine.guice.test02.dao;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/16 16:37
 * @description：Dao实现
 * @modified By：
 * @version: $
 */
public class DaoImpl implements Dao{

    @Override
    public void testGuice() {
        System.out.println("注入成功");
    }

}
