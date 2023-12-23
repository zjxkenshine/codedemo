# 参考地址
Pegdown- Java 的 Markdown 解析库
- https://github.com/sirthias/pegdown

Java使用PegDown将markdown文件转成html格式
- https://www.cnblogs.com/zifeiy/p/10017358.html

# 简介
Pegdown 是基于 parboiled (PEG parser) 完全使用 Java 实现的轻量级 Markdown 引擎。

Pegdown 100% 实现原生 Markdown 特性。
同时 Pegdown 还实现了一些流行的 Markdown 方言的特性，
当然你也可以通过实现 Pegdown 的插件来实现你所需要的功能。
已支持特性如下：
```
SMARTS: 支持自动转行成全角省略号，破折符
QUOTES: 支持自动转换成全角引号，书名号
ABBREVIATIONS: 支持 PHP Markdown Extra 的缩写功能
ANCHORLINKS: 支持对标题生成链接
HARDWRAPS: 支持 Github-flavoured-Markdown 的换行处理
AUTOLINKS: 支持 Github-flavoured-Markdown 的空白符
TABLES: 支持类似于 MultiMarkdown 的表格实现
DEFINITION LISTS: 支持 PHP Markdown Extra 的列表定义方式
FENCED CODE BLOCKS: 支持 PHP Markdown Extra 和 Github-flavoured-Markdown 代码段实现
HTML BLOCK SUPPRESSION: 禁止 HTML 块输出
INLINE HTML SUPPRESSION: 禁止行内 HTML 标签输出
WIKILINKS: 支持使用 [[Wiki-style links]] 定义链接
STRIKETHROUGH: 支持 Pandoc 和 Github 方式定义删除线
ATXHEADERSPACE: 支持 # 后接空格再加标题的方式定义标题
FORCELISTITEMPARA: 允许列表中使用
RELAXEDHRULES: 允许分割线定义不带上下空行没有
TASKLISTITEMS: 支持 Github 的 * [ ] and * [x] 语法定义带 checkbox 的列表
EXTANCHORLINKS: 支持对标题生成链接，会使用中完整的内容
```