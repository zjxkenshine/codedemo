# 参考地址
Boxable是一个可以用来在pdf文档中轻松创建表格的库。
- https://github.com/dhorions/boxable
- https://github.com/dhorions/boxable/wiki

# 踩坑
## java.lang.NoSuchFieldError: HELVETICA
添加HELVETICA字体文件,pdfbox版本问题

# 目录
BoxableTest github使用教程
- test01：从CSV生成PDF表格
- test02：从List生成PDF表格
- test03：PDF表格手动设置生成

BoxableTest02 wiki使用教程
- test01：在表格外创建文字
- test02：PDStreamUtils.write 添加表格外文字
- test03：简单表格示例
- test04：画图片
- test05：在同一个y坐标设置两个table

# 补充
## 1.横向A4
```
PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
```

## 2.纵向A4
```
PDPage page = new PDPage(PDRectange.A4);
```

## 3.动态取表格高度
```
float tableHeight = table.getHeaderAndDataHeight();
```

## 4.检索当前表页面
```
if (table.getCurrentPage() != page) {
    cos.close();
    page = table.getCurrentPage();
    cos = new PDPageContentStream(document, page, true, true);
}
```

## 5.多页后y位置
```
yStart = table.draw();
```

## 6.内嵌表格
```
Cell<PDPage> cell = row.createTableCell((100 / 3f),"<table><tr><td>First row, first value</td><td>First row, second value</td></tr><tr><td>Second row, first value</td><td>Second row, second value</td></tr></table>",
doc, page, yStart, topMargin, bottomMargin);
```