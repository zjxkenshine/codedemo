package com.kenshine.pattern3.responsibility.jdkfilter;

/**
 * @version v1.0
 * @ClassName: Filter
 * @Description: 过滤器接口
 * @Author: kenshine
 */
public interface Filter {
    public void doFilter(Request req, Response res, FilterChain c);
}
