package com.kenshine.commoncli;

import org.apache.commons.cli.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 9:33
 * @description：
 * @modified By：
 * @version: $
 *
 * 使用方式 java -jar xxx.jar 参数
 * java -jar springbootdemo141-Common-cli-1.0-SNAPSHOT.jar --test=demo141
 */
@SpringBootApplication
public class CommonCliApp {
    public static void main(String[] args) {
        testCli(args);
        SpringApplication.run(CommonCliApp.class,args);
    }

    private static Options OPTIONS = new Options();
    private static CommandLine commandLine;
    private static String HELP_STRING = null;

    /**
     * common-cli测试
     * @param args
     */
    private static void testCli(String[] args) {
        CommandLineParser commandLineParser = new DefaultParser();
        // help
        OPTIONS.addOption("help","usage help");
        // 必须要有test参数
        OPTIONS.addOption(Option.builder("t").argName("test").required().hasArg(true).longOpt("test").type(String.class).desc("test common cli").valueSeparator('=').build());

        try {
            commandLine = commandLineParser.parse(OPTIONS, args);
            System.out.println(commandLine.getOptionValue("test"));
        } catch (ParseException e) {
            //解析失败，输出默认帮助字符串
            System.out.println(e.getMessage() + "\n" + getHelpString());
            //退出程序
            System.exit(0);
        }
    }

    /**
     * 获取帮助字符串
     * @return
     */
    private static String getHelpString() {
        if (HELP_STRING == null) {
            HelpFormatter helpFormatter = new HelpFormatter();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
            //打印帮助字符串
            helpFormatter.printHelp(printWriter, HelpFormatter.DEFAULT_WIDTH, "java -jar -help", null,
                    OPTIONS, HelpFormatter.DEFAULT_LEFT_PAD, HelpFormatter.DEFAULT_DESC_PAD, null);
            printWriter.flush();
            HELP_STRING = new String(byteArrayOutputStream.toByteArray());
            printWriter.close();
        }
        return HELP_STRING;
    }



}
