# 参考地址
github
- https://github.com/houbb/opencc4j

# 核心方法
    1	toSimple(String)	转为简体
    2	toTraditional(String)	转为繁体
    3	simpleList(String)	返回包含的简体列表
    4	traditionalList(String)	返回包含的繁体列表
    5	toSimple(char)	返回单个汉字对应的所有简体字列表
    6	toTraditional(char)	返回单个汉字对应的所有繁体字列表
    7	isSimple(String)	是否全部为简体
    8	isSimple(char)	单个字符是否为简体
    9	containsSimple(String)	字符中是否为包含简体
    10	isTraditional(String)	是否全部为繁体
    11	isTraditional(char)	单个字符是否为繁体
    12	containsTraditional(String)	字符中是否为包含繁体
    13	isChinese(String)	是否全部为中文
    14	isChinese(char)	单个字符是否为中文
    15	containsChinese(char)	字符串中是否包含中文

# 初始化
```
ZhConvertBootstrap.newInstance()
    # 分词
    .segment(Segments.defaults())
    # 数据集合
    .dataMap(DataMaps.defaults());
``` 
分词策略：

    序号	 方法	   准确性	性能 	备注
    1	defaults()	高	高	默认分词形式，暂时为 fastForward 策略
    2	fastForward()	较高	高	fast-forward 分词策略
    3	chars()	低	高	将字符串转换为单个字符列表，一般不建议使用
    4	huaBan()	高	一般	花瓣的结巴分词策略

# 自定义
自定义分词
- 实现Segment接口，`ZhConvertBootstrap.newInstance()`指定

自定义数据集：
- 实现IDataMap接口，`ZhConvertBootstrap.newInstance()`指定