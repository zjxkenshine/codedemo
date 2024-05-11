# 参考地址
MarkDone是一个Markdown构建器
- https://github.com/Verlif/mark-done

# 支持的元素
```
元素	对应组件
标题	InlineItem.heading(int, String)
粗体	InlineItem.bold(String)
斜体	InlineItem.italic(String)
删除线	InlineItem.delete(String)
行内代码	InlineItem.code(String)
链接	InlineItem.url(String)
资源链接	InlineItem.src(String, String [, String])
图片	InlineItem.img(String, String [, String])
目录	CatalogItem()
定义列表	DefinitionItem()
代码块	CodeItem()
有序列表	OrderedListItem()
无序列表	DisorderedListItem()
分割线	HorizontalRuleItem()
引用块	QuoteItem()
表格	TableItem()
任务列表	TodoItem()
脚注	MarkDone.getEdit().tag(String, String)
参考链接	MarkDone.getEdit().reference(String, String)
```

