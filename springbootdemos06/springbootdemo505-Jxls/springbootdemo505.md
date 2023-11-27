# 参考地址
jxls excel报表
- https://github.com/jxlsteam/jxls

# 简介
主要概念
- XlsArea：指定矩形区域
- Command：用于变化的指令
    - Each-Command
    - If-Command
    - Image-Command
    - MergeCells-Command
    - UpdateCell-Command：自定义特定单元格的处理
    - Grid-Command：生成表格
- Transformer：允许XlsArea独立于任何特定实现与Excel进行交互

# 模板定义
- 调整好表格样式
- 定义导出数据的属性名
- 通过表格的批注声明一些 jxls 配置
