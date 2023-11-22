# 参考地址
官网 soot 分析与优化java应用
- https://soot-oss.github.io/soot/
- https://github.com/soot-oss/soot
- https://github.com/soot-oss/soot/wiki

# 简介
Soot是一个Java优化框架。它为分析和转换Java字节码提供了四种中间表示：
- Baf：字节码的流线型表示，易于操作
- Jimple:适合于优化的类型化的3地址中间表示。
- simple: Jimple的SSA变体。
- Grimp: Jimple的聚合版本，适合反编译和代码检查。

Soot提供以下分析
- Call-graph 调用图
- Points-to analysis
- 定义/使用链
- 模板驱动的过程内数据流分析
- 混联可以使用流、字段、上下文敏感的需求驱动的指针分析来解决
- 结合FlowDroid或IDEal进行污染分析

# 作为编译框架基本使用
## 创建类 Test01_Create
- loadClassAndSupport：加载类
- SootClass：类
- SootMethod：方法
- body：方法体
    - JimpleBody，ShimpleBody，BafBody，GrimpBody
    - Body三个组成：
        - Local链：body中的局部变量列表
        - Trap：捕获异常
        - Unit：语句本身
    
## 添加属性到class文件
- soot.tagkit包，定义原数据功能，包含host与tag
- TagAggregator：将语句上的Tags转换为可以在类文件中写出来的代码属性




