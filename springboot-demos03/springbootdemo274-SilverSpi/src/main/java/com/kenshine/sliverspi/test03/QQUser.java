package com.kenshine.sliverspi.test03;

public class QQUser implements IUser {

    @Override
    public void welcome(UserDO userDO) {
        System.out.println("qq 欢迎你! " + userDO);
    }
}