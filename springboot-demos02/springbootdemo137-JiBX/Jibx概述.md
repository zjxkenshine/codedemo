# 1.JiBX简介
- Jibx是一款优秀的实现java对象和XML相互绑定的框架，功能类似JAXB，效率是Xstream的3倍
- JiBX使用绑定文挡(binding definition document)来定义XML与Java对象转换的规则，这个文挡就是联系XML与Java对象之间的桥梁
- 官网：http://jibx.sourceforge.net

# 2.JiBX的使用过程分成两步：
1. 第一步是Binding Compiler，这是一个前期准备过程，包括定义绑定文挡，定义与XML绑定在一起的Java对象，然后编译生成中间操作类
2. 第二步是Runtime，使用Binding Compiler编译好的中间操作类处理XML和Java对象的转换；如果需要修改映射需要重新生成中间类

绑定文档可以自己编写(绑定文档的规则介绍详见:http://jibx.sourceforge.net/binding/xml-summary.html)，也可以通过JiBX提供的工具来生成：
- `java -cp ../../lib/jibx-tools.jar:bin org.jibx.binding.generator.BindGen org.jibx.starter1.Order`

# 3.操作
1. 先执行maven-compile生成JiBX*.class类
2. 使用这些类进行转换