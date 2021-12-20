package com.kenshine.jtidy.test;

import org.w3c.tidy.Tidy;

import java.io.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 23:00
 * @description：测试
 * @modified By：
 * @version: $
 */
public class test {

    public static void main(String args[]) {
        //转化开始
        doTidy("F:\\IDEAworkespace\\codedemo\\springboot-demos02\\springbootdemo192-JTidy\\src\\main\\resources\\html\\test.html");
    }


    public static void doTidy(String f_in) {
        //输入流
        BufferedInputStream sourceIn;
        //输出流
        ByteArrayOutputStream tidyOutStream;
        try {
            Reader reader;
            //读文件
            FileInputStream fis = new FileInputStream(f_in);
            ByteArrayOutputStream  bos = new ByteArrayOutputStream();
            int ch;
            while((ch=fis.read())!=-1) {
                bos.write(ch);
            }
            fis.close();
            byte[] bs = bos.toByteArray();
            bos.close();
            //注意，默认是GB2312，所以这里先转化成GB2312然后再转化成其他的。
            //HTML 中设置了charset则使用对应charset
//            String hope_gb2312=new String(bs,"utf-8");
//            byte[] hope_b=hope_gb2312.getBytes();
//            //将GB2312转化成UTF-8
//            String basil=new String(hope_b,"utf-8");
//            byte[] basil_b = basil.getBytes();
            ByteArrayInputStream stream = new ByteArrayInputStream(bs);
            tidyOutStream = new ByteArrayOutputStream();
            Tidy tidy=new Tidy();
            tidy.setInputEncoding("UTF-8");
            tidy.setQuiet(true);
            tidy.setOutputEncoding("UTF-8");
            //不显示警告信息
            tidy.setShowWarnings(false);
            tidy.setIndentContent(true);
            tidy.setSmartIndent(true);
            tidy.setIndentAttributes(false);
            //多长换行
            tidy.setWraplen(1024);
            //输出为xhtml
            tidy.setXHTML(true);
            tidy.setErrout(new PrintWriter(System.out));
            tidy.parse(stream, tidyOutStream);
            //将生成的xhtml写入
            DataOutputStream to=new  DataOutputStream(new FileOutputStream("F:\\IDEAworkespace\\codedemo\\springboot-demos02\\springbootdemo192-JTidy\\src\\main\\resources\\xhtml\\test.xhtml"));
            tidyOutStream.writeTo(to);
            System.out.println(tidyOutStream.toString());
        } catch(Exception ex ) {
            System.out.println( ex.toString());
            ex.printStackTrace();
        }
    }

}
