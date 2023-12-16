# 参考地址
no-more-tears 使用invokeDynamic将符号的解析推迟到运行时
- https://github.com/kohsuke/no-more-tears
- https://no-more-tears.kohsuke.org/

# 简介
用于不同版本库文件编译，避免LinkageError

两部分组成：
- 一个是类文件转换工具，它用invokedynamic调用替换每个字段/方法引用/调用。
- 第二部分是运行时链接器，它将这些invokedynamic调用“链接”到目标
- 只要使用ConstantCallSite，invokedynamic就不会对执行的代码产生任何运行时变化

# 类简介
- AlreadyUpToDate：指示已转换的类
- Analyzer：语义字节码分析器。此类不会完全检查JSR和RET指令是否有效。
- ClassTransformer：转换类
- DataflowInterpreter：数据流处理
- DefaultLinker：解析为代码中指定的原始目标的链接器
- LazilyLinked：懒解析
- Linker：执行链接
- LinkerBootstrap：Invokedynamic引导程序
- Subroutine：方法子例程（对应于JSR指令）
- ClassAnnotationInjector：添加类注解
