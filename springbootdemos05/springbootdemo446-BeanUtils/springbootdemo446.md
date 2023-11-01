# 参考地址
BeanUtils
- https://github.com/yangtu222/BeanUtils

构建功能最强、性能最好的Java BeanCopy类库
- https://www.jianshu.com/p/9a136ecd3838

# 简介
一款高性能对象拷贝工具

# 配置类注解
- @BeanCopySource(source=FromBean.class)：来源
- @CopyProperty(convertor=DateConvertor.class)：转换器
- @CopyProperty：用在成员bean中
- @CopyCollection(targetClass=ToBean3.class)：成员bean集合
- @CopyProperty(property="beanInt")：变更名称
- @CopyProperty(property="bean2.beanString")：映射到成员bean的属性

