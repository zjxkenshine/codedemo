package com.kenshine.hasorcore.test03_aop;

import com.kenshine.hasorcore.test01_base.FirstModule;
import com.kenshine.hasorcore.test02_ioc.FunBean;
import net.hasor.core.ApiBinder;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.Module;
import net.hasor.core.exts.aop.Matchers;
import org.hamcrest.Matcher;

import java.lang.reflect.Method;
import java.util.function.Predicate;

/**
 * 全局拦截器
 * @author kenshine
 */
public class MyModule implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        //1.任意类
        Predicate<Class<?>> atClass = Matchers.anyClass();
        //2.任意方法
        Predicate<Method> atMethod = Matchers.anyMethod();
        //3.注册拦截器
        apiBinder.bindInterceptor(atClass, atMethod, new SimpleInterceptor());
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build(new MyModule());
        // 全局拦截FunBean的call方法
        appContext.getInstance(FunBean.class).call();
    }
}