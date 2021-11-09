package com.kenshine.easycaptche.web;

import com.kenshine.easycaptche.response.JsonResult;
import com.kenshine.easycaptche.util.RedisUtil;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 17:43
 * @description：验证码Controller
 * @modified By：
 * @version: $
 */
@Controller
public class CaptchaController {
    

    @ResponseBody
    @RequestMapping("/captcha")
    public JsonResult captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = UUID.randomUUID().toString();
        // 存入redis并设置过期时间为5分钟
        RedisUtil.set(key, verCode, 60*5);
        // 将key和base64返回给前端
        return JsonResult.ok().put("key", key).put("image", specCaptcha.toBase64());
    }

    @ResponseBody
    @PostMapping("/login")
    public JsonResult login(String username,String password,String verCode,String verKey){
        // 获取redis中的验证码
        String redisCode = (String) RedisUtil.get(verKey);
        // 判断验证码
        if (verCode==null || !redisCode.equals(verCode.trim().toLowerCase())) {
            return JsonResult.error("验证码不正确");
        }
        return JsonResult.ok();
    }

}
