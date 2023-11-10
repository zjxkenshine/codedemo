# 参考文档
github junitperf性能测试框架
- https://github.com/houbb/junitperf


# 相关注解
- `@JunitPerfConfig`：指定测试时的属性配置。(必填项)
    - threads：线程数
    - warmUp：预热时间
    - duration：执行时间
    - latencyStatistics：统计实现，默认DefaultStatisticsCalculator
    - reporter：报告实现，默认ConsoleReporter

- `@TestMethodOrder`：指定方法执行顺序
  - OrderedHtmlTest
