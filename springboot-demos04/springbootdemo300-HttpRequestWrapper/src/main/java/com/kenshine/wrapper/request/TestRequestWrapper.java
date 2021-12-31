package com.kenshine.wrapper.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 10:12
 * @description：ServletRequestWrapper 源码
 * @modified By：
 * @version: $
 * ServletRequestWrapper提供了一个简便实现类，在对ServletRequest有改动需求的时，可以重写此类，之后Request的操作都会经过重写的类
 */
public class TestRequestWrapper extends ServletRequestWrapper {
    /**
     * ServletRequestWrapper持有ServletRequest的实例.
     */
    private ServletRequest request;

    /**
     * 构建ServletRequestWrapper，传入ServletRequest的值.
     */
    public TestRequestWrapper(ServletRequest request) {
        super(request);
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        this.request = request;
    }

    /**
     * 获取ServletRequest实例.
     */
    @Override
    public ServletRequest getRequest() {
        return this.request;
    }

    /**
     * 设置ServletRequest实例.
     * @param request ServletRequest.
     */
    @Override
    public void setRequest(ServletRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }
        this.request = request;
    }

    /**
     * 获取Servlet的属性.
     */
    @Override
    public Object getAttribute(String name) {
        return this.request.getAttribute(name);
    }

    /**
     * 获取所有属性枚举格式.
     */
    @Override
    public Enumeration getAttributeNames() {
        return this.request.getAttributeNames();
    }

    /**
     * 返回请求中输入内容的字符编码类型，如果没有定义字符编码类型就返回空值.
     * @return 字符编码.
     */
    @Override
    public String getCharacterEncoding() {
        return this.request.getCharacterEncoding();
    }

    /**
     * 设置输入内容的字符编码类型.
     * @param enc 字符编码类型.
     * @throws java.io.UnsupportedEncodingException .
     */
    @Override
    public void setCharacterEncoding(String enc) throws java.io.UnsupportedEncodingException {
        this.request.setCharacterEncoding(enc);
    }

    /**
     * 请求内容的长度，如果长度未知就返回-1.
     * @return 请求内容长度.
     */
    @Override
    public int getContentLength() {
        return this.request.getContentLength();
    }

    /**
     * 返回请求数据体的MIME类型CONTENT-TYPE，如果类型未知返回空值.
     * @return
     */
    @Override
    public String getContentType() {
        return this.request.getContentType();
    }

    /**
     * 返回一个输入流，使用该输入流以二进制方式读取请求正文的内容.
     * javax.servlet.ServletInputStream是一个抽象类，继承自InputStream.
     * @return .
     * @throws IOException .
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        return this.request.getInputStream();
    }

    /**
     * 根据指定参数名获取参数值.
     * @param name 参数名.
     * @return 参数值.
     */
    @Override
    public String getParameter(String name) {
        return this.request.getParameter(name);
    }

    /**
     * 获取参数的Map形式，包括所有参数.
     * @return 参数Map.
     */
    @Override
    public Map<String, String[]> getParameterMap() {
        return this.request.getParameterMap();
    }

    /**
     * 获取所有参数名的枚举.
     * @return 参数名枚举.
     */
    @Override
    public Enumeration getParameterNames() {
        return this.request.getParameterNames();
    }

    /**
     * 根据指定属性名获取参数值数组.
     * @param name 参数名.
     * @return 参数值数组.
     */
    @Override
    public String[] getParameterValues(String name) {
        return this.request.getParameterValues(name);
    }

    /**
     * 返回请求使用的协议信息.格式为：协议/主版本号.次版本号.例如：http/1.0.
     * @return
     */
    @Override
    public String getProtocol() {
        return this.request.getProtocol();
    }

    /**
     * 返回请求所使用的URL的模式.若http、https等.
     * @return 模式.
     */
    @Override
    public String getScheme() {
        return this.request.getScheme();
    }

    /**
     * 返回请求发送到的服务器的主机名.
     * @return 主机名.
     */
    @Override
    public String getServerName() {
        return this.request.getServerName();
    }

    /**
     * 返回请求发送到的服务器的端口号.
     * @return 端口号.
     */
    @Override
    public int getServerPort() {
        return this.request.getServerPort();
    }

    /**
     * 返回BufferedReader对象，以字节数据方式读取请求正文.
     * @return .
     * @throws IOException .
     */
    @Override
    public BufferedReader getReader() throws IOException {
        return this.request.getReader();
    }

    /**
     * 返回发送请求的客户端或最后一个代理服务器的IP地址.
     * @return IP地址.
     */
    @Override
    public String getRemoteAddr() {
        return this.request.getRemoteAddr();
    }

    /**
     * 返回发送请求的客户端或最后一个代理服务器的主机名.
     * @return 主机名.
     */
    @Override
    public String getRemoteHost() {
        return this.request.getRemoteHost();
    }

    /**
     * 根据传递的属性名和属性值设置Request属性.
     * @param name 属性名.
     * @param o 属性值.
     */
    @Override
    public void setAttribute(String name, Object o) {
        this.request.setAttribute(name, o);
    }

    /**
     * 从Request中删除指定的属性名对应的值.一般使用此方法.
     * @param name 属性名.
     */
    @Override
    public void removeAttribute(String name) {
        this.request.removeAttribute(name);
    }

    /**
     * 根据客户端传递的Accept-Language对应的区域设置.
     * 若客户端未指定Accept-Language，则返回服务器默认语言环境.
     * @return
     */
    @Override
    public Locale getLocale() {
        return this.request.getLocale();
    }

    /**
     * 返回Locale对象的枚举，从首选区域开始按降序返回基于Accept-Language头的客户端可接受的区域.
     * 如果客户机请求不提供Accept-Language头，此方法返回包含一个Locale的枚举，即是服务器默认语言环境对应的Locale.
     * @return
     */
    @Override
    public Enumeration getLocales() {
        return this.request.getLocales();
    }

    /**
     * 指示是否使用安全通道（如HTTPS）发出此请求.
     */
    @Override
    public boolean isSecure() {
        return this.request.isSecure();
    }

    /**
     * 返回RequestDispatcher对象，作为path所定位的资源的封装.
     * RequestDispatcher用于服务器请求转发.
     * @param path 相对路径或绝对路径.
     * @return RequestDispatcher.
     */
    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        return this.request.getRequestDispatcher(path);
    }

    /**
     * @deprecated
     * Servlet API 2.1开始已不推荐使用此API.
     * 取得文件在服务器上的绝对路径.
     * @param path 相对路径.
     * @return 绝对路径.
     */
    @Override
    public String getRealPath(String path) {
        return this.request.getRealPath(path);
    }

    /**
     * 返回发送请求的客户端或者最后一个代理服务器的IP源端口， 这个方法是在Servlet 2.4规范中新增的方法.
     * @return 端口号.
     */
    @Override
    public int getRemotePort() {
        return this.request.getRemotePort();
    }

    /**
     * 返回接收到请求的IP接口的主机名，这个方法是在Servlet 2.4规范中新增的方法.
     * @return 主机名.
     */
    @Override
    public String getLocalName() {
        return this.request.getLocalName();
    }

    /**
     * 返回接收到请求的网络接口的IP地址，这个方法是在Servlet 2.4规范中新增的方法.
     * @return IP地址.
     */
    @Override
    public String getLocalAddr() {
        return this.request.getLocalAddr();
    }

    /**
     * 返回接收到请求的网络接口的IP端口号，这个方法是在Servlet 2.4规范中新增的方法.
     * @return 端口号.
     */
    @Override
    public int getLocalPort() {
        return this.request.getLocalPort();
    }
}
