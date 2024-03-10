# 参考地址
BeanIO 3，一个Java库，用于从XML、CSV、分隔和固定长度流格式编组和反编组bean对象
- https://github.com/beanio/beanio

官网
- https://beanio.github.io/

# 简介
## 核心概念
- BeanReader：从流中读取bean
- BeanWriter：用于将bean对象写入输出流
- Unmarshaller：用于从String记录中解组bean对象
- Marshaller：用于将bean对象封送到String记录中
- Mapping Files：BeanIO使用映射文件的XML配置文件将流布局绑定到bean对象，可以一对多绑定
- StreamFactory：加载mapping文件，创建其他对象
- BeanIOException：运行时异常，无需显示捕获
    - exception.getRecordContext()：获取详细信息
    
## Stream组件(.xml文件，mapping.xsd中可以找到对应描述)
- Streams：流布局，可以一对多 `<stream name="..." format="csv"... >`
  - CSV Streams：CVS流
  - Delimited Streams
  - Fixed Length Streams
  - XML Streams
- Records：记录`<record name="record1" class="map">`
    - 记录类型:` <field name="recordType" rid="true" literal="Detail" />`
    - order：记录排序
    - group：分组
    - minOccurs/maxOccurs
- Fields：`<field name="lastName" position="1" />`
    - field自动类型转换
    - format属性格式化
    - TypeHandler接口，自定义类型转换，typeHandler属性指定
    - 重复字段collection属性：`<field name="accounts" type="int" collection="list" minOccurs="0" maxOccurs="unbounded" />`
    - length属性：设置长度
- Constants：property属性设置常量
    - `<property name="recordType" value="employee" />`
- Segments：嵌套bean,segment
  - 重复segment：`<segment name="addressList" collection="list" minOccurs="1" maxOccurs="unbounded" class="example.Address">`
  - 内联Map：`<segment name="userMap" collection="map" key="id" value="lastName"
    minOccurs="1" maxOccurs="unbounded">`
- Stream Validation：
  - InvalidRecordException
  - 校验异常处理：BeanReader.setErrorHandler：BeanReaderErrorHandlerSupport
  ```
    <typeHandler type="java.util.Date" class="org.beanio.types.DateTypeHandler">
      <property name="pattern" value="MMddyyyy" />
    </typeHandler>
  ```
- Templates:
  ```
     <template name="address">
        <field name="street1" />
     </template>
    <include template="address"/>
  ```

## StreamBuilder与注解
可以简化xml配置

# 目录
BeanioTest：使用示例
- test01：从CSV中读取
- test02：写入CSV
- test03：写入嵌套bean
- test04：读取嵌套bean
- test05：读取xml
- test06：StreamBuilder 构建stream对象
- test07：注解，StreamBuilder方式
- test08：注解，xml方式
- test09：表头表尾