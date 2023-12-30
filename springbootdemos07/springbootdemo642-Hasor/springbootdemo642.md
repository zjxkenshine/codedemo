# 参考地址
hasor官方文档
- https://www.hasor.net/docs/guides/overview

# 目录
- test01_base：加载模块启动，配置文件启动
- test02_ioc：ioc注入
  - CustomBean：构造器注入
  - CustomBean2：属性注入
  - PayService：接口注解注入
  - PayServiceImpl：接口代码注入
  - DataBaseBean：配置注入
  - SystemBean：注入环境变量
- test03_aop：动态代理
  - AopBean：方法级拦截器
  - AopBean1：类拦截器
  - MyModule：全局拦截器
  - AopBean2：多拦截器
  - MyAopSetup：自定义拦截器
  - AopBean3：忽略动态代理
- test04_property：动态属性
  - PojoBean：动态添加属性
  - SimplePropertyDelegate：属性委托
  - PojoBean3：全局动态属性