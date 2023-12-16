package com.kenshine.args4j;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.BooleanOptionHandler;
import org.kohsuke.args4j.spi.Messages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname Main
 * @Description 示例代码
 * @Date 2023-12-16 10:33
 * @modified By：
 * @version: 1.0$
 */
public class Main {
    /**
     * 定义参数及用途
     */
    @Option(name="-r",usage="recursively run something")
    private boolean recursive;

    @Option(name="-o",usage="output to this file",metaVar="OUTPUT")
    private File out = new File(".");

    @Option(name="-str")        // no usage
    private String str = "(default value)";

    @Option(name="-hidden-str2",hidden=true,usage="hidden option")
    private String hiddenStr2 = "(default value)";

    @Option(name="-n",usage="repeat <n> times\nusage can have new lines in it and also it can be verrrrrrrrrrrrrrrrrry long")
    private int num = -1;

    /**
     * 自定义handler
     */
    @Option(name="-custom",handler= BooleanOptionHandler.class,usage="boolean value for checking the custom handler")
    private boolean data;

    /**
     * 接收选项以外的其他命令行参数
     */
    @Argument
    private List<String> arguments = new ArrayList<>();

    public static void main(String[] args){
        new Main().doMain(args);
    }

    public void doMain(String[] args){
        CmdLineParser parser = new CmdLineParser(this);

        // usage信息的最大宽度，默认80
        parser.setUsageWidth(80);

        try {
            //解析参数
            parser.parseArgument(args);

            // 确认是否有额外参数
            if(arguments.isEmpty()){
                throw new CmdLineException(parser, Messages.ILLEGAL_LIST, "No argument is given");
            }
        } catch( CmdLineException e ) {
            // 异常
            System.err.println(e.getMessage());
            System.err.println("java SampleMain [options...] arguments...");
            // 打印用法
            parser.printUsage(System.err);
            System.err.println();
            return;
        }

        // 重定向到指定输出
        System.out.println(out);
        if( recursive ) {
            System.out.println("-r flag is set");
        }
        if( data ) {
            System.out.println("-custom flag is set");
        }
        System.out.println("-str was "+str);
        if( num>=0 ) {
            System.out.println("-n was "+num);
        }
        // 无选项参数
        System.out.println("other arguments are:");
        for( String s : arguments ) {
            System.out.println(s);
        }
    }
}
