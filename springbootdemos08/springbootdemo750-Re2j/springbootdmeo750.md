# 参考地址
Re2j Java中的线性时间正则表达式匹配
- https://github.com/google/re2j

# 简介
RE2 是一个正则表达式引擎，在输入的大小上以时间线性方式运行，并非java.util.regex的替代，有很多功能没有

RE2 算法使用非确定性有限自动机在一次传递输入数据时同时探索所有匹配。所谓非确定性有限自动机（NFA）即：
- 对于某一个状态，读入某一个输入的时候，可能会有多种转移规则；
- 对于某一个状态，它可能会缺少对应某种输入的转移规则；

Lookaround：包括Lookahead和Lookbehind两种匹配模式
- Lookahead检测的是后缀
- Lookbehind检测的是前缀
- 它们有 Positive、Negative 两种匹配方式
- google/re2 是不支持 lookaround 的（既有前瞻（lookahead），也有后视（lookbehind））
- 要将 Lookaround 的语法转换为非 Lookaround 使用

# API概述
- `re.compile(pattern, flags=0)`：将正则表达式patten编译成正则表达式对象
- `re.DEBUG`：显示关于正则表达式的debug信息
- `re.I re.IGNORECASE`：大小写不敏感匹配
- `re.L re.LOCALE`：使`\w, \W, \b, \B, \s 和 \S`取决于当前语言环境
- `re.M re.MULTILINE`：指定匹配字符^和$的模式
- `re.S re.DOTALL`：指定匹配字符的模式
- `re.U re.UNICODE`：指定匹配字符的模式
- `re.X re.VERBOSE`：可在正则表达式中间添加注释使正则更易读
- `re.search(pattern, string, flags=0)`：可在正则表达式中间添加注释使正则更易读
- `re.split(pattern, string, maxsplit=0, flags=0)`：查找并返回MatchObject实例
- `re.sub(pattern, repl, string, count=0, flags=0)`：从string中用repl替换pattern并返回。
- `re.subn(pattern, repl, string, count=0, flags=0)`：功能和re.sub一样，但返回的是一个元组(new_string, number_of_subs_made)
- `re.findall(pattern, string, flags=0)`：返回匹配的字符串列表。