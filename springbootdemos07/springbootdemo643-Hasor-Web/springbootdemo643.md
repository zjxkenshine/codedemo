# 参考地址
hasor Web开发
- https://www.hasor.net/docs/guides/web/
- https://www.hasor.net/docs/integration/with-springboot

# 简介
springboot 与 hasor整合

## @EnableHasor 注解
EnableHasor 注解是 Spring Boot 启动 Hasor 的根本
- scanPackages：用来配置扫描 Module 的范围，一般情况下如果 Module 已经被 Spring 作为 Bean 托管之后就无需在配置扫描范围
- mainConfig：虽然共享 Spring 的配置已经解决了大部分配置文件读取的问题，但有时候还是需要更高级的 hconfig.xml 配置文件
- useProperties：Hasor 在启动的时候会将 Spring Environment 中属性信息全部导入到 Hasor Environment 接口中
    - useProperties 属性的作用是告诉 Hasor ,是否将 Hasor Environment 接口信息进一步导入到 Settings 接口里。默认值为 false，表示不导入
- startWith：用来声明启动入口。
- customProperties：设定一些特殊的属性K/V信息传递给 Hasor Environment 中

## @EnableHasorWeb 注解
- SpringWeb 环境中启用 Hasor-Web 能力
    - path：Hasor-Web 的全局拦截器配置的拦截路径，默认值是： /*
    - order：生效顺序，默认值是： 0 （仅在 Filter、Interceptor 模式下有效）
    - at：工作模式：Filter\Controller（推荐使用）