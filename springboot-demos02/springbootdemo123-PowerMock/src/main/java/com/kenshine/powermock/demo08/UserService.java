package com.kenshine.powermock.demo08;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 13:38
 * @description：
 * @modified By：
 * @version: $
 */
public class UserService {

    public void foo(String arg){
        log(arg);
    }

    //静态方法
    private void log(String args){
        System.out.println("I am console log: "+args);
    }


    public boolean exist(String username){
        return checkExist(username);
    }

    private boolean checkExist(String username){
        throw new UnsupportedOperationException();
    }


}
