package com.kenshine.poitl.demo02;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.Numberings;
import com.deepoove.poi.data.Texts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 17:38
 * @description：列表
 * @modified By：
 * @version: $
 */
public class test05 {
    public static void main(String[] args) throws IOException {
        XWPFTemplate template = XWPFTemplate.compile("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\temp\\demo02\\test05.docx").render(
                new HashMap<String, Object>(){{
                    put("list", Numberings.create("Plug-in grammar",
                            "Supports word text, pictures, table...",
                            "Not just templates"));
                }});
        template.writeAndClose(new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\temp\\demo02\\test05out.docx"));
    }
}
