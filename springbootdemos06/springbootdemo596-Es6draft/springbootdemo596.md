# 参考地址
es6draft es6解析与运行
- https://github.com/anba/es6draft

# 主要类
- CompatibilityOption：编译选项
- Compiler：编译js
- ScriptLoader：读取并编译js脚本
- RuntimeContext：运行时选项与配置
- Script：ESMA脚本
  - evaluate方法执行
- Source：源代码信息
  - name：名称
  - line：起始偏移
  - SourceIdentifier：id
  - file：文件
- Realm：可执行代码和执行上下文
- World：上下文