# 相关注解
1. `@ConfigurationProperties`：与application.yml/properties绑定
    - `@ConfigurationProperties(prefix = "person")` 指定前缀
    - `spring-boot-configuration-processor`：自定义注解提示
2. `@PropertySource`: 指定属性文件的路径，默认不支持yml
    - `@Value`：为属性注入值（只能是基本类型或String）
3. `@ImportResource`：该注解导入Spring的xml配置文件，让配置文件里面的内容生效
4. `@Conditional`：必须是@Conditional指定的条件成立，才给容器中添加组件，配置配里面的所有内容才生效
