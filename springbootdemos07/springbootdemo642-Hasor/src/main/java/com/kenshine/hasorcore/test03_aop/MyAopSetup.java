package com.kenshine.hasorcore.test03_aop;

import com.kenshine.hasorcore.test02_ioc.FunBean;
import net.hasor.core.ApiBinder;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.Module;
import net.hasor.core.exts.aop.Matchers;

import java.lang.reflect.Method;
import java.util.function.Predicate;

/**
 * @author by kenshine
 * @Classname MyAopSetup
 * @Description 自定义拦截器使用
 * @Date 2023-12-30 10:46
 * @modified By：
 * @version: 1.0$
 */
public class MyAopSetup implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        //1.任意类
        Predicate<Class<?>> atClass = Matchers.anyClass();
        //2.有MyAop注解的方法
        Predicate<Method> atMethod = Matchers.annotatedWithMethod(MyAop.class);
        //3.让@MyAop注解生效
        apiBinder.bindInterceptor(atClass, atMethod, new SimpleInterceptor());
    }

    @MyAop
    public void test(){
        System.out.println("自定义拦截器");
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build(new MyAopSetup());
        // 自定义拦截器使用
        appContext.getInstance(MyAopSetup.class).test();
    }
}
