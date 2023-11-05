package com.kenshine.nlphanzisimilar;

import com.github.houbb.nlp.hanzi.similar.bs.HanziSimilarBs;
import com.github.houbb.nlp.hanzi.similar.util.HanziSimilarHelper;
import org.junit.Test;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/5 22:43
 * @description：测试
 * @modified By：
 * @version: $
 */
public class NHSTest {

    /**
     * 是否相似
     */
    @Test
    public void test01(){
        double rate1 = HanziSimilarHelper.similar('末', '未');
        System.out.println(rate1);
    }

    /**
     * 自定义权重
     */
    @Test
    public void test02(){
        double rate = HanziSimilarBs.newInstance()
                .jiegouRate(10)
                .sijiaoRate(8)
                .bushouRate(6)
                .bihuashuRate(2)
                .pinyinRate(1)
                .chaiziRate(8)
                .similar('末', '未');
        System.out.println(rate);
    }

    /**
     * 返回10个相似的汉字
     */
    @Test
    public void test03(){
        List<String> list = HanziSimilarHelper.similarList('爱');
        System.out.println(list.toString());
    }

    /**
     * 自定义相似度
     */
    @Test
    public void test04(){
        double rate1 = HanziSimilarHelper.similar('人', '入');
        System.out.println(rate1);
    }

}
