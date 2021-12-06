# 1.coherence简介
- Coherence的主要用途是共享一个应用的对象(主要是java对象，比如Web应用的一个会话java对象)和数据(比如数据库数据，通过OR-MAPPING后成为Java对象)。　
- 简单来说，就是当一个应用把它的对象或数据托管给Coherence管理的时候，该对象或数据就能够在整个集群环境(多个应用服务器节点)共享
- 分为开源版(CE)和商业版
- Coherence所有的设计都是基于多个(可以是非常多)的JVM，很多Coherence的测试都是使用几十甚至上百个节点来进行的
- 别名Data Gird：数据网格

# 2.Coherence Spring主要组件
- Coherence Spring Session
    - 使用 Coherence 对Spring Session的支持
- Coherence Spring Data
   - 提供与 Coherence 数据网格的集成
   - 特性：
        - 强大的投影功能
        - 灵活的就地实体更新
        - 一流的数据聚合支持
        - 流 API 支持
        - 事件监听器支持
        - 声明式加速和索引创建
        - 原生异步支持
- Coherence Spring Cache
    - 对JSR-107的支持
- Coherence Spring Cloud


