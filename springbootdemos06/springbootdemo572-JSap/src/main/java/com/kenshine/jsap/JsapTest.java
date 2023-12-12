package com.kenshine.jsap;

import com.martiansoftware.jsap.*;
import com.martiansoftware.jsap.stringparsers.IntegerStringParser;
import com.martiansoftware.jsap.stringparsers.StringStringParser;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname JsapTest
 * @Description jsap使用测试
 * @Date 2023-12-12 11:57
 * @modified By：
 * @version: 1.0$
 */
public class JsapTest {


    /**
     * 解析[--verbose] {-n|--number} Mynumber"
     */
    @Test
    public void test01() throws JSAPException {
        String[] args=new String[]{"--verbose","--number","11"};
        JSAP myJSAP = new JSAP();
        myJSAP.registerParameter( new Switch( "verboseSwitch", JSAP.NO_SHORTFLAG,
                "verbose" ) );
        myJSAP.registerParameter( new FlaggedOption( "numberOption", IntegerStringParser.getParser(), JSAP.NO_DEFAULT,
                JSAP.NOT_REQUIRED, 'n', "number" ) );
        JSAPResult result = myJSAP.parse(args);
        // verboseSwitch值
        System.out.println(result.getBoolean("verboseSwitch"));
        // numberOption值
       System.out.println(result.getInt("numberOption"));
    }

    /**
     * CommandLineTokenizer 命令行拆分
     */
    @Test
    public void test02(){
        String cmdLine = "this is a test";
        String[] tokens = CommandLineTokenizer.tokenize(cmdLine);
        for(String s:tokens){
            System.out.println(s);
        }
    }

    /**
     * 短标志
     * 长标志单参数
     * 无标志参数
     */
    @Test
    public void test03() throws JSAPException {
        String cmdLine = "-a -b --field1 hello field2";
        String[] tokens = CommandLineTokenizer.tokenize(cmdLine);

        JSAP jsap = new JSAP();
        // 创建AB Switch
        Switch a = new Switch("a");
        a.setShortFlag('a');
        jsap.registerParameter(a);
        Switch b = new Switch("b");
        b.setShortFlag('b');
        jsap.registerParameter(b);
        // 单个参数
        FlaggedOption field1 = new FlaggedOption("field1");
        field1.setLongFlag("field1");
        // 默认参数
        field1.setDefault("field1-default");
        jsap.registerParameter(field1);
        // 选项参数
        UnflaggedOption field2 = new UnflaggedOption("field2");
        field2.setGreedy(true);
        jsap.registerParameter(field2);

        JSAPResult result=jsap.parse(tokens);
        System.out.println(result.getString("field1"));
        System.out.println(result.getBoolean("a"));
        System.out.println(result.getBoolean("b"));
        System.out.println(result.getString("field2"));
    }

    /**
     * Parser 参数类型转换
     */
    @Test
    public void test04(){
        FlaggedOption opt = new FlaggedOption("flagged");
        opt.setShortFlag('f');
        opt.setLongFlag("longflag");
        opt.setStringParser(StringStringParser.getParser());
        JSAP jsap = new JSAP();

        FlaggedOption opt2 = new FlaggedOption("flaggedInteger");
        opt2.setLongFlag("integer");
        // jit转string
        opt2.setStringParser(IntegerStringParser.getParser());

        try {
            jsap.registerParameter(opt);
            jsap.registerParameter(opt2);
        } catch (JSAPException je) {
            je.printStackTrace();
        }

        String[] args = { "-f", "myflagthing", "--integer", "42" };
        JSAPResult result = null;
        try {
            result = jsap.parse(args);
            System.out.println(result.success());
            System.out.println(result.getString("flagged"));
            System.out.println(result.getString("flaggedInteger"));
        } catch (Exception je2) {
            je2.printStackTrace();
        }
    }
}
