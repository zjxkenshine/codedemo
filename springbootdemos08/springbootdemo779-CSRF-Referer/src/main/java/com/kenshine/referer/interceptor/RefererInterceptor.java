package com.kenshine.referer.interceptor;

import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;

/**
 * @author kenshine
 * Referer拦截器
 *
 */
public class RefererInterceptor implements AsyncHandlerInterceptor {

    /**
     * 白名单
     */
    private String[] refererDomain = new String[]{"127.0.0.1"};
    /**
     * 是否开启referer校验
     */
    private Boolean check =true;


    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) {
        if (!check) {
            return true;
        }
        String referer = req.getHeader("Referer");
        String host = req.getServerName();
        // 验证非get请求
        if (!"GET".equals(req.getMethod())) {
            if (referer == null) {
                // 状态置为404
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return false;
            }
            java.net.URL url = null;
            try {
                url = new java.net.URL(referer);
            } catch (MalformedURLException e) {
                // URL解析异常，也置为404
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return false;
            }
            System.err.println(url.getHost());
            System.err.println(host);
            // 首先判断请求域名和referer域名是否相同
//            if (!host.equals(url.getHost())) {
                // 如果不等，判断是否在白名单中
                if (refererDomain != null) {
                    for (String s : refererDomain) {
                        if (s.equals(url.getHost())) {
                            System.err.println(url.getHost());
                            return true;
                        }
                    }
                }
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return false;

//            }
        }
        return true;
    }

}