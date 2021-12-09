# 1.简介
- 每当ApplicationContext发布ApplicationEvent时,ApplicationListener将自动被触发
- Springboot默认支持6种事件监听器：(按照执行顺序)
    - ApplicationStartingEvent：在Spring最开始启动的时候触发
    - ApplicationEnvironmentPreparedEvent：在Spring已经准备好上下文但是上下文尚未创建的时候触发,可加载一些属性
    - ApplicationPreparedEvent：在Bean定义加载之后、刷新上下文之前触发
    - ApplicationStartedEvent：在刷新上下文之后、调用application命令之前触发
    - ApplicationReadyEvent：在调用applicaiton命令之后触发
    - ApplicationFailedEvent：在启动Spring发生异常时触发
    - 注意：
        - ApplicationRunner和CommandLineRunner的执行在第五步和第六步之间
        - Bean的创建在第三步和第四步之间
        - 在启动类中，执行SpringApplication.run()方法后的代码，会在第六步后执行
- ApplicationListener使用场景：
    - 启动时连接配置,打印一些topic信息
    - 校验某些环境，配置是否满足
    - 数据库连接
    - 特定定时任务的执行

# 2.Spring内置事件
- ContextRefreshedEvent：ApplicationContext被初始化或刷新时发布
- ContextStartedEvent：当使用ConfigurableApplicationContext(ApplicationContext子接口)接口中的start()方法启动ApplicationContext时发布
- ContextStoppedEvent：当使用 ConfigurableApplicationContext 接口中的 stop() 停止 ApplicationContext 时发布
- ContextClosedEvent：当使用 ConfigurableApplicationContext 接口中的 close() 方法关闭 ApplicationContext 时发布
- RequestHandledEvent：spring作为前端的MVC控制器时，当Spring处理用户请求结束后，系统会自动触发该事件
- 可以自定义事件与监听器

# 3.Servlet常用监听器接口
- ServletContextListener：监听servletContext对象的创建以及销毁
- HttpSessionListener：监听session对象的创建以及销毁
- ServletRequestListener：监听request对象的创建以及销毁
- ServletContextAttributeListener：监听servletContext对象中属性的改变
- HttpSessionAttributeListener：监听session对象中属性的改变
- ServletRequestAttributeListener：监听request对象中属性的改变

# 4.使用方式
ApplicationListener用法：
- 用法一：实现ApplicationListener接口
- 用法二：使用注解@EventListener

异步监听处理：
- `@Async`+`@EventListener`注解

多Listener
- `@Order(n)`+`@EventListener`注解
- 数值越小的越先执行
- 接口方式需要实现SmartApplicationListener接口

