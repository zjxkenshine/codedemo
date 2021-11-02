package com.kenshine.kapatcha.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 0:15
 * @description：验证码接口
 * @modified By：
 * @version: $
 */
public interface KaptchaService {

    void captchaCode(HttpServletRequest request, HttpServletResponse response) throws IOException;


    String checkCode(String checkCode, String uuid) throws IOException;
}
