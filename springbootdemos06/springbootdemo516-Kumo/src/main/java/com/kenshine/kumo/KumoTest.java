package com.kenshine.kumo;

import com.kennycason.kumo.*;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.bg.PixelBoundaryBackground;
import com.kennycason.kumo.bg.RectangleBackground;
import com.kennycason.kumo.font.FontWeight;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.palette.LinearGradientColorPalette;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author by kenshine
 * @Classname KumoTest
 * @Description 使用测试
 * @Date 2023-11-30 11:07
 * @modified By：
 * @version: 1.0$
 */
public class KumoTest {

    private static String base="";

    private static Set<String> loadStopWords() throws IOException {
        return new HashSet<>(IOUtils.readLines(getInputStream("text/stop_words.txt")));
    }

    private static InputStream getInputStream(final String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }


    /**
     * 在图片上生成词云
     */
    @Test
    public void test01() throws IOException {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(300);
        frequencyAnalyzer.setMinWordLength(4);
        frequencyAnalyzer.setStopWords(loadStopWords());

        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(base+"src/main/resources/text/test.txt");
        final Dimension dimension = new Dimension(500, 312);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new PixelBoundaryBackground(base+"img/test01.png"));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1), new Color(0x40D3F1), new Color(0xFFFFFF)));
        wordCloud.setFontScalar(new LinearFontScalar(10, 40));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile(base+"output/test01.png");
    }

    /**
     * 圆形词云
     */
    @Test
    public void test02() throws IOException {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(base+"src/main/resources/text/test.txt");
        final Dimension dimension = new Dimension(600, 600);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(300));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1), new Color(0x40D3F1), new Color(0xFFFFFF)));
        wordCloud.setFontScalar(new SqrtFontScalar(10, 40));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile(base+"output/test02.png");
    }

    /**
     * 矩形词云
     */
    @Test
    public void test03() throws IOException {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(base+"src/main/resources/text/test.txt");
        final Dimension dimension = new Dimension(600, 600);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(0);
        wordCloud.setBackground(new RectangleBackground(dimension));
        wordCloud.setColorPalette(new ColorPalette(Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE));
        wordCloud.setFontScalar(new LinearFontScalar(10, 40));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile(base+"output/test03.png");
    }

    /**
     * 线性颜色渐变
     */
    @Test
    public void test04() throws IOException {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(500);
        frequencyAnalyzer.setMinWordLength(4);
        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(base+"src/main/resources/text/test.txt");
        final Dimension dimension = new Dimension(600, 600);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(300));
        // 颜色渐变
        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wordCloud.setFontScalar( new SqrtFontScalar(10, 40));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile(base+"output/test04.png");
    }

    /**
     * 中文分词
     */
    @Test
    public void test05() throws IOException {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        frequencyAnalyzer.setMinWordLength(2);
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());

        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(base+"src/main/resources/text/chinese_language.txt");
        final Dimension dimension = new Dimension(600, 600);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(300));
        wordCloud.setColorPalette(new ColorPalette(new Color(0xD5CFFA), new Color(0xBBB1FA), new Color(0x9A8CF5), new Color(0x806EF5)));
        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile(base+"output/test05.png");
    }

    /**
     * 对比两个集合
     */
    @Test
    public void test06() throws IOException {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(750);
        frequencyAnalyzer.setMinWordLength(4);
        frequencyAnalyzer.setStopWords(loadStopWords());

        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(base+"src/main/resources/text/new_york_positive.txt");
        final List<WordFrequency> wordFrequencies2 = frequencyAnalyzer.load(base+"src/main/resources/text/new_york_negative.txt");
        final Dimension dimension = new Dimension(600, 600);
        final PolarWordCloud wordCloud = new PolarWordCloud(dimension, CollisionMode.PIXEL_PERFECT, PolarBlendMode.BLUR);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(300));
        wordCloud.setFontScalar(new SqrtFontScalar(10, 40));
        wordCloud.build(wordFrequencies, wordFrequencies2);
        wordCloud.writeToFile(base+"output/test06.png");
    }

    /**
     * 分层图云
     */
    @Test
    public void test07() throws IOException {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(300);
        frequencyAnalyzer.setMinWordLength(5);
        frequencyAnalyzer.setStopWords(loadStopWords());

        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(base+"src/main/resources/text/new_york_positive.txt");
        final List<WordFrequency> wordFrequencies2 = frequencyAnalyzer.load(base+"src/main/resources/text/new_york_negative.txt");
        final Dimension dimension = new Dimension(600, 386);
        final LayeredWordCloud layeredWordCloud = new LayeredWordCloud(2, dimension, CollisionMode.PIXEL_PERFECT);

        layeredWordCloud.setPadding(0, 1);
        layeredWordCloud.setPadding(1, 1);

        layeredWordCloud.setKumoFont(0, new KumoFont("LICENSE PLATE", FontWeight.BOLD));
        layeredWordCloud.setKumoFont(1, new KumoFont("Comic Sans MS", FontWeight.BOLD));

        layeredWordCloud.setBackground(0, new PixelBoundaryBackground(base+"img/cloud_bg.bmp"));
        layeredWordCloud.setBackground(1, new PixelBoundaryBackground(base+"img/cloud_fg.bmp"));

        layeredWordCloud.setColorPalette(0, new ColorPalette(new Color(0xABEDFF), new Color(0x82E4FF), new Color(0x55D6FA)));
        layeredWordCloud.setColorPalette(1, new ColorPalette(new Color(0xFFFFFF), new Color(0xDCDDDE), new Color(0xCCCCCC)));

        layeredWordCloud.setFontScalar(0, new SqrtFontScalar(10, 40));
        layeredWordCloud.setFontScalar(1, new SqrtFontScalar(10, 40));

        layeredWordCloud.build(0, wordFrequencies);
        layeredWordCloud.build(1, wordFrequencies2);
        layeredWordCloud.writeToFile(base+"output/test07.png");
    }
}
