# 参考地址
Html Parser html文件解析器
- https://github.com/Verlif/html-parser

# 简介
html文件解析器
- 超简单的HTML格式信息解析器，利用了 vars-parser 来解析HTML中的标签（以下称为 节点 ）信息，然后生成一个可查询的节点管理器。 通过这个管理器即可获取节点内容。实际上，这是一个简单的xml解析器

可以做的事情：
- 遍历节点结构
- 允许HTML片段，例如以下这种方式，没有<html>或<body>等标签，只要是闭合标签都可以解析。
    ```
    <div class="third">
      <label id="label">你好</label>
    </div>
    ```
- 搜索节点（通过标签名或参数信息来find）
- 链式定位节点（.name("body").name("div", 2).name("ul").index(5)，通过IDE点就完事了)
- link语法定位节点（.link("html>body>div[2]>[4]>label")可能会更方便一些）
- 获取节点内容（content()或是自定义content(VarsHandler)）
- 获取节点参数（props()获取参数表)