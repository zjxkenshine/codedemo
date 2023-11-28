package com.kenshine.jargs;

import com.sanityinc.jargs.CmdLineParser;
import com.sanityinc.jargs.CmdLineParser.Option;

import java.util.Collection;

/**
 * @author by kenshine
 * @Classname OptionTest
 * @Description 选项打印
 * @Date 2023-11-28 11:20
 * @modified By：
 * @version: 1.0$
 */
public class OptionTest {
    private static void printUsage() {
        System.err.println(
                "Usage: OptionTest [-d,--debug] [{-v,--verbose}] [{--alt}] [{--name} a_name]\n" +
                        "                  [{-s,--size} a_number] [{-f,--fraction} a_float] [a_nother]");
    }

    /**
     * -d -v --alt -s 1 -f 1.0 2.0 -n kenshine
     */
    public static void main( String[] args ) {
        // 创建CmdLineParser,并设置Option
        CmdLineParser parser = new CmdLineParser();
        Option<Boolean> debug = parser.addBooleanOption('d', "debug");
        Option<Boolean> verbose = parser.addBooleanOption('v', "verbose");
        Option<Integer> size = parser.addIntegerOption('s', "size");
        Option<Double> fraction = parser.addDoubleOption('f', "fraction");
        // 可以仅包含长参数
        Option<Boolean> alt = parser.addBooleanOption("alt");
        Option<String> name = parser.addStringOption('n', "name");


        // 解析用户提供的命令行参数，短参数 -，长参数 --
        try {
            parser.parse(args);
        }
        catch ( CmdLineParser.OptionException e) {
            System.err.println(e.getMessage());
            printUsage();
            System.exit(2);
        }


        // 只能指定0次或1次的选项
        Boolean debugValue = parser.getOptionValue(debug);
        String nameValue = parser.getOptionValue(name);

        // 指定参数默认值
        Boolean altValue = parser.getOptionValue(alt, Boolean.FALSE);
        Integer sizeValue = parser.getOptionValue(size, 42);

        // 可以指定多次的参数
        Collection<Double> fractionValues = parser.getOptionValues(fraction);

        // 循环读取多个参数
        int verbosity = 0;
        while (true) {
            Boolean verboseValue = parser.getOptionValue(verbose);

            if (verboseValue == null) {
                break;
            }
            else {
                verbosity++;
            }
        }

        // 其余的不以-开头的参数可以这样使用
        String[] otherArgs = parser.getRemainingArgs();


        // 测试，仅打印参数
        System.out.println("debug: " + debugValue);
        System.out.println("alt: " + altValue);
        System.out.println("size: " + sizeValue);
        System.out.println("name: " + nameValue);

        System.out.println("verbosity: " + verbosity);

        for (Double fractionValue : fractionValues) {
            System.out.println("fraction: " + fractionValue);
        }

        System.out.println("remaining args: ");
        for ( int i = 0; i < otherArgs.length; ++i ) {
            System.out.println(otherArgs[i]);
        }

        System.exit(0);
    }
}
