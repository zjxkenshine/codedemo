# 参考地址
jxlss 基于jxls生成excel文件
- https://gitee.com/lnkToKing/jxlss

相关目录
- springbootdemo505-Jxls

# 简介
jxls 是一个导出excel文件的库，在原excel文件上加入jxls指令做成模板文件，然后几乎可以原样生成excel文件

# 注释指令
```shell
jx:<command_name>(attr1='val1' attr2='val2' ... attrN='valN' lastCell=<last_cell> areas=["<command_area1>", "<command_area2", ... "<command_areaN>"])
```
- jx:area：指定表格需要解析内容区域，区域外的指令和表达式不解析，所以必需添加该指令
- jx:each：迭代指令，可以横向向右或竖向向下输出集合内容，也可以输出多个表格
- jx:if：if指令，如果 condition 为 true 则在标签位置输出 areas[0] 的区域（也就是A9:F9），如果 condition 为 false 则在标签位置输出 areas[1] 的区域（也就是A18:F18）
- jx:image （jxlss增强）：图像
- jx:updateCell：更新
- jx:grid：动态列生成，可以动态指定生成的列名和数据
- jx:merge （jxlss增加）：合并单元格，从指令单元格开始合并
- jx:keep （jxlss增加）：保存单元格样式。在生成 excel 文件过程中，有些指令会导致单元格样式会发生变化，可以用该指令恢复原来的样式。

# 自定义指令
1. 继承AbstractCommand创建自定义指令