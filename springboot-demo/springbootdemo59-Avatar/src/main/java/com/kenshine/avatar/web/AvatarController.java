package com.kenshine.avatar.web;

import com.kenshine.avatar.util.AvatarUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 14:22
 * @description：获取头像测试
 * @modified By：
 * @version: $
 */
@RestController
public class AvatarController {

    /**
     * 获取图片 文字类型
     * @param name
     * @param response
     * @throws IOException
     */
    @GetMapping("/test01")
    public void getAvatar01(@RequestParam("name") String name, HttpServletResponse response) throws IOException {
        AvatarUtil.getWordImgToResponse(name,name,response);
    }

    /**
     * 获取图片 hash类型
     * @param name
     * @param response
     * @throws IOException
     */
    @GetMapping("/test02")
    public void getAvatar02(@RequestParam("name") String name, HttpServletResponse response) throws IOException {
        AvatarUtil.getHashImgToResponse(name,response);
    }



}
