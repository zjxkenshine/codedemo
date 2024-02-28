# 参考地址
Jodd-Lagarto 高效，灵活的通用HTML解析器
- https://lagarto.jodd.org/

# 目录
LagartoParserTest：HTML解析测试
- test01：解析HTML
- test02：Lagarto配置
- test03：适配器与Writer

LagartoDOMTest：HTML解析为DOM
- test01：HTML转DOM

JerryTest：java jquery实现
- test01：简单使用
- test02：Css处理
- test03：选择器

CSSellyTest：CSS选择器支持
- test01：简单使用
- test02：自定义伪类扩展
- test03：自定义伪方法扩展

# 简介
## LagartoParser
快速的事件驱动的HTML解析器

事件：
- start() & end()
- text(CharSequence)：对纯文本块调用的回调
- comment(CharSequence)：对HTML注释调用
- tag(Tag)：回调html的标签
- script(Tag, CharSequence)：script标签
- doctype(Doctype)：doctype标签
- xml() and cdata()：在解析XML内容时，这两个回调是为特定于XML的标记调用的
- error(String)：错误回调

配置：
- calculatePosition：默认关闭，切换元素位置的计算。位置由行号、近似列号和文件中的总偏移量组成
- enableConditionalComments：启用后，LagartoParser将检测IE条件注释
- caseSensitive：启用后，各种匹配将区分大小写。不应用于解析HTML内容。
- parseXmlTags：启用后可解析XML特有标签
- enableRawTextModes：默认情况下启用，告诉LagartoParser对所有所谓的“原始”文本标记进行特殊处理
- textBufferSize：默认1024。它是用于收集所有文本块的内部文本缓冲区的大小

## LagartoDom
HTML解析到DOM树

解析模式
- enableHtmlMode()
- enableXhtmlMode()
- enableXmlMode()
- enableHtmlPlusMode()：支持HTML5
- enableDebugMode()

配置：
- ignoreWhitespacesBetweenTags：XML模式，忽略两个开始或两个结束标记之间的所有空白内容
- ignoreComments：忽略注释
- enabledVoidTags：忽略空标签
- selfCloseVoidTags：当一个元素是void元素时，该标志定义它是否可以是自封闭的
- impliedEndTags：启用隐式结束标记的规则
- condCommentIEVersion：条件注释的版本
- errorLogger & debugLogger：日志

## CSSelly
CSSelly默认支持的选择器：
- *：所有
- E：元素E
- E[foo]：包含foo属性的E元素
- E[foo="bar"]：属性值为bar
- E[foo~="bar"]：其中一个属性值为bar
- E[foo^="bar"]：属性为bar开头
- E[foo$="bar"]：属性以bar结尾
- E[foo*="bar"]：属性包含bar
- E[foo|="en"]：其“foo”属性有一个以连字符分隔的值列表，从左起以“en”开头
- E:root：根E元素
- E:nth-child(n)：第几个子元素
- E:nth-last-child(n)：倒数第几个子元素
- E:nth-of-type(n)：第n个同级元素
- E:nth-last-of-type(n)：倒数第n个同级元素
- E:first-child：第1个子元素
- E:last-child：最后一个子元素
- E:first-of-type：第一个同级元素
- E:last-of-type：最后一个同级元素
- E:only-child：唯一子元素
- E:only-of-type：唯一同级元素
- E:empty：没有子元素
- E#myid：id
- E F
- E > F
- E + F
- E ~ F

其余需要实现伪类或伪方法实现
```
:first
:last
:button
:checkbox
:file
:header
:image
:input
:parent
:password
:radio
:reset
:selected
:checked
:submit
:text
:even
:odd
:eq(n)
:gt(n)
:lt(n)
:contains(text)
```