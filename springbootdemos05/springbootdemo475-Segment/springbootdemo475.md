# 参考文档
segment 基于结巴分词词库实现的更加灵活优雅易用，高性能的 java 分词实现
- https://github.com/houbb/segment

# SegmentResultHandlers 返回形式
- common()	默认实现，返回 ISegmentResult 列表
- word()	只返回分词字符串列表
- wordCount()	key: 分词字符串; value: 分词出现的次数

# SegmentModes 分词模式
|	方法	| 准确度	| 性能 |	备注|
| :----: | :----: | :----: | :----: |
|search()|	高	|一般	|结巴分词的默认模式|
|dict()	|较高	|一般	|和 search 模式类似，但是缺少 HMM 新词预测|
|index()|	一般	|高|	尽可能多的返回词组信息，提高召回率|
|greedyLength()|	一般	|高	|贪心最大长度匹配，对准确度要求不高时可采用|

# SegmentFormats 格式化
- `defaults()`：等价于小写+半角处理。
- `lowerCase()`：小写
- `halfWidth()`：半角
- `chineseSimple()`：用于支持繁体中文分词
- `none()`：无格式化
- `chains(formats)`：链式，自定义格式化

# 其他 SegOtherTest
- 自定义词库
- 词性标注
- 释放资源
