# 1.Slf4j日志绑定(适配器)
- 绑定logback：
    - locgback-classic.jar
    - logback-core.jar
    - Maven中只需导入`locgback-classic`，会传递依赖
- 绑定log4j：
    - slf4j-log412.jar
    - log4j.jar
- 绑定JUL：
    - slf4j-jdk14.jar
- 绑定simple实现：
    - slf4j-simple.jar
- 绑定no-operation：不会使用任何日志实现框架
    - slf4j-nop.jar

# 2.Slf4j日志桥接器(Bridging)
- 在已经有旧的日志框架时使用
- 核心步骤：
    - 去除之前老的日志框架的依赖
    - 添加SLF4j提供的桥接组件
    - 为项目添加SLF4j的具体实现
- 参考地址：https://www.slf4j.org/legacy.html

# 3.Slf4j日志级别及使用场景
1. trace：最低优先级的日志，一般用来追踪详细的程序运行流
2. debug：debug是比trace高一级别的日志，该级别的日志就是用来debug用的
3. info：info记录的是整个系统的运行信息，比如系统运行到了哪一个阶段，到达了哪一个状态
4. warn：warn比info的级别更高，用来记录一些警告信息
5. error：error级别的日志是最高优先级了，用来记录运行时的错误信息，表示程序运行过程中出现了需要被解决的问题，往往是一些异常


