package com.kenshine.commoncli.test;

import org.apache.commons.cli.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 9:21
 * @description：
 * @modified By：
 * @version: $
 */
public class test01 {
    /**
     *     Option可以通过new生成，也可以通过Option.builder()构造生成。
     *      该类是描述具体参数的基础类，它有以下这些基础属性：
     *          argName 字符串值, 参数值说明
     *          description 字符串值, 参数描述
     *          opt 字符串值, 短选项名, 比如：-p=22，p就是该短选项名
     *          longOpt 字符串值, 长选项类型；比如：-p=22 --port=22，port就是该长选项名
     *          numberOfArgs 整型, 参数个数
     *          optionalArg 布尔型, 是否可选
     *          required 布尔型, 是否必填
     *          type Class, 参数类型
     *          valuesep 字符型, 值分隔符；采用java参数风格解析时用来分支值，如：-Dkey=value。
     */
    private static Options OPTIONS = new Options();
    private static CommandLine commandLine;
    private static String HELP_STRING = null;

    public static void main(String[] args) {
        initCliArgs(args);
    }

    /**
     * 拿host参数举例：
     *
     * 设置了h短选项和host长选项，意味着入参使用-h 127.0.0.1或-host 127.0.0.1方式传入，都能成功赋值。
     * 设置了hasArg(true)属性，说明它是有值选项。
     * 设置了required()，该参数的值必填。
     * 配置argName("ipv4 or ipv6")是对参数值的说明，若不填就会像其他参数一样会提示<arg>。
     * 设置type(String.class)，说明该参数的值应该为String类型
     * 设置desc是对该参数的详细描述，如对host的参数说明：the host of remote server
     */
    /**
     * init args
     * @param args args
     */
    private static void initCliArgs(String[] args) {
        CommandLineParser commandLineParser = new DefaultParser();
        // help
        OPTIONS.addOption("help","usage help");
        // host
        OPTIONS.addOption(Option.builder("h").argName("ipv4 or ipv6").required().hasArg(true).longOpt("host").type(String.class).desc("the host of remote server").build());
        // port
        OPTIONS.addOption(Option.builder("P").hasArg(true).longOpt("port").type(Short.TYPE).desc("the port of remote server").build());
        // user
        OPTIONS.addOption(Option.builder("u").required().hasArg(true).longOpt("user").type(String.class).desc("the user of remote server").build());
        // password
        OPTIONS.addOption(Option.builder("p").required().hasArg(true).longOpt("password").type(String.class).desc("the password of remote server").build());
        // srcPath
        OPTIONS.addOption(Option.builder("s").required().hasArg(true).longOpt("src_path").type(String.class).desc("the srcPath of local").build());
        // dstPath
        OPTIONS.addOption(Option.builder("d").required().hasArg(true).longOpt("dst_path").type(String.class).desc("the dstPath of remote").build());
        try {
            commandLine = commandLineParser.parse(OPTIONS, args);
        } catch (ParseException e) {
            //解析失败，输出默认帮助字符串
            System.out.println(e.getMessage() + "\n" + getHelpString());
            System.exit(0);
        }

    }

    /**
     * get string of help usage
     * @return help string
     */
    private static String getHelpString() {
        if (HELP_STRING == null) {
            HelpFormatter helpFormatter = new HelpFormatter();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
            //打印帮助字符串
            helpFormatter.printHelp(printWriter, HelpFormatter.DEFAULT_WIDTH, "scp -help", null,
                    OPTIONS, HelpFormatter.DEFAULT_LEFT_PAD, HelpFormatter.DEFAULT_DESC_PAD, null);
            printWriter.flush();
            HELP_STRING = new String(byteArrayOutputStream.toByteArray());
            printWriter.close();
        }
        return HELP_STRING;
    }


}
