package com.kenshine.pattern3.responsibility.jdkfilter;

/**
 * @version v1.0
 * @ClassName: FirstFilter
 * @Description: 第一个过滤器
 * @Author: kenshine
 */
public class FirstFilter implements Filter {
    @Override
    public void doFilter(Request req, Response res, FilterChain chain) {
        System.out.println("过滤器1 前置处理");

        // 先执行所有request再倒序执行所有response
        chain.doFilter(req, res);

        System.out.println("过滤器1 后置处理");
    }
}
