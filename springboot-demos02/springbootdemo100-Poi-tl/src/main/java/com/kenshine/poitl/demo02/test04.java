package com.kenshine.poitl.demo02;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.*;
import com.deepoove.poi.data.style.BorderStyle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 17:32
 * @description：表格
 * @modified By：
 * @version: $
 */
public class test04 {
    public static void main(String[] args) throws IOException {
        XWPFTemplate template = XWPFTemplate.compile("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\temp\\demo02\\test04.docx").render(
                new HashMap<String, Object>(){{
                    // 一个2行2列的表格
                    put("table0", Tables.of(new String[][] {
                            new String[] { "00", "01" },
                            new String[] { "10", "11" }
                    }).border(BorderStyle.DEFAULT).create());

                    // 第0行居中且背景为蓝色的表格
                    RowRenderData row0 = Rows.of("姓名", "学历").textColor("FFFFFF")
                            .bgColor("4472C4").center().create();
                    RowRenderData row1 = Rows.create("李四", "博士");
                    put("table1", Tables.create(row0, row1));

                    // 合并第1行所有单元格的表格
                    RowRenderData row3 = Rows.of("列0", "列1", "列2").center().bgColor("4472C4").create();
                    RowRenderData row4 = Rows.create("没有数据", null, null);
                    MergeCellRule rule = MergeCellRule.builder().map(MergeCellRule.Grid.of(1, 0), MergeCellRule.Grid.of(1, 2)).build();
                    put("table2", Tables.of(row3, row4).mergeRule(rule).create());
                }});
        template.writeAndClose(new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\temp\\demo02\\test04out.docx"));
    }
}
