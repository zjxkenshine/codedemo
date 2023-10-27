package com.kensine.word;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.dictionary.DictionaryFactory;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;
import org.apdplat.word.segmentation.WordRefiner;
import org.apdplat.word.tagging.AntonymTagging;
import org.apdplat.word.tagging.PartOfSpeechTagging;
import org.apdplat.word.tagging.PinyinTagging;
import org.apdplat.word.tagging.SynonymTagging;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/28 0:32
 * @description：测试
 * @modified By：
 * @version: $
 */
public class WordTest {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        // 移除停用词
        List<Word> words = WordSegmenter.seg("杨尚川是APDPlat应用级产品开发平台的作者");
        // 保留停用词
        List<Word> words1 = WordSegmenter.segWithStopWords("杨尚川是APDPlat应用级产品开发平台的作者");
        System.out.println(words);
        System.out.println(words1);
    }

    /**
     * 对文件进行分词
     */
    @Test
    public void test02() throws Exception{
        String input = "F:\\IDEAworkespace\\codedemo\\springbootdemos05\\springbootdemo426-Word\\src\\main\\resources\\test.txt";
        String output = "F:\\IDEAworkespace\\codedemo\\springbootdemos05\\springbootdemo426-Word\\src\\main\\resources\\out.txt";
        WordSegmenter.seg(new File(input), new File(output));
        //WordSegmenter.segWithStopWords(new File(input), new File(output));
    }

    /**
     *  自定义词操作
     */
    @Test
    public void test03(){
        // 单个操作
        // 添加一个自定义词
        DictionaryFactory.getDictionary().add("kenshine");
        // 删除一个自定义词
        DictionaryFactory.getDictionary().remove("刘诗诗");
        // 批量操作
        List<String> words = new ArrayList<>();
        words.add("刘德华");
        words.add("景甜");
        words.add("赵丽颖");
        // 添加一批自定义词
        DictionaryFactory.getDictionary().addAll(words);
        // 删除一批自定义词
        DictionaryFactory.getDictionary().removeAll(words);
    }

    /**
     * 指定算法
     * SegmentationAlgorithm的可选类型为：
     * 正向最大匹配算法：MaximumMatching
     * 逆向最大匹配算法：ReverseMaximumMatching
     * 正向最小匹配算法：MinimumMatching
     * 逆向最小匹配算法：ReverseMinimumMatching
     * 双向最大匹配算法：BidirectionalMaximumMatching
     * 双向最小匹配算法：BidirectionalMinimumMatching
     * 双向最大最小匹配算法：BidirectionalMaximumMinimumMatching
     * 全切分算法：FullSegmentation
     * 最少词数算法：MinimalWordCount
     * 最大Ngram分值算法：MaxNgramScore
     */
    @Test
    public void test04(){
        List<Word> words=WordSegmenter.seg("APDPlat应用级产品开发平台", SegmentationAlgorithm.BidirectionalMaximumMatching);
        System.out.println(words);
    }

    /**
     * 词性标注
     */
    @Test
    public void test05(){
        List<Word> words = WordSegmenter.segWithStopWords("我爱中国");
        System.out.println("未标注词性："+words);
        //词性标注
        PartOfSpeechTagging.process(words);
        System.out.println("标注词性："+words);
    }

    /**
     * refine切分
     */
    @Test
    public void test06(){
        List<Word> words = WordSegmenter.segWithStopWords("我国工人阶级和广大劳动群众要更加紧密地团结在党中央周围");
        System.out.println(words);
        words = WordRefiner.refine(words);
        System.out.println(words);

        List<Word> words1 = WordSegmenter.segWithStopWords("在实现“两个一百年”奋斗目标的伟大征程上再创新的业绩");
        System.out.println(words1);
        words1 = WordRefiner.refine(words1);
        System.out.println(words1);
    }

    /**
     * 同义标注
     */
    @Test
    public void test07(){
        List<Word> words = WordSegmenter.segWithStopWords("楚离陌千方百计为无情找回记忆");
        System.out.println(words);
        // 同义词
        SynonymTagging.process(words);
        System.out.println(words);
        // 间接同义词
        SynonymTagging.process(words, false);
        System.out.println(words);
    }

    /**
     * 反义标注
     */
    @Test
    public void test08(){
        List<Word> words = WordSegmenter.segWithStopWords("5月初有哪些电影值得观看");
        System.out.println(words);
        // 反义标注
        AntonymTagging.process(words);
        System.out.println(words);
    }

    /**
     * 拼音标注
     */
    @Test
    public void test09(){
        List<Word> words = WordSegmenter.segWithStopWords("《速度与激情7》的中国内地票房自4月12日上映以来，在短短两周内突破20亿人民币");
        System.out.println(words);
        // 拼音标注
        PinyinTagging.process(words);
        System.out.println(words);
    }
}
