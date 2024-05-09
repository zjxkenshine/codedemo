# 参考地址
vars-parser 超精简的文本变量解析器,用于做文本变量值解析与自定义操作
- https://github.com/Verlif/vars-parser

# 相关组件
- VarsContext：区域变量上下文
  - 这里的区域变量是指被左右标识符包裹的变量，例如${name}
  - VarsContext默认以@{开头，以}结尾。 可以通过`VarsContext.setStart(String)`和`VarsContext.setEnd(String)`进行修改
- PartContext：部件变量上下文
  - 这里的部件变量指的是一般的整体变量，例如name，对应的是一个确切的字符串。
  - 通常情况下，我们会使用`String.replaceAll(String)`来替换，例如"filename.suffix".repalceAll("\\.", "_")将.替换为_。
  - 遇到一些特殊情况时，例如一个长文本有一套替换规则时，String.replaceAll(String)可能就不是很好用了
- PartContext.place
  - PartContext.place与PartContext.placeWith使用了相同的参数格式，但两者的结果不一样。
  - PartContext.placeWith中的第一个参数表示了替换结果词，后续的参数表示了替换目标。 
  - 而PartContext.place正好相反，第一个参数表示了替换目标，后续的参数表示了依次替换的结果词。
  
# 总结
- 需要 少量 的 常量替换 ，例如将name替换为Verlif这种推荐使用String.replaceAll或者PartContext.replace。
- 涉及到一些替换规范的，例如只能使用 正则表达 的，请使用String.replaceAll。
- 需要对 格式变量 进行区分 操作 的，例如#{name}这种被#{与}包裹的变量进行单独处理，推荐使用`VarsContext.build`。
- 需要 大量 的 常量替换 ，例如 屏蔽字词表 推荐使用`PartContext.apply`。
- 需要进行 格式变量 替换，例如#{hello}, 我的名字是#{name}, 来自#{from}这种，推荐使用`VarsContext.build(VarsReplacement)`。