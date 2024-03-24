# 参考地址
Java 操作 XML(14)--jackson-dataformat-xml 使用
- https://www.cnblogs.com/wuyongyin/p/16553478.html

# xml相关注解
- @JacksonXmlProperty：可以用在bean的任何字段上，控制渲染元素的一些细节属性。通过该注解可以设置命名控件、本地名称、是否被序列化为元素或属性
- @JacksonXmlRootElement：文档的根元素。可设定命名空间和本地名称，不会序列化
- @JacksonXmlText：普通文本
- @JacksonXmlCData：@JacksonXmlCData注解表示其内容不被xml解析，一般和@JacksonXmlText一起使用。
- @JacksonXmlElementWrapper：其能够让集合属性决定是否使用包装元素，并且也可以控制包装元素的本地名称和命名空间

# 目录
- test01：写XML
- test02：读XML
- test03：jackson通用注解
- test04：@JacksonXmlProperty 控制渲染元素的一些细节属性
- test05：@JacksonXmlRootElement 根元素处理
- test06：@JacksonXmlCData 注释/@JacksonXmlText 文本
- test07：@JacksonXmlElementWrapper 包装元素