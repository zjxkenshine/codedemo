# 1.简介
java 解析命令行工具包 jopt-simple

# 2.补充说明
- `parser.withValuesSeparatedBy(',')`：可设置参数分隔符，多个值可以用这里配置好的分隔符分割
- `parser.recognizeAlternativeLongOptions(true)`：可识别替换长参数，`-W foo=bar`将被看成是`--foo=bar`
- 两种添加识别参数的方法：
   - `accepts(String)`或者`acceptsAll(List)`
   - accepts(String)规则：
        - 任务字符或者数字被当做是一个选项
        - 一个选项可以紧跟一个星号，表明这个选项是help选项
        - 如果一个选项字符紧跟一个冒号:，意味着这个选项需要必填参数值
        - 如果一个选项字符紧跟两个冒号::，那么这个选项接受可选的参数值
        - 否则，这个选项不接受参数值
        - 如果一个选项用一个加号+开始，这个parser和'POSIX-ly correct'方式一致
        - 如果选项字符串包含W;，parser将作为长格式的替换

