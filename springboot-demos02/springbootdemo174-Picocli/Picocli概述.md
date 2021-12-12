# 1.Picocli概述
- picocli是一个强大的小命令行界面，使用简单功能丰富，可以使用注解方式开发命令行工具
- 带有一个注解处理器，可以在编译期间自动启用 Graal jar

# 2.简单使用步骤
1. 创建一个实现Runnableor的类Callable。这是你的命令。
2. 用 注释该类@Command并为其命名。该mixinStandardHelpOptions属性增加--help，并--version选择您的应用程序。
3. 对于应用程序中的每个选项，将@Option字段添加到您的命令类。这个例子展示了如何给选项名称和描述，还有许多其他属性。
4. 对于每个位置参数，将@Parameters字段添加到您的命令类。
5. Picocli 会将命令行参数转换为强类型值，并将这些值注入带注释的字段。
6. 在类的runorcall方法中定义业务逻辑。解析成功后调用该方法。
7. 在main您的类的方法中，使用CommandLine.execute方法引导您的应用程序。这将解析命令行、处理错误、处理使用和版本帮助请求，并调用业务逻辑。
8. 该CommandLine.execute方法返回退出代码。您的应用程序可以System.exit使用此退出代码进行调用，以向调用进程发出成功或失败的信号。

# 3.概要文档（https://picocli.info/quick-guide.html）
1. 选项与参数：命令行参数可以分为选项和位置参数,选项有一个名称，位置参数通常是选项后面的值(多个)
    - 选项示例：`-out=file.txt`,注解`@Option`定义
    - 位置参数示例：`-add 1 2 5 8 ...`,注解`@Paramters`定义，使用（从零开始的）index属性来准确指定要捕获的参数
    - 交互式（密码）选项：interactive选项，java1.6以上不会回显
2. 强类型
    - 类型转换：将命令行参数字符串转换为多种常见数据类型
       - 可以自定义类型转换器，实现ITypeConverter接口
    - 集合与Map：Map只要为键和值类型注册了类型转换器，字段的键和值就可以有任何类型
        ```
        @Option(names = {"-u", "--timeUnit"});
        Map<java.util.concurrent.TimeUnit, Long> timeout;
        ```
3. 必需参数
    - 必须选项：`@Option(names = "-n", required = true, description = "...")`
    - 所需位置参数：`@Parameters(arity = "1..*", descriptions = "at least one File")`
4. 多个值：
    - 重复选项：`<命令> -option 111 -option 222 -option 333`
        ```
        @Option(names = "-option")
        int[] values;
        ```
    - 拆分正则表达式：`-选项 111,222,333`
        - `@Option(names = "-option", split = ",")`
    - 数量：arity属性可让您准确控制每个选项出现要消耗的参数数量
        - `@Parameters(arity = "1..3", descriptions = "one to three Files")`
        - `@Option(names = "-f", arity = "2", description = "exactly two floating point numbers")`
    - 如果没有arity指定，参数的数量取决于字段的类型
5. 帮助选项
    - Mixin 标准帮助选项：
        - mixinStandardHelpOptions=true，添加-h和-v参数
    - 自定义帮助选项：两种方式
        - `@Option(versionHelp = true...)`：CommandLine.isVersionHelpRequested()会返回true
        - `@Option(usageHelp = true...)`：CommandLine.isUsageHelpRequested()会返回true
6. 版本信息
    - 静态版本信息：`@Command(version = "1.0")
        - 可以指定多个字符并使用ANSI：`@Command(version = {"@|yellow Versioned Command 1.0|@","@|blue Build 12345|@","@|red,bg(white) (c) 2017|@" })`
    - 动态版本信息：@Command的versionProvider提供一个IVersionProvider实现
7. 使用帮助信息（元素）
    - `name`：命令名称
    - `paramLabel`：选项值的解释
    - `sortOptions = false`：@Command属性，按声明顺序，默认按字母顺序
    - `abbreviateSynopsis = true`：@command属性，复杂命令省略部分说明
    - `@Command(synopsisHeading = "", customSynopsis = {自定义概要}`：自定义概要
    - `header`与`footer`：@command属性，页眉和页脚
    - `xxxHeading`：@command属性，章节标题
    - `separator`：@command属性，分隔符
    - `hidden=true`：不显示帮助信息
    - `{DEFAULT-VALUE}`：嵌入默认值
    - `requiredOptionMarker`：在选项列表中标记必需的选项
    - `picocli.usage.width`：指定自定义宽度
8. ANSI 颜色和样式
    - 样式和颜色的使用帮助：`@Command(description = "Custom @|bold,underline styles|@ and @|fg(red) colors|@.")`
    - AISI开关
        - 系统属性设置`picocli.ansi=true`开启，false关闭
        - CommandLine.usage中使用Ansi.ON或Ansi.OFF可以覆盖：`App app = CommandLine.usage(new App(), System.out, Ansi.OFF, args);`
9. 子命令：https://picocli.info/quick-guide.html#_subcommands
    - 注册子命令
        - 编程方式：CommandLine.addSubcommand
        - 注解方式：@Command的subcommands属性，且必须要有name属性
    - 解析子命令：`CommandLine.parse`
    - 子命令的使用帮助：`commandLine.usage`
    - 隐藏的子命令：`hidden=true`
10. 重用
    - picocli 支持子类化和`@Mixin`作为重用这些选项和属性的方法
11. 执行命令
    - Commandline.execute
        - 如：`new CommandLine(new MyApp()).execute(args);`
    - 退出：`System.exit(exitCode);`
    - 生成退出代码：实现callable或者返回值为int或Integer方法上加上`@Command`注解
    - 异常退出代码：`exitCodeOnInvalidInput`属性和`exitCodeOnExecutionException`属性
    - 执行配置
    - 处理错误：
        - 无效时：IParameterExceptionHandler
        - 异常时：IExecutionExceptionHandler
    - 迁移：picocli的旧版本的run，call，invoke和parseWithHandlers方法类似execute，4.0版本后弃用
12. 追踪
    - `picocli.trace`：设置追踪级别, OFF，WARN，INFO，DEBUG
13. 标签自动完成：命令行补全
    - 会自动生成
        
    
            
    