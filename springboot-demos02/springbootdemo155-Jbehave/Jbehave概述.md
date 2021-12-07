# 1.简介
JBehave是一个行为驱动开发(BDD:Behaviour-Driven Development)的开源测试框架

# 2.JBehave 实现五步骤：
1. 书写story文件
2. 匹配step到Java类
3. 配置Stories
4. 运行Stories
5. 观察报告Reports

# 3.JBehave的特点
- 纯Java实现，能调用java API的地方就能使用。
- 能够定义和执行基于文本的Story,让我们能够从用户价值出发进行开发。（BDD都是这个目的）。
- User stories可以放在classpath，也可通过外部URL传进来。
- User stories可以并发执行且能够指定并发执行的线程数。
- 可以通过一些用户定义的信息把User Stories形成一部完整文档。
- 通过Anotation把Story的步骤对应到Java类中，还能够把自动把Story中的String参数转换成方法对应的参数类型。（How？）
- 基于Anotation的运行配置信息，指定Story对应的Steps类文件
- 支持通过第三方IOC容器（Spring，Guice，PicoContainer，Weld）管理配置信息和Steps类
- 支持通过Groovy写配置信息和Steps文件
- 支持报表，既可以生成可读性良好的报表格式（HTML，TXT ），还支持Json，XML格式供外部程序调用。
- 未实现的步骤会自动标记Pending
- 支持任何语言书写Story
- 可以使用Junit或者任何基于anotation的测试框架运行Story测试
- 支持Maven，Ant集成，通过脚本运行BDD测试脚本

# 4.story语法
- Meta：以键值对的方式提供一些关于Story和Scenario的标签信息
- Narrative：对当前Story对应功能的一个描述
- Scenario：关于当前场景的描述
- Given：描述当前场景的Context的Step
- `!--`：注释
- When：描述用户进行操作的Step
- Then：描述验收用户操作结果的Step
- And：Step的辅助描述关键字，跟着哪个Step就表示哪个Step的意思
- GivenStories：在当前Story中依赖另一个Story
- Examples：可以指定一系列的数据反复跑一个Scenario
