#1. Spring Shell是什么
- Spring Shell是Spring生态中的一员，用于开发命令行应用程序
- Spring Shell构建在JLine之上，集成Bean Validation API实现命令参数校验 
    - JLine3相关：springbootdemo161-Jline3

# 2.相关注解
- `ShellCompent`：标记为spring shell类
- `ShellMethod`：表示一个具体命令
    - key：命令名称
    - value：命令描述
    - prefix：命令参数前缀，默认为`--`
    - group：命令分组
- `@ShellOption`：对命令参数进行定制/可以为命令参数指定多个名称
    - defaultValue属性：默认参数值
    - arity属性：参数个数，可以传递数组
- `ShellCommandGroup`：用于指示默认的 shell 命令组，在包或类级别
- `ShellMethodAvailability`：用于自定义用于指示命令可用性的方法的名称

# 3.参数校验
- `@Size`：校验参数长度
- `@Max`：校验最大参数值
- `@Min`：校验参数最小值
- `@Pattern`：支持自定义正则表达式校验规则

# 4.动态命令可用性 Dynamic Command Availability
命令A是否可以执行需要依赖命令B的执行结果
- 方式一：编程方式 Availability.available()
- 方式二：`@ShellMethodAvailability` 为多个命令添加动态命令可用性支持

# 5.命令分组
- Spring Shell管理命令分组有3种实现方式：
    - 默认以类名为组名
    - 使用注解@ShellMethod的group属性指定组名
    - 使用注解@ShellCommandGroup指定组名  
- @ShellCommandGroup 两种使用方式：
    - 直接在Command类上使用@ShellCommandGroup("CMD")
    - 在package-info.java中使用注解@ShellCommandGroup指定整个包下的所有类中的命令为一个组

# 6.内置命令
Built-In Commands
- clear：清空命令行界面
- exit, quit：退出
- help：显示帮助信息
- script：从文件中读取并执行批量命令
- stacktrace：报错时读取异常堆栈信息

# 7.自定义内置命令
1. 禁用所有内置命令：排除spring-shell-standard-commands依赖
2. 禁用某一内置命令：`spring.shell.command.<command>.enabled=false`,启动类中指定

## 覆盖内置命令
实现接口`org.springframework.shell.standard.commands.<Command>.Command`来完成

# 8.自定义命令提示符
通过实现接口org.springframework.shell.jline.PromptProvider定制命令提示符

# 9.自定义命令行选项行为
Spring Shell提供了2个默认的ApplicationRunner，用于实现命令行选项的行为
- InteractiveShellApplicationRunner：用于启动交互式界面，接收用户输入命令
- ScriptShellApplicationRunner：用于在应用启动时从程序参数中读取指定文件中的命令并执行
    - 具体来讲：将多个命令写在文件中，并通过参数的形式将包含了批量命令的文件路径传递给程序，传递的文件路径参数必须以“@”开始
    - `$ java -jar /home/test/sun/workspace/test-springshell/target/test-springshell-0.0.1-SNAPSHOT.jar @/home/test/cmd`

定义其他的命令行选项行为：实现接口`org.springframework.boot.ApplicationRunner`

# 10.自定义参数转换器
- 默认情况下，Spring Shell使用标准的Spring类型转换机制将命令行的文本参数转换为指定的类型
- 实际上，Spring Shell是通过`DefaultConversionService`注册Converter<S, T>，GenericConverter或者ConverterFactory<S, R>类型的Bean对象来实现对命令行参数进行类型转换的
- 自定义转换器：实现`org.springframework.core.convert.converter.Converter<S, T>`

