# 参考地址
streamex
- https://github.com/amaembo/streamex

Streamex: 增强Java流API
- https://www.5axxw.com/wiki/content/rudugq

# StreamEx特点
StreamEx库的要点如下：
- 简单方便地完成常见任务的方法。
- 与旧代码更好的互操作性。
- 与原始JDK流100%兼容。
- 并行处理的友好性：任何新特性都尽可能地利用并行流的优势。
- 性能和最小的开销。如果与标准流相比，StreamEx允许使用更少的代码来解决任务，那么它不应该比标准方式慢得多（有时甚至更快）。

# 相关类
- StreamEx，IntStreamEx，LongStreamEx，DoubleStreamEx：与Java8流类完全兼容，提供了其他方法
- EntryStream类，它表示映射条目流
- MoreCollectors：定义了一些新的有用的收集器及原始收集器

# 目录
- test01：快捷collect方法
- test02：转换流
- test03：添加到流
- test04：删除不需要的元素并将流用作Iterable
- test05：Map筛选
- test06：在key-value对上操作
- test07：成对差异
- test08：支持byte/char/short/float类型
- test09：递归定义自定义延迟中间操作

