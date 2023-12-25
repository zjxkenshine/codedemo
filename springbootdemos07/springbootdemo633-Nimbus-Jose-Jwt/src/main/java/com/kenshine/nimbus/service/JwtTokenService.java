package com.kenshine.nimbus.service;

import com.kenshine.nimbus.domain.PayloadDto;
import com.kenshine.nimbus.exception.JwtExpiredException;
import com.kenshine.nimbus.exception.JwtInvalidException;
import com.nimbusds.jose.JOSEException;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * @author by kenshine
 * @Classname JwtTokenService
 * @Description jwt接口
 * @Date 2023-12-25 13:26
 * @modified By：
 * @version: 1.0$
 */
public interface JwtTokenService {
    /**
     * 生成jwt
     */
    String generateTokenByHMAC(String payloadStr, String secret) throws JOSEException;

    /**
     * 验证jwt
     */
    PayloadDto verifyTokenByHMAC(String token, String secret) throws ParseException, JOSEException, JwtInvalidException, JwtExpiredException;

    /**
     * 默认 PayloadDto
     */
    PayloadDto getDefaultPayloadDto();
}
