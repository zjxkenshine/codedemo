package com.kenshine.poitl.demo02;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.Texts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 17:19
 * @description：测试02
 * @modified By：
 * @version: $
 */
public class test02 {
    public static void main(String[] args) throws IOException {
        XWPFTemplate template = XWPFTemplate.compile("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\temp\\demo02\\test02.docx").render(
                new HashMap<String, Object>(){{
                    put("name", "Sayi");
                    put("author", Texts.of("Sayi").color("000000").create());
                    put("link", Texts.of("website").link("http://deepoove.com").create());
                    put("anchor", Texts.of("anchortxt").anchor("appendix1").create());
                }});
        template.writeAndClose(new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\temp\\demo02\\test02out.docx"));
    }
}
