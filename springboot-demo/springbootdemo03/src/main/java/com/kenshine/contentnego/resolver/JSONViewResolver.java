package com.kenshine.contentnego.resolver;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 11:18
 * @description：Excel视图解析器
 * @modified By：
 * @version: $
 */
public class JSONViewResolver implements View {


    @Override
    public String getContentType() {
        return MediaType.APPLICATION_JSON_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.getWriter()
                .write("<html><body style='color:blue'>This is [JSON] view!</body></html>");
    }

}
