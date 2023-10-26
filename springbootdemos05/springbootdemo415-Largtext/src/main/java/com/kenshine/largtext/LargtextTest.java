package com.kenshine.largtext;

import com.github.fge.largetext.LargeText;
import com.github.fge.largetext.LargeTextFactory;
import com.github.fge.largetext.SizeUnit;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author by kenshine
 * @Classname LargtextTest
 * @Description 测试
 * @Date 2023-10-26 15:10
 * @modified By：
 * @version: 1.0$
 */
public class LargtextTest {
    private static final Pattern PATTERN = Pattern.compile("^\\d{4}:", Pattern.MULTILINE);


    public static void main(String[] args) throws IOException {
        // In code:
        final Path bigTextFile = Paths.get("D:\\Github\\codedemo\\springbootdemos05\\springbootdemo415-Largtext\\file\\test.txt");

        // 默认工厂
        final LargeTextFactory factory1 = LargeTextFactory.defaultFactory();
        // 设置编码与窗口大小
        final LargeTextFactory factory = LargeTextFactory.newBuilder()
                .setCharset(StandardCharsets.UTF_8)
                //.setCharsetByName("windows-1252")
                .setWindowSize(16, SizeUnit.MiB)
                .build();
        // 加载文件
        try (final LargeText largeText = factory.load(bigTextFile);) {
            // 可进行正则表达式匹配
            final Matcher m = PATTERN.matcher(largeText);
            while (m.find()){
                System.out.println("Match: " + m.group());
            }

            System.out.println(largeText.toString());
        }
    }
}
