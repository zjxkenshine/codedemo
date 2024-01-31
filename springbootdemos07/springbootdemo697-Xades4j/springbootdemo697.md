# 参考地址
xades4j 用于XAdES签名服务的Java库
- https://github.com/luisgoncalves/xades4j
- https://github.com/luisgoncalves/xades4j/wiki/Principles

# xades签名简介
XAdES是由W3C推出的一种基于 XML的高级电子签名标 准。它采用了一系列的技术和机制，
可以确保签名的可验证性和完整性。 XAdES标准支持多种签名形式，如基于密码学算法的签名、
服务器端签名等。同时，XAdES还提供了时间戳和证书链等功能，增加了签名的可信度和溯源性

# xades4j简介
## 1.原理
- xades4j旨在将开发人员从内部处理的签名XML结构和处理规则中抽象出来
- xades4j抽象级别导致需要额外的服务，如获得消息摘要引擎
- 在XAdES4j中，用于签名生成的输入被分类为两组
    - 第一个包括签名属性、密码参数和密钥信息，其中包含签名者/签名的特征
    - 第二组由签名的数据对象及其属性组成，它们定义了要签名的资源。
    
## 2.签名生成
XAdES4j支持以四种主要XAdES形式（XAdES-BES、XAdES-EPES、XAdES-T和XAdES-C）中的任何一种形式生成签名。
- 创建签名者：XadesSigningProfile创建
- 定义签名资源：
    - DataObjectReference:相同的文档或外部URI引用
    - EnvelopedXmlObject:将添加到符号中的Object元素的内容
    - AnonymousDataObjectReference:没有URI属性的引用
    - EnvelopedManifest:嵌入式Manifest
- 在配置签名者并定义签名的数据对象之后，可以进行签名

## 3.签名校验
SignatureVerification
- CertificateValidationProvider
- XadesVerificationProfile