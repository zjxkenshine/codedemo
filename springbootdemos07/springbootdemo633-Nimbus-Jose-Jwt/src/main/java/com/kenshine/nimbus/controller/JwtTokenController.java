package com.kenshine.nimbus.controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import com.kenshine.nimbus.domain.PayloadDto;
import com.kenshine.nimbus.exception.JwtExpiredException;
import com.kenshine.nimbus.exception.JwtInvalidException;
import com.kenshine.nimbus.result.CommonResult;
import com.kenshine.nimbus.service.JwtTokenService;
import com.nimbusds.jose.JOSEException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * @author by kenshine
 * @Classname JwtTokenController
 * @Description JWT令牌管理
 * @Date 2023-12-25 13:36
 * @modified By：
 * @version: 1.0$
 */
@Api(tags = "JwtTokenController", description = "JWT令牌管理")
@Controller
@RequestMapping("/token")
public class JwtTokenController {
    @Resource
    private JwtTokenService jwtTokenService;

    @ApiOperation("使用对称加密（HMAC）算法生成token")
    @RequestMapping(value = "/hmac/generate", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult generateTokenByHMAC() {
        try {
            PayloadDto payloadDto = jwtTokenService.getDefaultPayloadDto();
            String token = jwtTokenService.generateTokenByHMAC(JSONUtil.toJsonStr(payloadDto), SecureUtil.md5("test"));
            return CommonResult.success(token);
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }

    @ApiOperation("使用对称加密（HMAC）算法验证token")
    @RequestMapping(value = "/hmac/verify", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult verifyTokenByHMAC(String token) {
        try {
            PayloadDto payloadDto  = jwtTokenService.verifyTokenByHMAC(token, SecureUtil.md5("test"));
            return CommonResult.success(payloadDto);
        } catch (ParseException | JOSEException | JwtExpiredException | JwtInvalidException e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }
}
