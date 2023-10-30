package com.kenshine.qrext4j.controller;

import org.iherus.codegen.qrcode.SimpleQrcodeGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试Controller
 * @Date 2023-10-30 9:42
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public void testWritToStream(HttpServletResponse response) throws IOException {
        //自定义扫描二维码的路由
        String content = "http://t.csdn.cn/VIiwD";
        //自定义在前端展示的格式
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        new SimpleQrcodeGenerator().generate(content).toStream(out);
        //关闭响应输出流
        out.close();
    }
}
