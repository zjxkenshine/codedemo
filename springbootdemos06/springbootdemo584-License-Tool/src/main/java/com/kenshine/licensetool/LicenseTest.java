package com.kenshine.licensetool;

import org.junit.Test;
import org.jvnet.licensetool.LicenseTool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname LicenseTest
 * @Description 开源许可证标头解析测试
 * @Date 2023-12-15 10:19
 * @modified By：
 * @version: 1.0$
 */
public class LicenseTest {

    /**
     * 校验 copyright
     */
    @Test
    public void test01(){
        List<String> args = new ArrayList<>();
        args.add("-validate");args.add("true");
        args.add("-options");args.add("checkEmpty");
        args.add("-verbose");args.add("true");
        args.add("-dryrun");args.add("false");
        args.add("-startyear");args.add("2023");
        args.add("-roots");args.add("src\\main\\resources\\test01\\check");
        args.add("-copyright"); args.add("src\\main\\resources\\test01\\copyright.txt");
        LicenseTool.main(args.toArray(new String[0]));
    }

    /**
     * 生成 copyright
     */
    @Test
    public void test02(){
        List<String> args = new ArrayList<>();
        args.add("-validate");args.add("false");
        args.add("-verbose");args.add("true");
        args.add("-dryrun");args.add("false");
        args.add("-startyear");args.add("1997");
        args.add("-endyear");args.add("2023");
        args.add("-roots");args.add("src\\main\\resources\\test02\\check");
        args.add("-copyright"); args.add("src\\main\\resources\\test02\\copyright.txt");
        LicenseTool.main(args.toArray(new String[0]));
    }
}
