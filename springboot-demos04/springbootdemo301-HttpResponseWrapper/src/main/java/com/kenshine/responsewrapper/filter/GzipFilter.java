package com.kenshine.responsewrapper.filter;

import com.kenshine.responsewrapper.response.CustomResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 21:50
 * @description：Gzip压缩过滤
 * @modified By：
 * @version: $
 */
public class GzipFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String headEncoding = ((HttpServletRequest)request).getHeader("accept-encoding");
        // 客户端 不支持 gzip
        if (headEncoding == null || (headEncoding.indexOf("gzip") == -1)) {
            chain.doFilter(request, response);
            System.out.println("----------------该浏览器不支持gzip格式编码-----------------");
        } else { // 支持 gzip 压缩，对数据进行gzip压缩
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            // 包装响应对象 resp 并缓存响应数据
            CustomResponseWrapper mResp = new CustomResponseWrapper(resp);

            chain.doFilter(req, mResp);

            // 获取缓存的响应数据
            byte[] bytes = mResp.getBytes();
            System.out.println("压缩前大小：" + bytes.length);
            System.out.println("压缩前数据：" + new String(bytes, StandardCharsets.UTF_8));

            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            // 创建 GZIPOutputStream 对象
            GZIPOutputStream gzipOut = new GZIPOutputStream(bout);

            // 将响应的数据写到 Gzip 压缩流中
            gzipOut.write(bytes);
            gzipOut.flush();
            // 将数据刷新到  bout 字节流数组
            gzipOut.close();

            byte[] bts = bout.toByteArray();
            System.out.println("压缩后大小：" + bts.length);
            // 设置响应头信息
            resp.setHeader("Content-Encoding", "gzip");
            // 将压缩数据响应给客户端
            resp.getOutputStream().write(bts);
        }
    }
}
