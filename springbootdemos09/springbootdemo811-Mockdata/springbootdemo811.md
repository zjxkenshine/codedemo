# 参考地址
mockdata 一个易用且高度自定义的数据生成工具。主要用于测试或是批量随机数据生成
- https://github.com/Verlif/mockdata

官网
- https://verlif.top/mockdata/#/

# 使用场景
- WEB场景下生成测试数据测试后台接口
- 数据库中需要批量插入合规数据
- 各种场景下的随机数据测试
- 场景演示下生成随机数据展示

# 更多特性
- 多配置，MockDataCreator自带有全局配置，也可以在mock的时候指定本次构建使用的临时配置而不影响其他mock。
- 构建过滤器，使用FieldFilter和ClassFilter来过滤不需要构建的属性或类型。
- 精确到某个类下的某个属性，允许开发者通过fieldValue方法指定不同类的不同属性所使用的构建方式。
- 通过 转义器 将自定义的构建数据支持到更多的类型中。
