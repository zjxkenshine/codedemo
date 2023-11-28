package com.kenshine.jargs;

import com.sanityinc.jargs.CmdLineParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname HelpParser
 * @Description Help自动解析
 * @Date 2023-11-28 11:02
 * @modified By：
 * @version: 1.0$
 */
public class HelpParser extends CmdLineParser{

    List<String> optionHelpStrings = new ArrayList<String>();

    public <T> Option<T> addHelp(Option<T> option, String helpString) {
        optionHelpStrings.add(" -" + option.shortForm() + "/--" + option.longForm() + ": " + helpString);
        return option;
    }

    public void printUsage() {
        System.err.println("usage: prog [options]");
        for (String help : optionHelpStrings) {
            System.err.println(help);
        }
    }

    public static void main(String[] args) {
        HelpParser parser = new HelpParser();
        // 添加Help描述文本
        CmdLineParser.Option<Boolean> verbose = parser.addHelp(
                parser.addBooleanOption('v', "verbose"),
                "Print extra information");
        CmdLineParser.Option<Integer> size = parser.addHelp(
                parser.addIntegerOption('s', "size"),
                "The extent of the thing");
        CmdLineParser.Option<String> name = parser.addHelp(
                parser.addStringOption('n', "name"),
                "Name given to the widget");
        CmdLineParser.Option<Double> fraction = parser.addHelp(
                parser.addDoubleOption('f', "fraction"),
                "What percentage should be discarded");
        CmdLineParser.Option<Boolean> help = parser.addHelp(
                parser.addBooleanOption('h', "help"),
                "Show this help message");

        try {
            parser.parse(args);
        } catch ( CmdLineParser.OptionException e ) {
            System.err.println(e.getMessage());
            parser.printUsage();
            System.exit(2);
        }

        if (parser.getOptionValue(help) ) {
            parser.printUsage();
            System.exit(0);
        }

        // 提取输入值，未指定选项为null
        Boolean verboseValue = parser.getOptionValue(verbose);
        Integer sizeValue = parser.getOptionValue(size);
        String nameValue = parser.getOptionValue(name);
        Double fractionValue = parser.getOptionValue(fraction);

        // 测试，仅打印选项
        System.out.println("verbose: " + verboseValue);
        System.out.println("size: " + sizeValue);
        System.out.println("name: " + nameValue);
        System.out.println("fraction: " + fractionValue);

        // 提取尾部参数
        String[] otherArgs = parser.getRemainingArgs();
        System.out.println("remaining args: ");
        for ( int i = 0; i < otherArgs.length; ++i ) {
            System.out.println(otherArgs[i]);
        }

        System.exit(0);
    }
}
