# 1.简介
- XSL-FO 是用于格式化 XML 数据的语言
- XSL-FO 指可扩展样式表语言格式化对象
- XSL-FO 是一个 W3C 推荐标准
- XSL-FO 目前通常被称为 XSL

## 分类
- XSLT，用于转换 XML 文档的语言
- XSL 和 XSL-FO，用于格式化 XML 文档的语言
- XPath，是通过元素和属性在 XML 文档中进行导航的语言
## XSLT
- XSLT 指 XSL 转换（XSL Transformations）。
- XSLT 是 XSL 中最重要的部分。
- XSLT 可将一种 XML 文档转换为另外一种 XML 文档。 
- XSLT 使用 XPath 在 XML 文档中进行导航。
- XPath 是一个 W3C 标准

# 2.文档结构
```
<!--XML声明-->
<?xml version="1.0" encoding="utf-8"?>

<!--根标签-->
<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <!--页面布局-->
    <fo:layout-master-set>
        <!--单页面模板-->
        <fo:simple-page-master master-name="A4">
            <!--页面区域主体-->
            <fo:region-body />
        </fo:simple-page-master>
    </fo:layout-master-set>
    <!--页面序列-->
    <fo:page-sequence master-reference="A4">
        <!--页面流-->
        <fo:flow flow-name="xsl-region-body">
            <!--块-->
            <fo:block/>
        </fo:flow>
    </fo:page-sequence>
</fo:root>
```
页面流布局配置：
- xsl-region-body	页面主体
- xsl-region-before	页眉
- xsl-region-after	页脚
- xsl-region-start	左侧栏
- xsl-region-end	右侧栏

# 3.XSL-FO 文档中可使用单位
- cm	厘米
- mm	毫米
- in	英寸
- pt	点（72 点 = 1 英寸）
- pc	派卡（12 点 = 1 派卡，6 派卡 = 1 英寸）
- px	像素（有时随格式化程序或设备的不同而有所不同）
- em	一个大写 M 的宽度

# 4.页面布局实例
```
<fo:simple-page-master master-name="A4" margin-top="20px" margin-bottom="20px" margin-left="10px" margin-right="10px">
    <!--页面主体-->
    <fo:region-body margin="30px"/>
    <!--页眉-->
    <fo:region-before extent="10px"/>
    <!--页脚-->
    <fo:region-after extent="10px"/>
    <!--左侧栏-->
    <fo:region-start extent="20px"/>
    <!--右侧栏-->
    <fo:region-end extent="20px"/>
</fo:simple-page-master>
```

# 5.常用元素
```
<fo:root />	根元素节点，XSL-FO 文档的顶部节点。其他任意元素节点应包含在此元素节点下。
<fo:layout-master-set />	页面布局元素节点，用于定义页面模板的集合。
<fo:simple-page-master />	页面模板元素节点，用于定义单个页面模板，其页面被细分为多个区域。
<fo:region-body />	页面区域主体元素节点，用于展示文档的主体内容，可包含文字、图像与表格等。
<fo:region-before />	页面区域页眉元素节点，用于展示文档的页眉内容，可包含文字、图像与表格等。
<fo:region-after />	页面区域页脚元素节点，用于展示文档的页脚内容，可包含文字、图像与表格等。
<fo:region-start />	页面区域左侧栏元素节点，用于展示文档的左侧栏内容，可包含文字、图像与表格等。
<fo:region-end />	页面区域右侧栏元素节点，用于展示文档的右侧栏内容，可包含文字、图像与表格等。
<fo:page-sequence />	页面序列元素节点，用于定义新页面内容，一个 “<fo:page-sequence />” 元素节点即表示一个新页面的开始。
<fo:flow />	页面流元素节点，用于定义页面内容的流向，例如页眉或页脚。
<fo:block />	块元素节点，用于定义格式化段落、标题、图像和表格等。
<fo:inline />	内联元素节点，用于定义格式化文本。
<fo:external-graphic />	外部图像元素节点，用于定义外部图像。
<fo:table />	表格元素节点，用于定义表格。
<fo:table-column />	表格列元素节点，用于定义位于同一列的表格单元格属性。
<fo:table-header />	表头元素节点，用于定义表头。
<fo:table-footer />	表尾元素节点，用于定义表尾。
<fo:table-body />	表格体元素节点，用于定义表格主体。
<fo:table-row />	表格行元素节点，用于定义表格单行内容。
<fo:table-cell />	表格单元格元素节点，用于定义表格单个单元格内容。
<fo:list-block />	列表元素节点，用于定义列表。
<fo:list-item />	列表项元素节点，用于定义列表项。
<fo:list-item-label />	列表项标签元素节点，用于定义列表项标签内容。
<fo:list-item-body />	列表项主体元素节点，用于定义列表项主体内容。
<fo:static-content />	静态内容元素节点，用于定义页面静态内容。当文档进行分页时，新页面也将添加所定义的静态内容。通常用于页眉与页脚。
<fo:page-number />	页面索引（页码）元素节点，用于显示当前页面的页码。
<fo:page-number-citation-last />	总页面索引（总页码）元素节点，用于显示当前文档的总页码。
```