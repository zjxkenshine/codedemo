# 参考地址
jipsy 可配置的Java注释处理器，以简化服务提供程序接口ServiceLoader的使用。
- https://github.com/kordamp/jipsy

# 使用步骤
1. 创建接口Calculator
2. 创建实现类，添加注解`@ServiceProviderFor(Calculator.class)`
3. 编译自动生成spi
4. 使用

