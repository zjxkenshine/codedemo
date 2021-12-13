# 1.简介
- CommandLineRunner、ApplicationRunner 接口是在容器启动成功后的最后一步回调（类似开机自启动）
- ApplicationRunner是对CommandLineRunner的进一步封装，将args参数包装成ApplicationArguments

# 2.@PostCunstruct与CommandLineRunner初始化的区别
- 在项目启动完立即初始化一些数据（比如缓存等），使用CommandLineRunner
- 在类加载的时候，为当前类初始化一些数据，那么可以使用@PostConstruct注解

# 3.@PostConstruct执行顺序
- 在一个类内，如果有构造器（Constructor ），有@PostConstruct，还有@Autowired，他们的先后执行顺序为Constructor >> @Autowired >> @PostConstruct
- 所以PostConstruct可以使用Bean中的值对类进行初始化
