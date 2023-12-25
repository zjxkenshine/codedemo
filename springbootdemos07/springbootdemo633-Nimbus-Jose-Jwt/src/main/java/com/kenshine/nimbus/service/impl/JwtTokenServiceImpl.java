package com.kenshine.nimbus.service.impl;

import cn.hutool.json.JSONUtil;
import com.kenshine.nimbus.domain.PayloadDto;
import com.kenshine.nimbus.exception.JwtExpiredException;
import com.kenshine.nimbus.exception.JwtInvalidException;
import com.kenshine.nimbus.service.JwtTokenService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * @author by kenshine
 * @Classname JwtTokenServiceImpl
 * @Description 业务实现
 * @Date 2023-12-25 13:27
 * @modified By：
 * @version: 1.0$
 */
@Service
public class JwtTokenServiceImpl implements JwtTokenService {
    /**
     * 生成jwt
     * @param payloadStr 负载信息
     * @param secret 秘钥
     */
    @Override
    public String generateTokenByHMAC(String payloadStr, String secret) throws JOSEException {
        //创建JWS头，设置签名算法和类型
        JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.HS256).
                type(JOSEObjectType.JWT)
                .build();
        //将负载信息封装到Payload中
        Payload payload = new Payload(payloadStr);
        //创建JWS对象
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        //创建HMAC签名器
        JWSSigner jwsSigner = new MACSigner(secret);
        //签名
        jwsObject.sign(jwsSigner);
        return jwsObject.serialize();
    }

    /**
     * 验证JWT
     * @param token token
     * @param secret 秘钥
     */
    @Override
    public PayloadDto verifyTokenByHMAC(String token, String secret) throws ParseException, JOSEException, JwtInvalidException, JwtExpiredException {
        //从token中解析JWS对象
        JWSObject jwsObject = JWSObject.parse(token);
        //创建HMAC验证器
        JWSVerifier jwsVerifier = new MACVerifier(secret);
        if (!jwsObject.verify(jwsVerifier)) {
            throw new JwtInvalidException("token签名不合法！");
        }
        String payload = jwsObject.getPayload().toString();
        PayloadDto payloadDto = JSONUtil.toBean(payload, PayloadDto.class);
        if (payloadDto.getExp() < System.currentTimeMillis()) {
            throw new JwtExpiredException("token已过期！");
        }
        return payloadDto;
    }

    /**
     * 默认载荷
     * @return
     */
    @Override
    public PayloadDto getDefaultPayloadDto() {
        return PayloadDto.builder().build();
    }
}
