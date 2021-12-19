# 1.classworlds简介
- Plexus Classworlds 是一个框架，适用于需要对 Java 的类加载器进行复杂操作的容器开发人员
- Plexus Classworlds为类加载提供了比 Java 正常机制更丰富的语义集，仍提供 ClassLoader 接口与 Java 环境无缝集成
- Plexus Classworlds摒弃了类加载器层次结构，提供了一个ClassRealms池 ，可以从其他 ClassRealms 导入任意包
- Plexus Classworlds提供了一个 启动器 来帮助从配置文件创建类加载器和ClassRealm

# 2.相关组件概述
1. classrealm：提供类加载功能
    - loadclass，加载类，返回Class对象
    - addUrl，增加可用加载path
    - 配置strategy
    - importFrom，可与其他classrealm关联，从其他classrealm加载类
2. 类加载过程
    - 从parent加载（委派）
    - 使用strategy加载
        - 默认selfFirstStrategy先从import加载
        - 再从自身加载
        - 最后从parent classrealm加载
3. 资源加载
    - getResource：获取单个资源文件，先从base基类加载，再从当前类url加载，最后从parent加载
    - getResources：可获取所有资源文件
4. launch：实现从配置文件加载classrealm
可为其他应用程序提供类加载服务，如maven
