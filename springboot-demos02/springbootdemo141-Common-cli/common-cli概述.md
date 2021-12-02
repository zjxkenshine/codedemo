# 1.common-cli概述
- common-cli组件是一个解析命令参数的jar包，它能解析gnu风格参数、posix风格参数，可以帮助程序去解析传递给程序的命令行参数
- 解析程序打包后命令行传的参数

# 2.Option
该类是描述具体参数的基础类，它有以下这些基础属性

|    属性名    |  类型   |                             描述                             |
| :----------: | :-----: | :----------------------------------------------------------: |
|   argName    | String  |                          参数值说明                          |
| description  | String  |                           参数描述                           |
|     opt      | String  |            短选项名；比如：-p=22，p就是该短选项名            |
|   longOpt    | String  |    长选项类型；比如：-p=22 --port=22，port就是该长选项名     |
| numberOfArgs |   int   |                           参数个数                           |
| optionalArg  | boolean |                           是否可选                           |
|   required   | boolean |                           是否必填                           |
|     type     |  Class  |                           参数类型                           |
|   valuesep   |  char   | 值分隔符；采用java参数风格解析时用来分支值，如：-Dkey=value。 |

# 3.CommandLineParser
- GnuParser和PosixParser解析器分别代表gnuParser参数风格和posixParser参数风格，不过在1.3版本中连同父类Parser都被废除并统一重构成了DefaultParser
- posix风格参数以`-`开头；gnu风格参数兼容posix并推荐以`--`开头
- common-cli-1.3之后推荐使用`DefaultParser`

# 4.CommandLine
- CommdLine类是经过parser解析后的产物，保存了参数解析后对应的结果，并提供了多种操作参数结果的方法
    - `List<String> args` : 原始参数
    - `List<Option> options` : 解析后的option