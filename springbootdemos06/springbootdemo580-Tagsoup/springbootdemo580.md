# 参考地址
github
- https://github.com/fansu/tagsoup
  
官网
- https://www.ccil.org/

TagSoup开发指南
- https://blog.csdn.net/iteye_7356/article/details/82071981

支付宝中有使用

# 目录
- test01：命令行方式转换
- test02：parser方式

# 核心类
- Parser：SAX型的解析器
- PYXScanner：读取解析后的内容
- XMLWriter：HTML解析成XML文档的默认实现

# 步骤
1. 创建Parser实例；
2. 提供自己的SAX2内容处理器
3. 提供只想需要解析的HTML的InputSource实例；
4. 开始解析
