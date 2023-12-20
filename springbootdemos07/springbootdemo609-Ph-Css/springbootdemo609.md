# 参考地址
ph-css 高级Java CSS 3解析器和生成器
- https://github.com/phax/ph-css

利用ph-css解析css
- https://blog.csdn.net/baidu_39373401/article/details/107378181

# 名词介绍
```css
#div1{
    background-image:url('1.png');
    height:100px;
    width:100px;
}
#div2{
    background-image:url('2.png');
    height:100px;
    width:100px;
}
```
- styleSheet：以上css文本全部内容
- rule：每个选择器中的内容`#div1{...}`
- declaration：每个样式声明:`background-image:url('1.png')`
- expression：每个样式内容`url('1.png')`

# 目录
- test01：从String读取
- test02：从文件中读取
- test03：遍历rule
- test04：替换css内容
- test05：CSSShortHandDescriptor 快速属性处理
- test06：从HTML中读取
- test07：CSS文件写

# 基本类
### Rule：
- (@import) `CSSImportRule`
- (@namespace) `CSSNamespaceRule`
- (div{color:red;}) `CSSStyleRule`
- (@page) `CSSPageRule`
- (@media) `CSSMediaRule`
- (@font-face) `CSSFontFaceRule`
- (@keyframes) `CSSKeyframesRule`
- (@viewport) `CSSViewportRule`
- (@supports) `CSSSupportsRule`
- (@foo) `CSSUnknownRule`

### CSSReader：CSS阅读器
- CSSReader：读取完整的CSS文件，结果是CascadingStyleSheet
- CSSReaderDeclarationList：读取HTML中样式信息，结果是CSSDeclarationList

### ErrorHandler：可恢复错误
- ICSSParseErrorHandler
- DoNothingCSParseErrorHandler：忽略
- LoggingCSSParseErrorHandler：打印 
- ThrowingCSSParseErrorHandler：抛出异常
- CollectingCSSParseErrorHandler：收集的CSSParseError列表
- 支持装饰器模式

### Errors：不可恢复错误
- ICSSParseExceptionCallback
- DoNothingCSSParseExceptionHandler：无操作
- LoggingCSSParseExceptionHandler：打印

### CSS 迭代/遍历
- ICSSVisitor
- CSSVisitor
- ICSSUrlVisitor 
- DefaultCSSUrlVisitor

### CSS 写
- CSSWriter
- CSSWriterSettings
- ICSSWriteable
- writeCSS方法

### Data URL处理
- CSSDataURLHelper
- parseDataURL(String)方法

### 简写属性处理 shorthand类
- CSSShortHandDescriptor
    ```
    background
    font
    border
    border-top
    border-right
    border-bottom
    border-left
    border-width
    border-style
    border-color
    margin
    padding
    outline
    list-style
    ```
- CSSShortHandRegistry：自定义简写处理

### Css工具：
- CSSColorHelper：包含读取和写入不同类型的CSS颜色值
- ECSSColor：包含作为枚举的基本CSS颜色
- ECSSUnit：所有默认的CSS单元，px,em
- CSSNumberHelper：用于处理数值和单位组合的方法
- CSSRectHelper：处理CSS响应式的方法
- MediaQueryTools：在一个或多个媒体查询中包装完整级联样式表的快捷方法