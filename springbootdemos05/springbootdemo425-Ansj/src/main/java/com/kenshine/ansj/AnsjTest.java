package com.kenshine.ansj;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.recognition.impl.StopRecognition;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.ansj.util.MyStaticValue;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/27 23:51
 * @description：测试
 * @modified By：
 * @version: $
 */
public class AnsjTest {
    /**
     * 基本使用
     */
    @Test
    public void test01(){
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        //分词结果的一个封装，主要是一个List<Term>的terms
        Result result = ToAnalysis.parse(str);
        System.out.println(result.getTerms());
        //拿到terms
        List<Term> terms = result.getTerms();
        System.out.println(terms.size());

        for(int i=0; i<terms.size(); i++) {
            //拿到词
            String word = terms.get(i).getName();
            //拿到词性
            String natureStr = terms.get(i).getNatureStr();
            System.out.println(word + ":" + natureStr);
        }
    }

    /**
     * 指定词性
     */
    @Test
    public void test02(){
        //只关注这些词性的词
        Set<String> expectedNature = new HashSet<String>() {{
            add("n");add("v");add("vd");add("vn");add("vf");
            add("vx");add("vi");add("vl");add("vg");
            add("nt");add("nz");add("nw");add("nl");
            add("ng");add("userDefine");add("wh");
        }};
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        Result result = ToAnalysis.parse(str); //分词结果的一个封装，主要是一个List<Term>的terms
        System.out.println(result.getTerms());

        List<Term> terms = result.getTerms(); //拿到terms
        System.out.println(terms.size());

        for(int i=0; i<terms.size(); i++) {
            String word = terms.get(i).getName(); //拿到词
            String natureStr = terms.get(i).getNatureStr(); //拿到词性
            if(expectedNature.contains(natureStr)) {
                System.out.println(word + ":" + natureStr);
            }
        }
    }


    /**
     * 自定义词库
     */
    @Test
    public void test03(){
        // 关闭名字识别
        MyStaticValue.isNameRecognition = false;
        // 配置自定义词典的位置。注意是绝对路径
        MyStaticValue.ENV.put(DicLibrary.DEFAULT,"F:\\IDEAworkespace\\codedemo\\springbootdemos05\\springbootdemo425-Ansj\\src\\main\\resources\\userLibrary.dic");

        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        Result result = ToAnalysis.parse(str); //分词结果的一个封装，主要是一个List<Term>的terms
        System.out.println(result.getTerms());

        List<Term> terms = result.getTerms(); //拿到terms
        System.out.println(terms.size());

        for(int i=0; i<terms.size(); i++) {
            String word = terms.get(i).getName(); //拿到词
            String natureStr = terms.get(i).getNatureStr(); //拿到词性
            System.out.println(word + ":" + natureStr);
        }
    }

    /**
     * 自定义停用词库
     */
    @Test
    public void test04(){
        // 关闭名字识别
        MyStaticValue.isNameRecognition = false;
        // 配置自定义词典的位置。注意是绝对路径
        MyStaticValue.ENV.put(DicLibrary.DEFAULT,"F:\\IDEAworkespace\\codedemo\\springbootdemos05\\springbootdemo425-Ansj\\src\\main\\resources\\userLibrary.dic");

        //去停用词
        List<String> stopWords = getStopWords("F:\\IDEAworkespace\\codedemo\\springbootdemos05\\springbootdemo425-Ansj\\src\\main\\resources\\stopLibrary.dic");
        StopRecognition filter = new StopRecognition();
        filter.insertStopWords(stopWords);

        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        Result result = ToAnalysis.parse(str).recognition(filter); //分词结果的一个封装，主要是一个List<Term>的terms
        System.out.println(result.getTerms());

        List<Term> terms = result.getTerms(); //拿到terms
        System.out.println(terms.size());

        for(int i=0; i<terms.size(); i++) {
            String word = terms.get(i).getName(); //拿到词
            String natureStr = terms.get(i).getNatureStr(); //拿到词性
            System.out.println(word + ":" + natureStr);
        }
    }

    private List<String> getStopWords(String url) {
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        List<String> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(url);
            // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
                if (line.lastIndexOf("---") < 0) {
                    list.add(line);
                }
            }
            br.close();
            isr.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
