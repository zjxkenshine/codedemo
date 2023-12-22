package com.kenshine.jose4j;

import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.lang.JoseException;

import static com.kenshine.jose4j.JoseUtil.*;

/**
 * @author by kenshine
 * @Classname JoseTest
 * @Description 使用测试
 * @Date 2023-12-22 15:14
 * @modified By：
 * @version: 1.0$
 */
public class JoseTest {
    /**
     * jwt生成与验证
     */
    public static void main(String[] args) throws JoseException, MalformedClaimException {
        RsaJsonWebKey rsaJsonWebKey = genRsaJsonWebKey();
        String jwt = producing(rsaJsonWebKey);
        JwtClaims jwtClaims = consuming(jwt, rsaJsonWebKey.getKey());
        System.out.println(jwtClaims);
    }
}
