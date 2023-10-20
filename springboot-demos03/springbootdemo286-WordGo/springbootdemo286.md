# 1.参考地址
WordGo gitee
- https://gitee.com/qiruipeng/WordGo

# 2.操作
## 创建文件
- `WordGo()`：A4纸竖向
- `WordGo(String paperType)`：指定纸张类型
- `WordGo(WordPaper wordPaper)`：指定纸张信息
- `WordGo(WordCore wordCore)`：指定文档属性信息
- `WordGo(WordCore wordCore, WordPaper wordPaper)`：指定文档属性信息和纸张构造

## 文字换页
```
addLine(String text, String css)
add(String text, String css)
newPage()
```

## 创建、填充、添加表格有关操作
```
add(WordTable wordTable)
addTable(WordTable wordTable)
```

## 图片有关操作
```
addImg(String uri, String css)
```

## 页眉页脚有关操作
```
addHead(PaperOut header)
addFoot(PaperOut footer)
```

## 生成文件
```
// 文件名必须以 .docx 结尾，路径必须为绝对路径
create(String fileWay)
```