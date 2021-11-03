# 参考文档
PROGUARD基于JDK1.8加SPRINGBOOT加MAVEN加MYBATIS的代码混淆
- https://blog.csdn.net/caicai1171523597/article/details/88054446

Java反编译工具-JD-GUI-简单好用
- https://blog.csdn.net/caicai1171523597/article/details/88054446


# proguard四大功能
- 压缩(Shrink)：检测并移除代码中无用的类、字段、方法和特性（Attribute）。
- 优化(Optimize)：对字节码进行优化，移除无用的指令。
- 混淆(Obfuscate)：使用a，b，c，d这样简短而无意义的名称，对类、字段和方法进行重命名。
- 预检(Preveirfy)：在Java平台上对处理后的代码进行预检，确保加载的class文件是可执行的