package test;

import com.kenshine.cglib.demo02.TestClass;
import com.kenshine.cglib.demo03.SampleClass;
import net.sf.cglib.proxy.*;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/30 22:03
 * @description：測試
 * @modified By：
 * @version: $
 */
public class EnhancerTest {

    /**
     * 1.FixedValue
     * 对所有拦截的方法返回相同的值
     */
    @Test
    public void test01_FixedValue(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib";
            }
        });
        //enhancer.create 创建增强代理对象
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null)); //拦截test，输出Hello cglib
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
        // 返回的值为 hello cglib
        // 会出现ClassCastException
        System.out.println(proxy.hashCode());
    }

    /**
     * 2. invocationHandler
     * 在代理类实例上调用其代理接口中声明的方法时，最终都会由InvocationHandler的invoke方法执行
     */
    @Test
    public void test02_invocationHandler(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //getDeclaringClass 获取声明方法的类
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
                    return "hello cglib";
                }else{
                    throw new RuntimeException("Do not know what to do");
                }
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        Assert.assertEquals("hello cglib", proxy.test(null));
        Assert.assertNotEquals("Hello cglib", proxy.toString());
    }

    /**
     * 3.CallbackFilter
     */
    @Test
    public void test03_CallbackFilter(){
        Enhancer enhancer = new Enhancer();
        //CallbackHelper
        CallbackHelper callbackHelper = new CallbackHelper(SampleClass.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                //满足条件则代理
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            return "Hello cglib";
                        }
                    };
                }else{
                    return NoOp.INSTANCE;
                }
            }
        };
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        SampleClass proxy = (SampleClass) enhancer.create();
        Assert.assertEquals("Hello cglib", proxy.test(null));
        Assert.assertNotEquals("Hello cglib",proxy.toString());
        System.out.println(proxy.hashCode());
    }

}
