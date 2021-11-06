# 1.FreeMarker概述
1. 数据模型
模板 + 数据模型 = 输出
2. FTL结构
FreeMarker模板实际上是用FTL的语言编写的程序,由以下部分组成:
    - 文本：文本会原样输出
    - 插值：在输出中会被替换成计算值。插值是由`${`和`}`（或`#{`和`}`，不推荐`）`来分隔
    - FTL标签：FTL标签有点类似于HTML标签，不会被打印输出
    - 注释：由`<#--和-->`来分隔
    
# 2.常用指令
- assign：创建一个新的变量，或替换一个已经存在的变量，只有顶级变量可以被创建或替换
- attempt、recover: 页面某一部分输出失败，也可以让页面成功输出
- compress：去除多余的空白
- escape、noescape: escape指令中出现的插值会和转义表达式自动结合，noescape指令关闭转义
- autoesc、noautoesc：自动转义开启与关闭
    - 可以在ftl头中为整个模板禁用auto-escaping。然后用autoesc指令在某个部分重新启用它。
    - noautoesc指令可以嵌套在autoesc指令中使用，以重新禁用auto-escaping功能
- ftl：告诉FreeMarker和其他工具关于模板的信息，最高优先级，存在必须第一句
    - attributes：关联模板任意属性（名-值对）的哈希表
    - auto_esc：开启或关闭auto-escaping
    - encoding：指定编码方式
    - output_format：指定模板的输出格式
    - strict_syntax：开启或关闭"strict syntax"
    - strip_text：开启则模板被解析时模板中所有顶级文本被移除
    - strip_whitespace：
- function、return：定义一个函数
- global：创建在所有命名空间中都可见的变量
- if、else、elseif：条件判断是否跳过模板的某个部分
- import：导入一个库并创建新的命名空间,模板用变量（macro、function等）填充该命名空间
- include: 在模板中插入另一个FreeMarker模板文件, 被包含的文件和包含它的模板共享变量
    - encoding: 字符集
    - parse：默认true，则包含的文件将被解析为FTL
    - ignore_missing：当为true时，模板引用为空时压制错误，默认false
- list、else、items、sep、break、continue：对其第一个参数指定的序列（或集合）中的每个值执行list开始标签和list结束标签之间的代码
- macro、nested、return：
    - macro指令在当前命名空间中创建一个宏（macro）变量
    - nested指令执行自定义指令开始和结束标签中间的模板片段
    - 使用return指令可以将宏或函数定义体停留在任何位置
- switch、case、default、break: 选择

# 4.表达式
- 直接指定值
- 检索变量
    - 顶层变量：`${user}`
    - 从哈希表中检索数据：`book.title`或`book["title"]`
    - 从序列中检索数据：只能使用方括号语法形式`users[0].id`
    - 特殊变量：FreeMarker引擎本身定义的，`.variable_name`方式读取
- 字符串操作：
    - 插值和连接：`${}`
    - 获取字符：`str[0]`
    - 字符串切分
- 序列操作：
    - 序列连接：可以使用+号来连接序列
    - 序列切分：使用`seq[range]`（seq是序列，range是值域）
- 哈希表操作:可以使用+号来连接哈希表
- 运算符
- 不存在的值
    - 默认值操作符
    - 不存在值检测操作符
    
# 5.内建函数
- 字符串内建函数
- 数字内建函数
- 日期内建函数
- 布尔值内建函数
- 哈希内建函数
- 序列内建函数
