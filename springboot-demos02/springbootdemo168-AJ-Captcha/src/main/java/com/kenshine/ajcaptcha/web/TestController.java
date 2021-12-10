package com.kenshine.ajcaptcha.web;

import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/10 22:38
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {
    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/blockPuzzle")
    public ResponseModel blockPuzzle() {
        CaptchaVO vo = new CaptchaVO();
        vo.setCaptchaType("blockPuzzle");
        return captchaService.get(vo);
    }
}
