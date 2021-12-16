package com.kenshine.guice.test01;

import com.google.inject.*;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/16 15:52
 * @description：
 * @modified By：
 * @version: $
 */
public class GuiceDemo {
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface Message {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface Count {}

    /**
     * 提供绑定的数据
     */
    static class DemoModule extends AbstractModule {
        /**
         * Providers提供绑定的数据
         * @return
         */
        @Provides
        @Count
        static Integer provideCount() {
            return 3;
        }

        @Provides
        @Message
        static String provideMessage() {
            return "hello world";
        }
    }

    /**
     * 被注入的类
     */
    static class Greeter {
        private final String message;
        private final int count;

        @Inject
        Greeter(@Message String message, @Count int count) {
            this.message = message;
            this.count = count;
        }

        void sayHello() {
            System.out.println(count);
            for (int i=0; i < count; i++) {
                System.out.println(message);
            }
        }
    }

    public static void main(String[] args) {
        /*
         * Guice.createInjector()返回一个注入的对象，多数程序只在main方法中调用一次
         */
        Injector injector = Guice.createInjector(new DemoModule());
        Greeter greeter = injector.getInstance(Greeter.class);
        greeter.sayHello();
    }
}
