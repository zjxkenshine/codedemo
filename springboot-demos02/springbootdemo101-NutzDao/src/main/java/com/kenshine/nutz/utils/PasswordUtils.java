package com.kenshine.nutz.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Author kenshine
 */
public class PasswordUtils {

    private PasswordUtils(){}

    /**
     *
     * @param salt 盐
     * @param password 明文密码
     * @return String 加密后的数据
     */
    public static String getPassword(String salt,String password){
        //加密类型
        String hashAlgorithmName = "md5";
        //迭代次数
        int iteration = 2;
        return new SimpleHash(hashAlgorithmName,password,salt,iteration).toHex();
    }

}
