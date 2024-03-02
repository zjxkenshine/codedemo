# 参考地址
Jodd-Petite IOC框架与组件管理器
- https://petite.jodd.org

# 1.Container容器
包含三方面：
- Registration 注册
- Wire 连接
- Scope 范围

## 1.1 Registration 注册
registerPetiteBean方法
- type：bean类型
- name：bean名称
- scopeType：bean范围，null会从类中解析
- wiringMode：连接模式，可省略
- define：设置为true则会解析 inject point 切入点

@PetiteInitMethod：指定初始化方法，三种调用策略
- POST_CONSTRUCT：创建bean之后，连接bean与参数注入之前
- POST_DEFINED：连接后，注入前
- POST_INITALIZED：完全初始化之后

@PetiteBean注解：自动注册
- value：bean名称
- scope
- wiring：连接模式

## 1.2 wire 连接（注入）
三种方式
- 属性注入
- 构造方法注入
- 方法注入

Wiring mode 注入模式:
- NONE：无连接
- DEFAULT：由容器配置
- STRICT：严格模式，只影响属性注入点，只注入带注释的
- OPTIONAL：可选模式，同上，但是不会抛异常
- AUTOWIRE：尝试在所有bean字段中注入值

## 1.3 scope选项
- ProtoScope：每次请求都创建bean
- SingletonScope：单例模式
- SessionScope：bean每个session相同
- ThreadLocalScope：bean每个线程相同


# 2.目录
- Bar：三种注入方式
- PetiteTest：简单使用测试
    - test01：注册与获取bean
    - test02：自动注册
    - test03：scope