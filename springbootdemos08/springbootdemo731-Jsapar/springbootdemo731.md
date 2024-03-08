# 参考地址
jsapar 一个根据预设模型来解析各种文本文件和CSV文件的Java类库
- https://github.com/org-tigris-jsapar/jsapar

官方文档
- https://org-tigris-jsapar.github.io/jsapar

java9以上环境

# 简介
jsapar java基于Schema的解析器

# 目录
JsaparTest01
- test01：解析CSV
- test02：生成CSV

JsaparTest02
- test01：将CSV转换为固定宽度格式 每个格式使用固定的schema
- test02：csv转换为java bean Lambda表达式方式解析
- test03：csv转换为java bean CollectingConsumer方式解析
- test04：java bean 转 csv 一个一个处理
- test05：java bean 转 csv 集合处理
- test06：转换时进行操作与过滤
  
JsaparTest03
- test01：CSV文件的解析，其中第一个单元格表示要解析的行的类型
- test02：固定宽度文件的解析，其中第一个单元格表示要解析的行的类型
- test03：从固定宽度文件转换为CSV文件，其中第一个单元格表示要转换的行的类型
- test04：空条件解析
- test05：解析带符号csv文件
- test06：生成带符号csv文件
- test07：RFC4180 规范CSV文件解析
- test08：RFC4180 规范CSV文件生成
