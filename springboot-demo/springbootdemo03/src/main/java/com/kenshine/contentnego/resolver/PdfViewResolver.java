package com.kenshine.contentnego.resolver;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 11:18
 * @description：PDF视图解析器
 * @modified By：
 * @version: 1.0$
 */
public class PdfViewResolver implements View {


    @Override
    public String getContentType() {
        return MediaType.APPLICATION_PDF_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.getWriter().write("<html><body style='color:red'>This is [PDF] view</body></html>");
    }
}
