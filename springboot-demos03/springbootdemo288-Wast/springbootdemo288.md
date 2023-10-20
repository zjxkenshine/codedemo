# 参考地址
Github
- https://github.com/wycst/wast

## JsonNode
- 1、支持对大文本json的懒加载解析功能，即访问时解析，当需要读取一个大文本json中一个或多个属性值时非常有用。
- 2、支持按需解析；
- 3、支持上下文查找；
- 4、支持在大文本json中提取部分内容作为解析上下文结果,使用JSONNode.from(source, path, lazy?)
- 5、支持对节点的属性修改，删除等，节点的JSON反向序列化；
- 6、支持直接提取功能(v0.0.2+支持)，参考JSONPath；

## 目录
- config：整合spring
- el:：表达式引擎测试
- json：json测试
- yaml：yaml读取测试
- jdbc: 见官网
