# 1.QDox概述
一款简单，高效的Java源代码解析器，可以提取Java类、接口、方法、参数名称、类型等
- 使用 JFlex 和 BYacc/J 构建
- 解析器浏览源文件，只查找感兴趣的内容，例如类/接口定义、导入语句、JavaDoc 和成员声明，忽略实际方法实现

# 2.使用方法
## 入口
JavaProjectBuilder，它负责解析源代码、解析导入和存储数据
```
JavaProjectBuilder builder =  new  JavaProjectBuilder ();
```

## 读取源文件
```
builder.addSource(new FileReader("MyFile.java"));
builder.addSource(new StringReader("package test; public class Hello {}"));
//在SoueceTree中添加所有 .java 文件（递归）
builder.addSourceTree(new File("mysrcdir"));
```

## 解析类名
- 为了解析使用通配符（例如 import java.util.*）导入的类，ClassLibrary 必须知道项目中使用的其他类
- ClassLibrary 有 4 种解析类的方法：
    - 查看已添加的其他Souce
    - 搜索提供的sourceFolders
    - 查看当前类路径
    - 查看运行时指定的其他类加载器
- 官方示例：
    ```
    JavaProjectBuilder builder = new JavaProjectBuilder();
    builder.addSourceFolder( new File( "src/main/java" ) );
    builder.addSourceFolder( new File( "target/generated-sources/foobar" ) );
    builder.addClassLoader( myCustomClassLoader );
    builder.addClassLoader( new AntClassLoader( getProject(), classpath ) );
    ```

## 3.模型
- JavaSource：代表完整的.java文件集合
- JavaPackage：表示类所在的包
- JavaClass：代表一个Java类或接口
    - JavaField：表示类中的一个字段，包含doclet标签，名称，类型
    - JavaMethod：表示类中的一个方法，包含doclet 标签、名称、返回类型、参数和异常
        - JavaParameter：表示传递给方法的参数，包含名称和类型
- JavaType：表示另一个类（如返回值、超类等）使用的类的特定实例
- DocletTag：代表一个 JavaDoc 标签。每个标签都有一个名称和一个值

# 4.目录
- demo01：JavaSource
- demo02: JavaPackage
- demo03：JavaClass
- demo04: JavaField
- demo05：JavaMethod
- demo06：JavaParameter
- demo07：JavaType
- demo08：DolcetTag