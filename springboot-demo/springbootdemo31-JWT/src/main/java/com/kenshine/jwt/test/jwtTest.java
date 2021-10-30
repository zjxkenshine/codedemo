package com.kenshine.jwt.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 8:53
 * @description：测试
 * @modified By：
 * @version: $
 */
public class jwtTest {

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 90);
        //生成令牌
        String token = JWT.create()
                .withClaim("username", "张三")//设置自定义用户名
                .withExpiresAt(instance.getTime())//设置过期时间
                .sign(Algorithm.HMAC256("token!Q2W#E$RW"));//设置签名 保密 复杂
        //输出令牌
        System.out.println(token);


        /**
         * 解析
         */
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("token!Q2W#E$RW")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        System.out.println("用户名: " + decodedJWT.getClaim("username").asString()); // 存的是时候是什么类型，取得时候就是什么类型，否则取不到值。
        System.out.println("过期时间: "+decodedJWT.getExpiresAt());
    }
}
