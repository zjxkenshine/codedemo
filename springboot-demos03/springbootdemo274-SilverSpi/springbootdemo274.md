# 参考地址
gitee
- https://gitee.com/liuyueyi/SilverSpi
- https://my.oschina.net/u/566591/blog/911055
- https://my.oschina.net/u/566591/blog/911076

# 1.组件
- Selector 选择器
- Spi 注解：所有的 spi 接口，都必须有这个注解
- SpiAdaptive 注解：自适应，动态spi支持， 只能在自适应的场景下使用，用于额外指定 spi 接口中某个方法的选择器
- SpiConf 注解：主要是用在实现类上（或实现类的方法上），里面存储一些选择条件，通常是和 Selector 搭配使用
- SpiLoader：加载器
- SpiImplWrapper：解析 @SpiConf 注解信息，spi 实现类，以及定义的各种条件的封装类
- 初始化选择器：
    - currentSelector , currentMethodSelector：类、方法选择器
    - selectorInstanceCacheMap：spi接口所有定义的选择器映射关系表，key为选择器类型，value是实例
- 获取选择器：
    - 静态确定 spi 实现时，直接用 currentSelector 即可 （spi 接口中所有方法都公用类定义选择器）
    - 动态适配时， 根据方法名在 currentMethodSelector 中获取选择器

# 2.目录
- Test01：静态spi
- Test02：动态适配spi
- Test03：自定义Selector

