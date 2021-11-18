package com.kenshine.poitl.demo01;

import com.deepoove.poi.XWPFTemplate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 17:11
 * @description：测试1
 * @modified By：
 * @version: $
 * 快速入门示例
 */
public class test01 {
    public static void main(String[] args) throws IOException {
        XWPFTemplate template = XWPFTemplate.compile("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\temp\\demo01\\test01.docx").render(
                new HashMap<String, Object>(){{
                    put("title", "Hi, poi-tl Word模板引擎");
                }});
        template.writeAndClose(new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\temp\\demo01\\output.docx"));
    }
}
