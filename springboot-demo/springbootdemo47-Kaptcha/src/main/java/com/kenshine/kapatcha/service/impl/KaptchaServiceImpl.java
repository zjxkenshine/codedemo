package com.kenshine.kapatcha.service.impl;

import com.google.code.kaptcha.Producer;
import com.kenshine.kapatcha.service.KaptchaService;
import com.kenshine.kapatcha.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 0:16
 * @description：验证码业务实现
 * @modified By：
 * @version: $
 */
@Service
@Slf4j
public class KaptchaServiceImpl implements KaptchaService {

    @Resource
    private Producer captchaProducer;


    /**
     * @Description 生成验证码
     */
    @Override
    public void captchaCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        log.info("生成uuid:{}", uuid);

        //为验证码创建一个文本
        String codeText = captchaProducer.createText();
        //将验证码存到reids
        StringBuilder key = new StringBuilder();
        key.append("captcha:").append(uuid);
        RedisUtil.set(key.toString(), codeText, 120L);

        //禁止缓存
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        //设置响应格式为png图片
        response.setContentType("image/png");
        response.setHeader("uuid", uuid);

        // 用创建的验证码文本生成图片
        BufferedImage bi = captchaProducer.createImage(codeText);

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            //写出图片
            ImageIO.write(bi, "png", out);
            out.flush();
        } catch (IOException e) {
            log.info("生成图片IOException:{}", e.getMessage());
            //这里换成自定义异常
            throw new IOException("验证码错误");
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                log.info("关闭IO流错误,IOException:{}", e.getMessage());
                throw new IOException("验证码错误");
            }
        }
    }


    /**
     * @Description  图片验证码校验
     */
    @Override
    public String checkCode(String checkCode, String uuid) throws IOException {
        StringBuilder key = new StringBuilder();
        key.append("captcha:").append(uuid);
        String redisCode = String.valueOf(RedisUtil.get(key.toString()));
        if (redisCode == null) {
            throw new IOException("连接超时");
        }
        if (!redisCode.equals(checkCode)) {
            throw new IOException("验证码错误");
        }
        RedisUtil.del(key.toString());
        return "验证成功";
    }



}
