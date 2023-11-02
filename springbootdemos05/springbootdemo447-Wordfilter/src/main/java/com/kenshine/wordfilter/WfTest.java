package com.kenshine.wordfilter;

import com.startx.http.wordfilter.WordContext;
import com.startx.http.wordfilter.WordFilter;
import com.startx.http.wordfilter.WordType;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author by kenshine
 * @Classname TestReplace
 * @Description 测试
 * @Date 2023-11-02 8:40
 * @modified By：
 * @version: 1.0$
 */
public class WfTest {
    /**
     * 词库上下文环境
     */
    private WordContext context = new WordContext();
    private WordFilter filter = new WordFilter(context);

    /**
     * 测试替换敏感词
     */
    @Test
    public void test01() {
            String text = "我们决定紧急征调5000人前往宅区帮助灾民，并且决定为紧急事件打开绿灯";
            String result = filter.replace(text);
            //我们决定**征调5000人前往宅区帮助灾民，并且决定为紧急事件打开绿灯
            System.out.println(result);
    }

    /**
     * 添加敏感词
     * skip
     */
    @Test
    public void test02(){
        //临时添加敏感词
        context.addWord(Collections.singletonList("5000"), WordType.BLACK);
        // skip为1的过滤
        String text = "我们决定紧x急征调5000人前往宅区帮助灾民，并且决定为紧急x事x件打开绿灯，紧急";
        String result = filter.replace(text, 1, '*');
        System.out.println(result);
    }

    @Test
    public void test03(){
        //此处将5000移出黑名单（若黑名单没有该词组将忽略)
        try{
            context.removeWord(Collections.singletonList("5000"), WordType.BLACK);
        }catch (Exception e){ }
        //此处将紧急事件移出白名单（若白名单没有该词组将忽略）
        context.removeWord(Collections.singletonList("紧急事件"), WordType.WHITE);
        String text = "我们决定紧x急征调5000人前往宅区帮助灾民，并且决定为紧急x事x件打开绿灯";
        String result = filter.replace(text, 1, '*');
        //我们决定*x*征调5000人前往宅区帮助灾民，并且决定为**x事x件打开绿灯
        System.out.println(result);
    }

    /**
     *  测试是否包含敏感词
     */
    @Test
    public void test04(){
        String text = "我小时候有个朋友叫张三，现在和他几乎没联系了";
        boolean result = filter.include(text);
        //true
        System.out.println(result);
    }

    /**
     * skip=1 包含
     */
    @Test
    public void test05(){
        String text = "我小时候有个朋友叫张大三，现在和他几乎没联系了";
        boolean result = filter.include(text, 1);
        //true
        System.out.println(result);
    }

    /**
     * 统计数量
     */
    @Test
    public void test06(){
        String text = "我小时候有个朋友叫张三，现在和他几乎没联系了";
        int result = filter.wordCount(text);
        //1
        System.out.println(result);
    }

    @Test
    public void test07(){
        String text = "我小时候有个朋友叫张大三，现在和他几乎没联系了";
        int result = filter.wordCount(text, 1);
        //1
        System.out.println(result);
    }

    /**
     * 列表
     */
    @Test
    public void test08(){
        String text = "我小时候有个朋友叫张三，现在和他几乎没联系了";
        List<String> words = filter.wordList(text);
        //[张三]
        System.out.println(words);
    }
}
