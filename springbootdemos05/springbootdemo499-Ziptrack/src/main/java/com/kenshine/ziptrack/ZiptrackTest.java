package com.kenshine.ziptrack;

import cmd.CmdOptions;
import cmd.GetOptions;
import org.junit.Test;
import print.engine.ZipTrackPrintEngine;
import print.parse.ParserType;
import ziptrack.ziphb.ZipHBEngine;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/19 21:14
 * @description：使用测试
 * @modified By：
 * @version: $
 */
public class ZiptrackTest {

    /**
     * ZipHBEngine
     */
    @Test
    public void test01(){
//        String args[]=null;
//        CmdOptions options = new GetOptions(args).parse();
        //ZipHBEngine.analyze(options.map_file, options.trace_file);
        ZipHBEngine.analyze("file\\map.txt","file\\trace.txt");
    }


    /**
     * ZipTrackPrintEngine
     */
    @Test
    public void test02(){
        //ParserType RV, RR, STD
        ZipTrackPrintEngine engine = new ZipTrackPrintEngine(ParserType.RV, "F:\\IDEAworkespace\\codedemo\\springbootdemos05\\springbootdemo499-Ziptrack\\file\\rv-predict", "F:\\IDEAworkespace\\codedemo\\springbootdemos05\\springbootdemo499-Ziptrack\\file\\map.txt",true);
        engine.analyzeTrace();
    }
}
