# 参考地址
Diff-Utils 文件比对
- https://github.com/java-diff-utils/java-diff-utils
- https://java-diff-utils.github.io/java-diff-utils/

# 简介
Diff-Utils库是一个开源库，用于执行文本或某种数据之间的比较/差异操作：计算差异、应用补丁、生成统一差异或解析它们、生成差异输出以便于将来显示（如并排视图）等等。

# 组成
- DiffUtils：计算补丁和增量
- UnifiedDiffUtils：处理UnifiedDiff文件（导入/创建）
- DiffRowGenerator：以可读的形式提供差异集
- unifiediff/：包含unifieddiff解析器工具的新实现
    - UnifiedDiffReader.parseUnifiedDiff
  
# 目录
- test01：计算差异
- test02：应用补丁
- test03：生成标准diff格式并应用补丁
- test04：DiffRowGenerator 比对两个文本并输出可读性高的文本
- test05：DiffRowGenerator 多行文本输出
- test06：比对非文本之间的差异