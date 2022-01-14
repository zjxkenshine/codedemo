# 1.IOC
## 1.1 基础
- 把对象创建和对象之间的调用过程，交给Spring进行管理
- IOC容器实现的两种方式：
    - BeanFactory
    - ApplicationContext
- bean配置两种方式：xml配置，注解
- DI：依赖注入，有以下方式
    - set方法
    - 构造器
    - p空间
    - 属性
    
## 1.2 XML方式管理Bean
FactoryBean：参考spring5-demo01 MyBean
- Spring 有两种类型 bean，一种普通 bean，另外一种工厂 bean（FactoryBean）
- 种工厂 bean 在配置文件定义 bean 类型可以和返回类型不一样
   
bean 作用域：
- singleton 单实例，prototype 多实例
- scope 值是 singleton 时候，加载 spring 配置文件时候就会创建单实例对象
- 值是 prototype 时候，在调用 getBean 方法时候创建多实例对象

bean 生命周期：
- （1）通过构造器创建 bean 实例（无参数构造）
- （2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
- （3）调用 bean 的初始化的方法（需要进行配置初始化的方法）
- （4）bean 可以使用了（对象获取到了）
- （5）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）

Spring自动装配，不需要使用property标签
- byname按属性名称注入
- bytype按属性类型注入

## 1.2 注解方式管理Bean
创建Bean实例的四个注解：
- @Component
- @Service
- @Controller
- @Repository

相关注解：
- `@Autowired`：根据属性类型进行自动装配
- `@Qualifier`：根据名称进行注入，这个@Qualifier 注解的使用，和上面@Autowired 一起使用
- `@Resource`：可以根据类型注入，也可以根据名称注入（它属于javax包下的注解，不推荐使用！）
- `@Value`：注入普通类型属性

完全注解开发：创建配置类，替代 xml 配置文件
- `@Configuration` //作为配置类，替代 xml 配置文件
- `@ComponentScan(basePackages = {"com.kenshine.demo02"})`

# 2.AOP 面向切面编程
AOP底层原理
- AOP 底层使用动态代理，两种情况
    - 有接口情况，使用 JDK 动态代理
    - 没有接口情况，使用 CGLIB 动态代理.

AOP术语
- a）连接点：类里面哪些方法可以被增强，这些方法称为连接点
- b）切入点：实际被真正增强的方法称为切入点
- c）通知（增强）：实际增强的逻辑部分称为通知，且分为以下五种类型：
- 1）前置通知 2）后置通知 3）环绕通知 4）异常通知 5）最终通知
- d）切面：把通知应用到切入点过程

Spring 框架一般都是基于 AspectJ 实现 AOP 操作

相关注解：
- @Aspect：生成代理对象
- @Pointcut：切入点表达式
- @Before：前置通知
- @AfterReturning：后置返回
- @After：最终通知
- @AfterThrowing：异常通知
- @Around：环绕通知


