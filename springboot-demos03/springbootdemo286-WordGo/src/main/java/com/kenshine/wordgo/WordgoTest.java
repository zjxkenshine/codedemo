package com.kenshine.wordgo;

import com.github.qrpcode.domain.WordGo;
import com.github.qrpcode.domain.WordPaper;

/**
 * @author by kenshine
 * @Classname WordgoTest
 * @Description 测试
 * @Date 2023-10-20 12:13
 * @modified By：
 * @version: 1.0$
 */
public class WordgoTest {

    public static void main(String[] args) {
        // 设置word页面大小为 A3，纸张横向显示
        WordPaper paper = new WordPaper("A3", true);

        // 新建一个word
        WordGo wordGo = new WordGo(paper);

        // 添加文字，并设置文字样式
        wordGo.add("Hello World", "font-size: 15; color: #FF0000");

        // 添加文字，并设置文字样式，并在后面添加换行符
        wordGo.addLine("Hello World", "font-size: 15; color: #FF0000");

        // 生成文件，文件名必须以.docx结尾
        wordGo.create("C:\\demo.docx");
    }
}
