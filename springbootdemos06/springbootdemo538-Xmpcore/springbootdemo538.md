# 参考地址
adobe官网
- https://www.adobe.com/devnet/xmp.html

什么是XMP？?
- http://www.mobiletrain.org/about/BBS/208283.html
  
xmp规范
- https://github.com/adobe/xmp-docs/tree/master/XMPSpecifications

xmpcore源码
- https://github.com/adobe/XMP-Toolkit-SDK
- https://github.com/drewnoakes/adobe-xmp-core

Metadata-Extractor源码
- https://github.com/drewnoakes/metadata-extractor/tree/master/Source/com/drew/metadata/xmp

RDF 教程
- https://www.runoob.com/rdf/rdf-tutorial.html

# 简介
XMP是一种可扩展的元数据平台，它允许用户在文档和媒体文件中添加自定义的元数据信息，以描述文件的内容和属性。
XMP最初由Adobe推出，它采用XML格式存储元数据，可以方便地嵌入到不同类型的文件中，如图片、音频、视频、PDF文档等。
后来，XMP被提交给ISO（国际标准化组织）并得到ISO标准化，成为ISO 16684-1标准。

# 组成
- impl包：xmpcore核心实现类
    - xpath包：xmpath是XPath的简化形式，仅用于在XMPMeta对象中创建或检索属性
- options：用于配置xmpcore的各种函数调用
    - PropertyOptions——这些选项用于创建属性，也用于检索关于简单、数组或结构属性的信息，以及限定符
    - ParseOptions—用于配置xmp元数据数据包的解析
    - SerializationOptions—用于控制xmp元数据数据包的序列化
    - IteratorOptions——用来设置一个XMPIterator
    - Options：基本接口
- properties：属性包
- xmp：基本接口包
    - XMPConst：XMP Toolkit的常用常量。
    - XMPDateTime：日期格式
    - XMPDateTimeFactory：XMPDateTime工厂
    - XMPError：错误接口
    - XMPException：异常
    - XMPIterator：XMPMeta迭代器
    - XMPMeta：该类将XMP元数据集表示为DOM表示，可以读取或修改所有属性
    - XMPMetaFactory
    - XMPPathFactory：元数据对象的实用程序服务
        ```
            String path = XMPPathFactory.composeStructFieldPath (schemaNS, <Struct>, fieldNS,<Array>);
            String path += XMPPathFactory.composeArrayItemPath (schemaNS, <Array>, index);
            PropertyInteger result = xmpObj.getPropertyAsInteger(schemaNS, path);
        ```
    - XMPSchemaRegistry：模式注册中心跟踪XMP metadata中使用的所有名称空间和别名
    - XMPUtils：实用工具
        - catenateArrayItems：从字符串数组中创建单个编辑字符串
        - separateArrayItems：将单个编辑字符串分隔为字符串数组
        - removeProperties：从一个XMP对象中删除多个属性。
        - appendProperties：添加属性
        - convertToBoolean：String转bool
        - convertFromBoolean：bool转String
        - packageForJPEG：创建适合于JPEG文件的XMP序列化。
        - mergeFromJPEG：合并从JPEG文件检索到的标准XMP和扩展XMP
        - applyTemplate：根据模板对象修改工作的XMP对象
        - duplicateSubtree：将一个XMP对象的子树复制到另一个XMP对象

# XMP规范
## 数据格式
- Simple values：简单数据格式
- Structure values：结构数据
- Array values：数组数据

## 标签
- x:xmpmeta
    ```
    <x:xmpmeta xmlns:x="adobe:ns:meta/">
        <rdf:RDF xmlns:rdf= ...>
            ...
        </rdf:RDF>
    </x:xmpmeta>
    ```

- rdf:RDF  外层标签
- rdf:Description  描述标签，可包含多个  包含rdf:about=""属性
- xmp:Rating
- xmp:BaseURL：URL
- rdf:Bag：无需数组
- rdf:Seq：有序数组
- rdf:Alt：可选数组
- rdf:li：列表项
- xml:lang：语言
- rdf:value：值

  