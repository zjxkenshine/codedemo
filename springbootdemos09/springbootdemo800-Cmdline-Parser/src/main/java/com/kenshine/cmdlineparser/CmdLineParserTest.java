package com.kenshine.cmdlineparser;

import idea.verlif.parser.cmdline.ArgValues;
import idea.verlif.parser.cmdline.CmdlineParser;
import idea.verlif.parser.cmdline.argparser.PrefixWithConfigArgParser;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname CmdLineParserTest
 * @Description 命令行解析使用测试
 * @Date 2024-05-06 8:53
 * @modified By：
 * @version: 1.0$
 */
public class CmdLineParserTest {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        String line = "-abc --username Verlif --commit \"hello world!\" --allowed";
        CmdlineParser parser = new CmdlineParser();
        // 忽略未知命令，否则会抛出UnknownCmdKeyException异常
        parser.ignoreUnknownKey();
        // 忽略关键词大小写，可以让"--KEy"也能匹配到"key"
        parser.ignoreCase();
        // 添加指令执行器
        parser.setArgParser(new PrefixWithConfigArgParser("--"));
        parser.addHandler("username", param -> {
            System.out.println("解析到username - "  + param);
        });
        parser.addHandler("allowed", param -> {
            System.out.println("解析到allowed - "  + param);
        });
        parser.addHandler("a", param -> {
            System.out.println("解析到a - " + param);
        });
        parser.addHandler("b", param -> {
            System.out.println("解析到b - " + param);
        });
        parser.addHandler("c", param -> {
            System.out.println("解析到c - " + param);
        });
        // 执行指令
        parser.exec(line);
        // 上方指令结果与下方相同
        ArgValues argValues = new ArgValues();
        argValues.add("a", null);
        argValues.add("b", null);
        argValues.add("c", null);
        argValues.add("username", "Verlif");
        argValues.add("commit", "hello world!");
        argValues.add("allowed", null);
        parser.exec(argValues);
        // 甚至相当于这样
        HtmlUrlArgParser htmlUrlArgParser = new HtmlUrlArgParser();
        parser.setArgParser(htmlUrlArgParser);
        parser.exec("127.0.0.1:81/queue/queue?a&b&c&username=Verlif&commit=hello world&allowed");
    }
}
