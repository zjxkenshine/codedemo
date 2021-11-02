package com.kenshine.kapatcha.web;

import com.kenshine.kapatcha.service.KaptchaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 0:07
 * @description：验证码接口
 * @modified By：
 * @version: $
 *
 * 验证码控制器
 */
@RestController
@Slf4j
@ConditionalOnProperty(havingValue = "true", value = "kaptcha.enabled", matchIfMissing = false)
public class KaptchaController {

    @Resource
    private KaptchaService kapatchaService;

    /**
     * @Description 生成验证码
     * @author lst
     * @date 2020-11-10 11:05
     * @param request
     * @param response
     * @return com.example.sbs.result.BaseResponse<java.lang.String>
     */
    @RequestMapping(value = "/captcha", produces = MediaType.IMAGE_PNG_VALUE, method = RequestMethod.GET)
    public void captchaCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        kapatchaService.captchaCode(request, response);
    }

    /**
     * @Description 图片验证码校验
     * @author lst
     * @date 2020-11-10 11:07
     * @return com.example.sbs.result.BaseResponse<java.lang.String>
     */
    @GetMapping(value = "/captcha/verify", produces = "application/json; charset=utf-8")
    public String checkCode(@RequestParam(value = "checkCode",required = true) String checkCode,
                                          @RequestParam(value = "uuid",required = true) String uuid) throws IOException {

        return  kapatchaService.checkCode(checkCode, uuid);
    }




}
