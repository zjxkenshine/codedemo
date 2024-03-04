package com.kenshine.joddproxetta;

import jodd.paramo.MethodParameter;
import jodd.paramo.Paramo;
import jodd.proxetta.InvokeReplacer;
import jodd.proxetta.Proxetta;
import jodd.proxetta.ProxyAspect;
import jodd.proxetta.ProxyPointcut;
import jodd.proxetta.impl.ProxyProxetta;
import jodd.proxetta.impl.WrapperProxetta;
import jodd.proxetta.impl.WrapperProxettaFactory;
import jodd.proxetta.pointcuts.MethodWithAnnotationPointcut;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname ProxettaTest
 * @Description jodd-proxetta使用测试
 * @Date 2024-03-04 8:47
 * @modified By：
 * @version: 1.0$
 */
public class ProxettaTest {

    /**
     * Pointcut 切点
     */
    @Test
    public void test01(){
        // 定义切点
        ProxyPointcut pointcut = MethodWithAnnotationPointcut.of(Log.class);
        // 合并切点定义
        ProxyPointcut pointcut1 = ((ProxyPointcut)
                methodInfo -> methodInfo.isPublicMethod()
                        && methodInfo.isTopLevelMethod())
                .and(MethodWithAnnotationPointcut.of(Log.class));
    }

    /**
     * Advice 建议
     */
    @Test
    public void test02(){
        // LogProxyAdvice类
    }

    /**
     * Proxy代理
     */
    @Test
    public void test03(){
        ProxyPointcut pointcut = MethodWithAnnotationPointcut.of(Log.class);
        ProxyAspect aspect = ProxyAspect.of(LogProxyAdvice.class, pointcut);
        /**
         * 创建代理
         * .proxyProxetta();
         * .wrapperProxetta();
         * .invokeProxetta();
         */
        ProxyProxetta proxetta =  Proxetta
                .proxyProxetta()
                .withAspect(aspect);
        // 代理类
        //Class fooClass = proxetta.proxy().setTarget(Foo.class).define();
        //代理对象
        Foo foo = (Foo) proxetta.proxy().setTarget(Foo.class).newInstance();
        foo.foo();
    }

    /**
     * wrapper 方式代理
     */
    @Test
    public void test04(){
        ProxyPointcut pointcut = MethodWithAnnotationPointcut.of(Log.class);
        ProxyAspect aspect = ProxyAspect.of(LogProxyAdvice.class, pointcut);

        WrapperProxetta proxetta = Proxetta
                .wrapperProxetta()
                .withAspect(aspect);
        WrapperProxettaFactory factory = proxetta
                .proxy()
                .setTarget(Foo.class)
                .setTargetInterface(BaseFoo.class);

        BaseFoo foo = (BaseFoo) factory.newInstance();
        Foo foo1 = new Foo();
        factory.injectTargetIntoWrapper(foo, foo1);
        foo1.foo();
    }

    /**
     * Invocation replacement 方法调用代理
     */
    @Test
    public void test05(){
        Proxetta proxetta = ProxyProxetta.invokeProxetta().withAspect(
                invokeInfo -> {
                    if ("foo".equals(invokeInfo.getMethodName())) {
                        return InvokeReplacer.with(Replacer.class, "bar");
                    }
                    return null;
                });
        One one = (One) proxetta.proxy().setTarget(One.class).newInstance();
        one.example1();
    }

    /**
     * Paramo 获取方法形参名称
     */
    @Test
    public void test06() throws NoSuchMethodException {
        MethodParameter[] s = Paramo.resolveParameters(Foo1.class.getConstructor(String.class));
        // 1
        System.out.println(s.length);
        // something
        System.out.println(s[0].getName());
        MethodParameter[] s1 = Paramo.resolveParameters(Foo1.class.getMethod("hello"));
        // 0
        System.out.println(s1.length);
        MethodParameter[] s2 = Paramo.resolveParameters(Foo1.class.getMethod("two",String.class,String.class));
        // 2
        System.out.println(s2.length);
        // username
        System.out.println(s2[0].getName());
        // password
        System.out.println(s2[1].getName());
    }
}
