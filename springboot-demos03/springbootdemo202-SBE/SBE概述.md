# 1.SBE简介
SBE是 OSI 第 6 层表示，用于编码和解码低延迟金融应用程序的二进制应用程序消息
- Java SBE 实现依赖于 Agrona的缓冲区实现

# 2.SBE编码设计原则
1. 无复制
    - SBE 编解码器不使用任何中间缓冲区来编码或解码消息
    - 有一个限制，即不直接支持大小大于传输缓冲区的消息，需要分段与重组
2. 本机类型映射
    - 将数据编码为底层缓冲区中的本机类型
3. 免分配
    - 对象的分配会导致 CPU 缓存流失，从而降低效率。然后必须收集和删除这些分配的对象
    - SBE 编解码器的设计采用享元模式，无需分配。
4. 流媒体访问
    - SBE 编解码器旨在根据底层缓冲区中位置的向前进展对消息进行编码和解码
5. 字对齐访问
    - 当在非字大小的边界上访问字时，许多 CPU 架构表现出严重的性能问题
    - SBE 模式支持定义消息中字段起始位置的偏移量的概念
6. 向后兼容
    - SBE 中设计了一种扩展机制，它允许在新系统可以使用的消息中引入新的可选字段，而旧系统在升级之前会忽略它们

# 3.SBE Tool
一个命令行工具，用于生成编解码器和验证消息声明模式
- 可基于Maven配置
    - 将Agrona添加到您的项目中
    - 将您的 SBE 模式文件放在您选择的位置（例如src/main/resources/schema.xml）
    - 使用exec-maven-plugin调用SBE工具代码生成器
    - 用于build-helper-maven-plugin在编译类路径中包含生成的目录
    - 执行包含generate-sources阶段的目标（最典型mvn clean install）

# 4.SBE XML
SBE 使用 XML 格式来指定消息、标题和其他元素（详细查看resources下的xml文件）
- 更多示例https://github.com/real-logic/simple-binary-encoding/tree/master/sbe-tool/src/test/resources
- 具体：https://github.com/real-logic/simple-binary-encoding/wiki/FIX-SBE-XML-Primer
- `<messageSchema>`：根元素
- `<types>`：保存创建的各种类型
    - `<type>`：可以通过名称和组合一组内置基本类型来创建类型
    - `<enum>`：包含枚举的有效值
    - `<set>`：包含位集的选择值
        - `<choice>`元素包含在`<set>`中以保存有关值的信息
- `<composite>`：编码类型的结构，编码是按照声明的顺序进行的，内可包含type字段
- `<message>`：包含字段、重复组和可变长度数据
- `<field>`：指定消息的固定大小字段
- `<group>`：组元素指定消息中的重复组
- `<data>`：指定消息的可变长度字段

# 5.Java客户端的使用
1. 首先需要运行mvn clean install使用SBE tool根据demo.xml生成对应的类
    - 生成的类在springbootdemo202-SBE\target\generated-sources\java\uk\co\real_logic\sbe\generated下
2. 生成的帧结构如下(schema)
    - Frame
        - Msg Header
        - Message Body
3. 消息头：包含允许解码器识别应该使用什么编解码器作为消息模板的字段 
    - 要对消息进行编码，必须先对消息头进行编码，然后再对消息进行编码
        - 详见demo CarEncoder.wrapAndApplyHeader方法
    - 解码器应该解码头部，然后查找应该使用哪个模板来解码消息正文(demo71行)
4. 主要都在demo代码中，各种类型字段的编码与解码
    
