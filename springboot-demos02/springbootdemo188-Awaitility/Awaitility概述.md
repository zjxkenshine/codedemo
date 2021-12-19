# 1.Awaitility简介
- 传统异步测试：Thread.sleep
- Awaitility是一个异步测试框架，可设定最多，最少等待时间，或永久等待，或自定义轮询策略
  - 之后就开始进行需要的断言，可以尽可能的节省测试异步方法所需的时长

# 2.目录
1. 基本用法 `Awaitility.await()`
2. 自定义停止时间，轮询间隔时间等
3. 使用hamcrest匹配器检测结果
4. 忽略异常
5. 使用代理，调用方法
6. 对字段使用断言
7. ScheduledTest.test07：测试@Schedule定时任务

