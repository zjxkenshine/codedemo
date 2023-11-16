package com.kenshine.pinyin2hanzi;

import com.mininglamp.nlp.hmm.Pinyin2Hanzi;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname TestPinyin2Hanzi
 * @Description 使用测试
 * @Date 2023-11-16 13:25
 * @modified By：
 * @version: 1.0$
 */
public class TestPinyin2Hanzi {

    /**
     * 测试pinyin转汉字
     */
    @Test
    public void testPinyin2Hanzi(){
        // 加载模型
        String modelPath = "F:\\pinyin2hanzi\\hmm_model";
        Pinyin2Hanzi.loadModel(modelPath);
        // 执行转换
        String pinyin = "zaijian";
        // 候选的拼音分割输出个数2 候选的汉字序列输出个数10
        List<List<String>> result=Pinyin2Hanzi.transform(pinyin, 2, 10);
        // [[在吉安, 在即按, 在即安, 在击案, 在积案, 在济安, 在机安, 在继安, 在集安, 在季安], [在建, 再见, 再建, 在监, 在减, 在检, 在坚, 在柬, 灾减, 在健]]
        System.out.println(result);
    }
}
