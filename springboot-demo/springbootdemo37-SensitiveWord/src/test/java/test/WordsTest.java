package test;

import com.kenshine.sensitive.util.KeyWordsUtils;
import org.junit.Test;
import toolgood.words.IllegalWordsSearch;
import toolgood.words.StringSearch;
import toolgood.words.StringSearchEx;
import toolgood.words.StringSearchEx2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 23:36
 * @description：测试
 * @modified By：
 * @version: $
 */
public class WordsTest {
    List<String> keyWords = KeyWordsUtils.loadKeywords(new File("F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo37-SensitiveWord\\src\\main\\resources\\sensi_words.txt"));


    /**
     * 判断是否是敏感词
     */
    @Test
    public void testStringSearch(){
        StringSearch stringSearch = new StringSearch();
        stringSearch.SetKeywords(keyWords);

        //判断是否有敏感词
        boolean result = stringSearch.ContainsAny("淫荡少妇白洁打飞机");
        System.out.println(result);
        //找到第一个
        System.out.println(stringSearch.FindFirst("淫荡少妇白洁打飞机"));
        //匹配所有
        System.out.println(stringSearch.FindAll("淫荡少妇白洁打飞机"));
        //替换敏感词
        System.out.println(stringSearch.Replace("淫荡少妇白洁打飞机kenshine666"));
    }

    /**
     * StringSearchEx 效率更高
     * StringSearchEx2 有问题
     */
    @Test
    public void testStringSearchEx(){
        StringSearchEx stringSearch = new StringSearchEx();
        stringSearch.SetKeywords(keyWords);

        //判断是否有敏感词
        boolean result = stringSearch.ContainsAny("淫荡少妇白洁打飞机");
        System.out.println(result);
        //找到第一个
        System.out.println(stringSearch.FindFirst("淫荡少妇白洁打飞机"));
        //匹配所有
        System.out.println(stringSearch.FindAll("淫荡少妇白洁打飞机"));
        //替换敏感词
        System.out.println(stringSearch.Replace("淫荡少妇白洁打飞机kenshine666"));
    }


    @Test
    public void testStringSearchEx2(){
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("中国");
        list.add("国人");
        list.add("zg人");
        System.out.println("StringSearchEx2 run Test.");

        StringSearchEx2 iwords = new StringSearchEx2();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        String f = iwords.FindFirst(test);
        if (f != "中国") {
            System.out.println("FindFirst is Error.");
        }

        List<String> all = iwords.FindAll(test);
        if (all.get(0) != "中国") {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1) != "国人") {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

}
