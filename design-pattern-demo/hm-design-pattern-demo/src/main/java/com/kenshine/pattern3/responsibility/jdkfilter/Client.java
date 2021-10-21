package com.kenshine.pattern3.responsibility.jdkfilter;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 模拟 filter chain 责任链
 * @Author: kenshine
 */
public class Client {
    public static void main(String[] args) {
        Request  req = null;
        Response res = null ;

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new FirstFilter()).addFilter(new SecondFilter());
        filterChain.doFilter(req,res);
    }
}
