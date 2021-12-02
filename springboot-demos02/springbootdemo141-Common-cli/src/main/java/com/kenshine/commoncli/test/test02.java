package com.kenshine.commoncli.test;

import org.apache.commons.cli.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 9:35
 * @description：
 * @modified By：
 * @version: $
 */
public class test02 {


    /**
     *
     *  org.apache.commons.cli.Options;
     *  org.apache.commons.cli.Option
     *      Option可以通过new生成，也可以通过Option.builder()构造生成。
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
     *
     *  org.apache.commons.cli.CommandLineParser;
     *      org.apache.commons.cli.DefaultParser
     *  org.apache.commons.cli.CommandLine
     *      CommandLineParser.parse()的产物
     *
     *  org.apache.commons.cli.HelpFormatter
     */

    public static void main(String[] args){
        /****
         * CLI 定义阶段
         *   目标：创建 Options 实例。
         *   addOption() 有几个重载方法，下面使用到的方法有三个参数
         *      第一个参数设定这个 option 的单字符名字
         *      第二个参数指明这个 option 是否需要输入数值
         *      第三个参数是对这个 option 的简要描述。
         * ****/
        // 创建 Options 对象
        Options options = new Options();
        // 添加 -h 参数
        options.addOption("h", "help", false, "Lists short help");
        // 添加 -c 参数
        options.addOption("c", "configFile", true, "Name server config properties file");
        // 添加 -p 参数
        options.addOption("p", "printConfigItem", false, "Print all config item");

        /****
         * CLI 解析阶段
         *   目标：创建 CommandLine 实例。
         *   说明：在解析阶段中，通过命令行传入应用程序的文本来进行处理。
         *          处理过程将根据在解析器的实现过程中定义的规则来进行。
         *          在 CommandLineParser 类中定义的 parse 方法将用 CLI 定义阶段中产生的 Options
         *          实例和一组字符串作为输入，并返回解析后生成的 CommandLine。
         * CLI 询问阶段
         *   目标：将所有通过命令行以及处理参数过程中得到的文本信息传递给用户的代码。
         *   说明：在询问阶段中，应用程序通过查询 CommandLine，并通过其中的布尔参数和提供给
         *          应用程序的参数值来决定需要执行哪些程序分支。这个阶段在用户的代码中实现，
         *          CommandLine 中的访问方法为用户代码提供了 CLI 的询问能力。
         *
         * ****/
        CommandLineParser parser = new DefaultParser();
        //String[] args = { "-h", "-c", "config.xml" };
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println("解析失败，请查看帮助文档");
            e.printStackTrace();
        }

        HelpFormatter hf = new HelpFormatter();
        hf.setWidth(110);
        if(cmd.hasOption("h")) {
            // 这里显示简短的帮助信息
            hf.printHelp("testApp", options, true);
            // 打印opts的名称和值
            System.out.println("--------------------------------------");
            Option[] opts = cmd.getOptions();
            if (opts != null) {
                for (Option opt1 : opts) {
                    String name = opt1.getLongOpt();
                    String value = cmd.getOptionValue(name);
                    System.out.println(name + "=>" + value);
                }
            }
        }
    }
}
