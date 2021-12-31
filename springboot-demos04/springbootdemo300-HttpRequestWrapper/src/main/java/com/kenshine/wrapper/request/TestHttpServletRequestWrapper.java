package com.kenshine.wrapper.request;

import javax.servlet.ServletException;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 10:24
 * @description：HttpServletRequestWrapper源码
 * @modified By：
 * @version: $
 */
public class TestHttpServletRequestWrapper extends ServletRequestWrapper implements HttpServletRequest {
    /**
     * 构造方法
     */
    public TestHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /**
     * 获取HttpServletRequest.
     * @return HttpServletRequest.
     */
    private HttpServletRequest _getHttpServletRequest() {
        return (HttpServletRequest) super.getRequest();
    }

    /**
     * 返回认证类型.
     * 所有Servlet容器都支持basic、form、client_cert，digest不一定支持.
     * 若不支持，则返回null.
     */
    @Override
    public String getAuthType() {
        return this._getHttpServletRequest().getAuthType();
    }

    /**
     * 获取请求中带有的Cookie信息.
     */
    @Override
    public Cookie[] getCookies() {
        return this._getHttpServletRequest().getCookies();
    }

    /**
     * 以长整数形式返回一个特定的请求头，该长整数代表一个Date对象.
     * 该方法可以用在包含时间信息的header中，如：If-Modified-Since.
     * @param name 头名称.
     * @return 头值.
     */
    @Override
    public long getDateHeader(String name) {
        return this._getHttpServletRequest().getDateHeader(name);
    }

    /**
     * 根据指定的头名称获取头的值.
     * 若存在多个，则返回第一个.
     * @param name 头名称.
     * @return 头值.
     */
    @Override
    public String getHeader(String name) {
        return this._getHttpServletRequest().getHeader(name);
    }

    /**
     * 根据指定的头名称获取头值的枚举.
     * 若没有找到，则返回空的枚举.
     * @param name 头名称.
     * @return 头值.
     */
    @Override
    public Enumeration getHeaders(String name) {
        return this._getHttpServletRequest().getHeaders(name);
    }

    /**
     * 获取所有的头的枚举.
     * @return 头的枚举.
     */
    @Override
    public Enumeration getHeaderNames() {
        return this._getHttpServletRequest().getHeaderNames();
    }

    /**
     * 根据指定头名称获取int类型的值.若未找到则返回-1，如不是int类型，则会抛出NumberFormatException异常.
     * @param name 头名称.
     * @return 头值.
     */
    @Override
    public int getIntHeader(String name) {
        return this._getHttpServletRequest().getIntHeader(name);
    }

    /**
     * 获取HTTP方法，如：GET、POST、PUT等.
     * @return 方法名.
     */
    @Override
    public String getMethod() {
        return this._getHttpServletRequest().getMethod();
    }

    /**
     * 官网解释：
     *  返回与客户端发出此请求时发送的URL相关联的任何额外路径信息.
     *  额外的路径信息跟随servlet路径，但位于查询字符串之前，并以"/"字符开头.
     * 例如：url-pattern配置为/demo/*，请求URL为http://localhost/Pro/demo/htm/index.html，则pathInfo为/htm/index.html.
     * @return
     */
    @Override
    public String getPathInfo() {
        return this._getHttpServletRequest().getPathInfo();
    }

    /**
     * 返回servlet名称之后、
     *      查询字符串之前的任何额外路径信息，并将其转换为实际路径.
     *      与转换的CGI变量PATH U的值相同
     * @return
     */
    @Override
    public String getPathTranslated() {
        return this._getHttpServletRequest().getPathTranslated();
    }

    /**
     * 返回项目根路径.
     * 例如：url-pattern配置为/demo/*，请求URL为http://localhost/Pro/demo/htm/index.html，则contextPath为/demo.
     * @return 项目根路径.
     */
    @Override
    public String getContextPath() {
        return this._getHttpServletRequest().getContextPath();
    }

    /**
     * 获得请求中的查询字符串，例如a=1&b=2这样的格式.
     * @return 查询字符串.
     */
    @Override
    public String getQueryString() {
        return this._getHttpServletRequest().getQueryString();
    }

    /**
     * 如果用户已经过验证，则返回发出此请求的用户的登录信息，如果用户未经过验证，则返回 null.
     * 用户名是否随每个后续请求发送取决于浏览器和验证类型,返回的值与 CGI变量REMOTE_USER的值相同.
     * @return 用户信息.
     */
    @Override
    public String getRemoteUser() {
        return this._getHttpServletRequest().getRemoteUser();
    }

    /**
     * 返回一个 boolean值，指示指定的逻辑"角色"中是否包含经过验证的用户.
     * 角色和角色成员关系可使用部署描述符定义.
     * 如果用户没有经过验证，则该方法返回 false.
     * @param role 角色.
     * @return 已验证用户是否属于某种角色.
     */
    @Override
    public boolean isUserInRole(String role) {
        return this._getHttpServletRequest().isUserInRole(role);
    }

    /**
     * 返回包含当前已经过验证的用户的名称的 java.security.Principal对象.
     * 如果用户没有经过验证，则该方法返回 null.
     * @return java.security.Principal或null.
     */
    @Override
    public java.security.Principal getUserPrincipal() {
        return this._getHttpServletRequest().getUserPrincipal();
    }

    /**
     * 获取请求对应的sessionId.
     * @return sessionId.会话ID.
     */
    @Override
    public String getRequestedSessionId() {
        return this._getHttpServletRequest().getRequestedSessionId();
    }

    /**
     * 请求URL的相对地址，包括服务器路径，不包括查询参数.
     * @return 请求URL的相对地址.
     */
    @Override
    public String getRequestURI() {
        return this._getHttpServletRequest().getRequestURI();
    }

    /**
     * 请求的URL地址，包含协议、主机名、端口和服务器路径，但是不包括查询参数.
     * @return 请求URL地址.
     */
    @Override
    public StringBuffer getRequestURL() {
        return this._getHttpServletRequest().getRequestURL();
    }

    /**
     * 官方解释：
     *  返回此请求的URL中调用servlet的部分.
     *  此路径以"/"字符开头，包含servlet名称或到servlet的路径，但不包含任何额外的路径信息或查询字符串.
     *  与CGI变量SCRIPT_NAME的值相同.
     * 其实真是的意思就是，在配置webx.xml或编程式配置时，配置了url-pattern，请求的URL与url-pattern的有效部分重合部分就是servletPath，
     * 也可以理解为url-pattern的有效部分就是servletPath.
     * 例如：url-pattern配置为/demo/*，请求URL为http://localhost/Pro/demo/htm/index.html，则servletPath为/demo.
     * @return
     */
    @Override
    public String getServletPath() {
        return this._getHttpServletRequest().getServletPath();
    }

    /**
     * 获得请求对应的当前sesson.
     * 在没有session的情况下：
     *  若create=true，则新创建一个session.
     *  若create=false，则不创建session，返回null.
     * @param create session失效的情况下，是否创建session.
     * @return HttpSession实例.
     */
    @Override
    public HttpSession getSession(boolean create) {
        return this._getHttpServletRequest().getSession(create);
    }

    /**
     * 获得请求对应的当前sesson.
     * 若没有session，则创建一个session.
     * @return HttpSession实例.
     */
    @Override
    public HttpSession getSession() {
        return this._getHttpServletRequest().getSession();
    }

    @Override
    public String changeSessionId() {
        return null;
    }

    /**
     * 返回session是否有效.
     * @return session是否有效.
     */
    @Override
    public boolean isRequestedSessionIdValid() {
        return this._getHttpServletRequest().isRequestedSessionIdValid();
    }

    /**
     * sessionId是否从Cookie中获得.
     * @return 若是从Cookie中获得，返回true，否则返回false.
     */
    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return this._getHttpServletRequest().isRequestedSessionIdFromCookie();
    }

    /**
     * sessionId是否从URL中获得.
     * @return 若是从URL中获得，返回true，否则返回false.
     */
    @Override
    public boolean isRequestedSessionIdFromURL() {
        return this._getHttpServletRequest().isRequestedSessionIdFromURL();
    }

    /**
     * @deprecated
     * sessionId是否从URL中获得.
     * @return 若是从URL中获得，返回true，否则返回false.
     */
    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return this._getHttpServletRequest().isRequestedSessionIdFromUrl();
    }

    /**
     * 身份验证
     */
    @Override
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        return this._getHttpServletRequest().authenticate(response);
    }

    /**
     * 登录login
     */
    @Override
    public void login(String username, String password) throws ServletException {
        this._getHttpServletRequest().login(username, password);
    }

    /**
     * 登出logout
     */
    @Override
    public void logout() throws ServletException {
        this._getHttpServletRequest().logout();
    }

    /**
     * 所有上传的Parts的集合
     */
    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return this._getHttpServletRequest().getParts();
    }

    /**
     * 获取part
     */
    @Override
    public Part getPart(String name) throws IOException, ServletException {
        return this._getHttpServletRequest().getPart(name);
    }


    /**
     * 启动 HTTP 升级过程并创建提供的协议处理程序类的实例
     */
    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> httpUpgradeHandlerClass) throws IOException, ServletException {
        return this._getHttpServletRequest().upgrade(httpUpgradeHandlerClass);
    }
}
