package com.kenshine.markdone;

import idea.verlif.markdone.MarkDone;
import idea.verlif.markdone.builder.Inline.InlineItem;
import idea.verlif.markdone.builder.block.*;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname MarkDoneTest
 * @Description Markdone测试
 * @Date 2024-05-11 10:17
 * @modified By：
 * @version: 1.0$
 */
public class MarkDoneTest {

    /**
     * 行内元素
     */
    @Test
    public void test01(){
        InlineItem inlineItem = new InlineItem()
                .bold("粗体").newLine()
                .italic("斜体").newLine()
                .code("内嵌代码").newLine()
                .url("https://github.com/").newLine()
                .img("图片", "https://avatars.githubusercontent.com/u/39126497?s=40&v=4", "我的头像").newLine()
                .src("Verlif", "https://github.com/", "github").newLine()
                .delete("删除线").newLine()
                .emoji("smile").newLine()
                .warpedTag("strong", "strong tag");
        System.out.println(inlineItem.build());
    }

    /**
     * 块级元素
     */
    @Test
    public void test02(){
        TableItem builder = new TableItem();
        builder.start()
                .titles("1", "2")
                .title("3", TableItem.FLOW.CENTER)
                .title("4", TableItem.FLOW.RIGHT)
                .values("v1", "v2", "v3", "v4")
                .values("vv1", "vv2", "vv3", "vv4")
                .repeatTitle()
                .values("vv1", "vv2", "vv3", "vv4")
                .build();
        System.out.println(builder);
    }


    /**
     * 组合模式
     */
    @Test
    public void test03(){
        MarkDone markDone = new MarkDone();
        MarkDone.Editor editor = markDone.getEditor();
        markDone.append(new InlineItem().heading(1, "这个是测试"))
                .append(new CatalogItem().start().build())
                .append(new InlineItem().heading(2, "简单的内容构建测试"))
                .append(new InlineItem()
                        .bold("粗体").newLine()
                        .italic("斜体").newLine()
                        .code("内嵌代码").newLine()
                        .url("https://github.com/").newLine()
                        .img("图片", "https://avatars.githubusercontent.com/u/39126497?s=40&v=4", "我的头像").newLine()
                        .src("Verlif", "https://github.com/", "github").newLine()
                        .delete("删除线").newLine()
                        .emoji("smile").newLine()
                        .warpedTag("strong", "strong tag").newLine())
                .append(new InlineItem().heading(2, "块级元素构建测试"))
                .append(new InlineItem().heading(3, "代码块"))
                .append(new CodeItem("java").start()
                        .content("System.out.println(\"Hello World!\");").build())
                .append(new InlineItem().heading(3, "无序列表"))
                .append(new DisorderedItem().start()
                        .content("第一行")
                        .content("第二行")
                        .content(new DisorderedItem(2).start()
                                .content("第1行")
                                .content("第2行").build())
                        .content("第三行").build())
                .append(new InlineItem().heading(3, "有序列表"))
                .append(new OrderedListItem().start()
                        .content("第一行")
                        .content("第二行")
                        .content(new OrderedListItem(2).start()
                                .content("第1行")
                                .content("第2行").build())
                        .content("第三行").build())
                .append(new InlineItem().heading(3, "引用块"))
                .append(new QuoteItem().start()
                        .content("第一行")
                        .content("第二行")
                        .content(new QuoteItem().start()
                                .content("第1行")
                                .content("第2行").build())
                        .content("第三行")
                        .content(new OrderedListItem(2).start()
                                .content("第一条")
                                .content("第二条").build())
                        .content("第四行")
                        .content("第五行")
                        .content(new QuoteItem().start()
                                .content("第1行")
                                .content(new QuoteItem().start()
                                        .content("第Ⅰ行")
                                        .content("第Ⅱ行").build()).build()).build())
                .append(new InlineItem().heading(3, "表格"))
                .append(new TableItem().start()
                        .titles("1", "2")
                        .title("3", TableItem.FLOW.CENTER)
                        .title("4", TableItem.FLOW.RIGHT)
                        .values("v1", editor.footnote("v2", "1", "v2表示了v2，你明白吧"), "v3", "v4")
                        .values("vv1", "vv2", "vv3", "vv4")
                        .repeatTitle()
                        .values("vv1", "vv2", "vv3", "vv4").build())
                .append(new InlineItem().heading(3, "任务列表"))
                .append(new TodoItem().start()
                        .done("已完成")
                        .undo("未完成")
                        .content(new TodoItem(2).start()
                                .done("已完成")
                                .undo("未完成").build())
                        .undo("未完成列表")
                        .content(new DisorderedItem(2).start()
                                .content("第一条")
                                .content("第二条").build()).build())
                .append(new InlineItem().heading(3, "定义列表"))
                .append(new DefinitionItem().start()
                        .words("MarkDone", "Markdown文本构建器")
                        .words("Markdown", "轻量级的标记语言").build());
        System.out.println(markDone.build());
    }
}
