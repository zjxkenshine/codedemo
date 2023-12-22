package com.kenshine.jose4j;

import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodes;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

import java.security.Key;
import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname JoseUtil
 * @Description T秘钥工具ODO
 * @Date 2023-12-22 15:11
 * @modified By：
 * @version: 1.0$
 */
public class JoseUtil {

    /**
     * 创建密钥对
     */
    public static RsaJsonWebKey genRsaJsonWebKey() throws JoseException {
        // 生成一个RSA密钥对，该密钥对将用于JWT的签名和验证，包装在JWK中
        RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
        // 给JWK一个密钥ID
        rsaJsonWebKey.setKeyId("k1");
        return rsaJsonWebKey;
    }

    /**
     * 生成jwt令牌
     */
    public static String producing(RsaJsonWebKey rsaJsonWebKey) throws JoseException {
        // 创建声明，也就是JWT的内容
        JwtClaims claims = new JwtClaims();
        // 创建令牌并签名的人
        claims.setIssuer("kenshine");
        // 令牌将发送给谁
        claims.setAudience("Hong");
        // 令牌到期时间（10分钟后）
        claims.setExpirationTimeMinutesInTheFuture(10);
        // 令牌的唯一标识符
        claims.setGeneratedJwtId();
        // 颁发/创建令牌的时间（现在）
        claims.setIssuedAtToNow();
        // 令牌尚未生效的时间（2分钟前）
        claims.setNotBeforeMinutesInThePast(2);
        // 主题/主体是关于谁的令牌
        claims.setSubject("subject");
        // 可以添加有关主题的其他声明/属性
        claims.setClaim("email", "mail@example.com");
        List<String> groups = Arrays.asList("group-one", "other-group", "group-three");
        // 多值声明也可以工作，最终将成为一个JSON数组
        claims.setStringListClaim("groups", groups);
        // JWT是JWS和/或JWE，其中JSON声明为有效负载。
        // 在本例中，它是一个JWS，因此我们创建了一个JsonWebSignature对象。
        JsonWebSignature jws = new JsonWebSignature();
        // JWS的有效负载是JWT声明的JSON内容
        jws.setPayload(claims.toJson());
        // JWT使用私钥签名
        jws.setKey(rsaJsonWebKey.getPrivateKey());
        // 在这个示例中，我们只有一个密钥，但使用密钥ID有助于促进顺利的密钥滚动过程
        jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());
        // 在JWT/JWS上设置完整性保护声明的签名算法
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        return jws.getCompactSerialization();
    }

    /**
     * 验证jwt
     */
    public static JwtClaims consuming(String jwt, Key key) throws MalformedClaimException {
        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                // JWT必须有到期时间
                .setRequireExpirationTime()
                // 在验证基于时间的声明以解释时钟偏差时允许一些余地
                .setAllowedClockSkewInSeconds(30)
                // JWT必须有主题声明
                .setRequireSubject()
                // JWT需要由谁签发
                .setExpectedIssuer("Issuer")
                // JWT的目标用户
                .setExpectedAudience("Audience")
                // 使用公钥验证签名
                .setVerificationKey(key)
                // 仅允许给定上下文中的预期签名算法
                .setJwsAlgorithmConstraints(AlgorithmConstraints.ConstraintType.PERMIT, AlgorithmIdentifiers.RSA_USING_SHA256)
                .build();
        try {
            // 验证JWT并将其处理至索赔
            return jwtConsumer.processToClaims(jwt);
        } catch (InvalidJwtException e) {
            // 是否过期
            if (e.hasExpired()) {
                System.out.println("JWT expired at " + e.getJwtContext().getJwtClaims().getExpirationTime());
            }
            if (e.hasErrorCode(ErrorCodes.AUDIENCE_INVALID)) {
                System.out.println("JWT had wrong audience: " + e.getJwtContext().getJwtClaims().getAudience());
            }
        }
        return null;
    }


}
