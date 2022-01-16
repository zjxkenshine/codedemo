# 1.拼音处理相关技术
- TinyPinyin https://github.com/promeG/TinyPinyin
- pinyin4j  https://github.com/belerweb/pinyin4j
- pinyin  https://github.com/houbb/pinyin
    - pinyin-data 拼音数据支持
    - phrase-pinyin-data 词语拼音数据
    - segment 高性能的 java 分词实现
- jpinyin https://github.com/shenkevin/jpinyin
- opencc4j 简繁转换

# 2.Pinyin4j概述
pinyin4j是一个开源的流行java库，使用来处理中文转换成拼音（汉语拼音，罗马拼音等），功能强大
- PinyinHelper：提供了几个实用程序函数，用于将中文字符（简体和繁体）转换为各种中文罗马化表示。
- HanyuPinyinOutputFormat：这个类定义了如何输出汉语拼音。
- HanyuPinyinCaseType：为汉语拼音字符串的输出案例提供了几种选项。
- HanyuPinyinToneType：该类提供了几种输出中文音调的选项。
- HanyuPinyinVCharType：这个类为'ü'的输出提供了几个选项。

# 3.TinyPinyin概述
适用于Java和Android的快速、低内存占用的汉字转拼音库，解决了Pinyin4j臃肿的问题
- 生成的拼音不包含声调，均为大写；
- 支持自定义词库，支持简体中文、繁体中文；
- 执行效率很高(Pinyin4J的4~16倍)；
- 很低的内存占用（不添加词典时小于30KB）

# 4.Pinyin概述
java 实现的高性能中文拼音转换工具 https://github.com/houbb/pinyin
- 极简的 api 设计
- 支持转换长文本
- 支持多音字
- 支持多种拼音标注方式
- 支持中文分词
- 支持中文繁简体
- 支持自定义拼音词库
- 支持判断是否为同音字
- 支持同音字（3.0）
