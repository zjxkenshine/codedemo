package com.kenshine.sliverspi.test03;

public class WeixinUser implements IUser {

    @Override
    public void welcome(UserDO userDO) {
        System.out.println("weixin 欢迎你! " + userDO);
    }
}