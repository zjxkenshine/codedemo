package com.kenshine.joddlagarto;

import jodd.jerry.Jerry;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname JerryTest
 * @Description Jerry java jquery实现
 * @Date 2024-02-28 12:52
 * @modified By：
 * @version: 1.0$
 */
public class JerryTest {

    /**
     * 简单使用
     */
    @Test
    public void test01(){
        Jerry doc = Jerry.of("<html><div id='jodd'><b>Hello</b> Jerry</div></html>");
        doc.s("div#jodd b").css("color", "red").addClass("ohmy");
        System.out.println(doc.html());
    }

    /**
     * Css处理
     */
    @Test
    public void test02(){
        Jerry jerry=Jerry.of("<tr></tr>")
                .s("tr:last")
                .css("background-color", "yellow", "fontWeight", "bolder");
        System.out.println(jerry.html());
    }

    /**
     * 选择器
     */
    @Test
    public void test03(){
        Jerry jerry=Jerry.of("<html><a>kenshine</a></html>")
                .s("select option:selected")
                .each(($this, index) -> {
                    System.out.println($this.text());
                    return true;
                });
        System.out.println(jerry.html());
    }

}
