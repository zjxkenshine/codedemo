# 1. 解析代码 Test01
解析代码生成AST语法树
- 默认格式打印
- XML格式打印
- 输出为dot文件
- dot文件转png（使用graphviz)
`D:\Program1\Graphviz\bin\dot -Tpng -o ast.png ast.dot`
  
# 2.JavaParser与staticJavaParser Test02
StaticJavaParser
- StaticJavaParser的parse、parseResource方法
- parseExpression解析表达式
- parseJavadoc：解析JavadocComment节点
- 解析配置示例：
    - StaticJavaParser.getConfiguration().setAttributeComments(false);

javaparser使用方式
- parse：解析
- ParseResult：解析结果
- Provider：输入类型
- JavadocParser：解析doc
- ParserConfiguration:解析配置

# 3.SourceRoot 一次性分析整个项目 Test03
- SourceRoot：解析整个项目java源代码
- ProjectRoot：路径封装
- ParserCollectionStrategy：仅解析代码路径
- SymbolSolverCollectionStrategy：符号路径

# 4.简单使用示例
遍历java类两种方式
- NodeIterator
- visitor

示例：
- ListClassesExample：遍历类
- StatementsLinesExample：输出所有代码体及行号
- MethodCallsExample：输出方法调用及行号

# 5.AstObserver AST变动检测 ObserverTest
AstObserver接收节点和节点列表上的更改
- 两种类型：ADDITION,REMOVAL
- propertyChange：属性变动
- parentChange：父节点变动
- listChange：列表变动

- 子类PropagatingAstObserver
- 观察者模式：
  - JUST_THIS_NODE 仅此节点上发生的更改进行通知
  - THIS_NODE_AND_EXISTING_DESCENDANTS 通知此节点及其在注册观察者时存在的所有子节点上发生的更改 之后添加的节点不会通知
  - SELF_PROPAGATING 通知此节点及其所有子节点上发生的更改，之后添加的会自动注册观察
  
# 6.javaParser实现词法保留 lexical包
- 1.设置LexicalPreservingPrinter
- 2.更改AST
- 3.使用LexicalPreservingPrinter生成代码

# 7.JavaParser字符串生成
- Node.toString / PrettyPrinter：最常见的打印
  - PrettyPrinterConfiguration：配置
- asString：没有注释输出
- ConcreteSyntaxModel.genericPrettyPrint：与PrettyPrintVisitor输出相同
- getDeclarationAsString：不常用，声明的字符串表示
- LexicalPreservingPrinter：打印的源代码尽可能靠近解析的源代码



