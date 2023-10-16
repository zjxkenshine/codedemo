package com.kenshine.jbcrypt;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 22:15
 * @description： 测试
 * @modified By：
 * @version: $
 */
public class Test {
    public static void main(String[] args) {
        //加密 获取密码
        String hashed = BCrypt.hashpw("123456", BCrypt.gensalt());
        System.out.println(hashed);

        //解密
        if (BCrypt.checkpw("111111", hashed)){
            System.out.println("密码正确");
        } else {
            System.out.println("密码错误");
        }
    }
}
