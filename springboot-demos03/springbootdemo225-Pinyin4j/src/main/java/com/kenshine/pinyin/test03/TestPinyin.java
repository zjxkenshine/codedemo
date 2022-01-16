package com.kenshine.pinyin.test03;

import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum;
import com.github.houbb.pinyin.util.PinyinHelper;
import org.junit.Test;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 12:43
 * @description：
 * @modified By：
 * @version: $
 *
 * 1.返回中文的拼音
 * 2.返回多音字列表
 * 3.分词
 * 4.PinyinStyleEnum 样式枚举
 * 5.指定连接符号
 * 6.是否为同音字
 * 7.繁体中文
 * 8.自定义词库
 * 9.自定义词组词库
 */
public class TestPinyin {

    /**
     * 1.返回中文的拼音
     */
    @Test
    public void test01(){
        String pinyin = PinyinHelper.toPinyin("我爱中文");
        System.out.println(pinyin);
    }

    /**
     * 2.返回多音字列表
     */
    @Test
    public void test02(){
        List<String> pinyinList = PinyinHelper.toPinyinList('重');
        System.out.println(pinyinList);
    }

    /**
     * 3.分词
     */
    @Test
    public void test03(){
        String pinyin = PinyinHelper.toPinyin("重庆火锅");
        System.out.println(pinyin);
        String pinyin2 = PinyinHelper.toPinyin("分词也很重要");
        System.out.println(pinyin2);
    }

    /**
     * 4.样式
     * DEFAULT	默认模式，拼音声调在韵母第一个字母上。	pīn yīn
     * NORMAL	普通模式，即不带声调。	pin yin
     * NUM_LAST	数字标注模式，即拼音声调以数字形式在各个拼音之后，用数字 1-5 进行表示。	pin1 yin1
     * FIRST_LETTER	首字母模式，只返回拼音的首字母部分。	p y
     * INPUT	键盘输入模式，使用 v 替代 ü。
     */
    @Test
    public void test04(){
        //有音标
        String py1 = PinyinHelper.toPinyin("我爱中文", PinyinStyleEnum.DEFAULT);
        System.out.println(py1);

        //无音标
        String py2 = PinyinHelper.toPinyin("我爱中文", PinyinStyleEnum.NORMAL);
        System.out.println(py2);

        //音标在最后
        String py3 = PinyinHelper.toPinyin("我爱中文", PinyinStyleEnum.NUM_LAST);
        System.out.println(py3);

        //首字母
        String py4 = PinyinHelper.toPinyin("我爱中文", PinyinStyleEnum.FIRST_LETTER);
        System.out.println(py4);

        //v 代替 ü
        String py5 = PinyinHelper.toPinyin("去聚餐", PinyinStyleEnum.INPUT);
        System.out.println(py5);
    }

    /**
     * 5.指定连接符号
     */
    @Test
    public void test05(){
        final String text = "我爱中文";
        System.out.println(PinyinHelper.toPinyin(text, PinyinStyleEnum.FIRST_LETTER,"-"));
    }

    /**
     * 6.是否为同音字
     * PinyinHelper.hasSamePinyin()
     */
    @Test
    public void test06(){
        char one = '花';
        char two = '重';
        char three = '中';
        char four = '虫';

        System.out.println(PinyinHelper.hasSamePinyin(one, three));
        System.out.println(PinyinHelper.hasSamePinyin(two, three));
        System.out.println(PinyinHelper.hasSamePinyin(two, four));
    }

    /**
     * 7.繁体中文
     */
    @Test
    public void test07(){
        String pinyin = PinyinHelper.toPinyin("奮斗");
        System.out.println(pinyin);
    }

    /**
     * 8.自定义拼音词库
     * resources/pinyin_dict_char_define.txt
     */
    @Test
    public void test08(){
        String pinyin = PinyinHelper.toPinyin("莪");
        System.out.println(pinyin);
    }

    /**
     * 9.自定义词组词库
     */
    @Test
    public void test09(){
        String pinyin = PinyinHelper.toPinyin("莪噯褈慶炎鍋");
        System.out.println(pinyin);
    }
}
