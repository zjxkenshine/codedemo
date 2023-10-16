package com.kenshine.retrofit.interceptor;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 23:23
 * @description：
 * @modified By：
 * @version: $
 *
 *
 *  * 这个拦截器是局部拦截器，可以在请求之前加入一些东西，比如token
 *  * 调用拦截器，在 RetrofitTest 里面用@Intercept注解配置拦截器和拦截路径
 *  *
 *  * 如果要创建全局拦截器，把 extends 后面换成 BaseGlobalInterceptor 就可以了，这样不需要加注解，全局生效
 */
@Component
public class TokenInterceptor extends BasePathMatchInterceptor {
    @Override
    protected Response doIntercept(Chain chain) throws IOException {
        String token = "This is a token";
        Request request = chain.request();
        if (!"".equals(token)) {
            request = request.newBuilder()
                    .header("Authorization", token)
                    .build();
        }
        return chain.proceed(request);
    }
}
