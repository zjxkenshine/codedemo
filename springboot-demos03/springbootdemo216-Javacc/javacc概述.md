# 1.javacc概述
- JavaCC 是用于 Java 应用程序的最流行的解析器生成器
- 解析器生成器是一种读取语法规范并将其转换为可以识别语法匹配项的 Java 程序的工具
- 使用递归下降语法解析，LL(k)。 其中，第一个L表示从左到右扫描输入； 第二个L表示每次都进行最左推导(在推导语法树的过程中每次都替换句型中最左的非终结符为终结符。类似还有最右推导)； k表示的是每次向前探索(lookahead)k个终结符

# 2.主要功能
- JavaCC用来处理语法文件（jj）生成解析代码
- JJTree 用来处理jjt文件，生成树节点代码和jj文件
- JJDoc 根据jj文件，生成文本文件(Html)

## 3.语法（jj文件）
1. 结构(四部分组成)：
    - option参数配置
    - 程序入口
    - 词法声明
    - 语法声明和动作代码
2. option:
    - 语法分析器的配置选项，每一个选项都有默认值，因此省略也没有问题
    - 如前面的token的个数（用来解除冲突）
    - 可以作为选项传递给javacc
3. 程序入口：主要部分
    - 开始标志符：PARSER_BEGIN(name)
    - 结束标识符：PARSER_END(name)
    - 解析器name和中间class的名称一样
4. 词法声明：
    - 这里面有四类：SKIP、TOKEN、SPECIAL_TOKEN、MORE，SKIP用来说明被忽略的串
5. 示例：
```
options {
    JavaCC的选项
}

PARSER_BEGIN(解析器类名)
package 包名;
import 库名;

public class 解析器类名 {
    任意的Java代码
}
PARSER_END(解析器类名)

扫描器的描述

解析器的描述
```

# 4.使用步骤（.jj文件）
- IDEA安装javacc插件
- 安装javacc maven插件
- 编写.jj文件
- 执行maven compiler生成代码

# 5.生成的文件概述：
- Adder：解释器入口
- SimpleCharStream：词法分析器输入流
- AdderConstants：Token常量,SKIP TOKEN 和TOKEN
- AdderTokenManager：词法分析器
- Token：Token类
- ParseException：语法解析异常
- TokenMgrError：语法错误提示
    
