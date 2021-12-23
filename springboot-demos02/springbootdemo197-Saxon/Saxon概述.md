# 1.简介
- Saxon 是一个 XSLT 和XQuery处理器。它是使用 XML 文档和样式表作为输入，然后生成结果文档作为输出的程序
- 它还包括了一个串行化器，用于将结果树转换成 XML、HTML 或纯文本。Saxon的功能很强大，其实现了XSLT3.0、XQuery3.0和XPath3.0等规范
- 包含了开源版本`Saxon-HE`和商业版`Saxon-PE`,`Saxon-EE`

# 2.Java API概述
- s9api：首选集成式API，根对象`net.sf.saxon.s9api.Processor`
- JAXP：用于 XSLT，XPath 和 XML模式处理
- XQJ：用于 XQuery
- W3C标准外的扩展：开源版本没有
    - EXSLT 扩展库common、set、math和date-and-times
    - EXPath 模块binary、file和 archive

# 3.接口配置
1. JAXP api的配置
- XSLT：TransformerFactory，BasicTransformerFactory
- XPATH: XPathFactory，
2. s9api配置
- Processor：setConfigurationProperty方法或new Processor(source)
3. XQJ 配置
- XQDataSource：SaxonXQDataSource

# 4.XML处理概述
1. 构建源文档
    - DocumentBuilder：`processor.newDocumentBuilder()`
    - 提供了一系列方法，这些方法从Source对象创建文档：
    - StreamSource：流中构建
    - SAXSource：SAX来源
    - DOMSource：DOM来源
    - StAXSource：STAX来源 等等
2. 编程方式构建XML
    - Sapling Tree：`net.sf.saxon.sapling`
    - Event：`Processor.newPush(destination)`
3. 预加载共享参考文档：Feature.PRE_EVALUATE_DOC_FUNCTION
4. 输入过滤器：
    - 转换为XSLT：XMLFilter
    - 转换为SAX：ContentHandler
5. XML解析器：Saxon 不包含自己的 XML 解析器
    - 使用作为 JDK 的一部分提供的默认 SAX 解析器，基于Xerces

