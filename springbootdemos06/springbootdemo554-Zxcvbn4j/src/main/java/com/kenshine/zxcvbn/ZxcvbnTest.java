package com.kenshine.zxcvbn;

import com.nulabinc.zxcvbn.*;
import com.nulabinc.zxcvbn.io.ClasspathResource;
import com.nulabinc.zxcvbn.matchers.AlignedKeyboardLoader;
import com.nulabinc.zxcvbn.matchers.DictionaryLoader;
import com.nulabinc.zxcvbn.matchers.SlantedKeyboardLoader;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.Console;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author by kenshine
 * @Classname ZxcvbnTest
 * @Description 密码强度验证
 * @Date 2023-12-08 12:37
 * @modified By：
 * @version: 1.0$
 */
@Slf4j
public class ZxcvbnTest {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        Zxcvbn zxcvbn = new Zxcvbn();
        Strength strength = zxcvbn.measure("kenshine");
        log.info(
                // 破解密码所需的估计猜测
                strength.getGuesses() + "  \n  "+
                // 计算一个答案需要多长时间
                strength.getCalcTime()+"  \n  "+
                // 分数
                strength.getScore()+"  \n  "+
                // 密码
                strength.getPassword()+"  \n  "+
                // 建议
                strength.getFeedback().getSuggestions(Locale.CHINESE)+"  \n  "+
                // 破解时间，更友好的显示
                strength.getCrackTimesDisplay());
    }

    /**
     * 提供自己的词典
     */
    @Test
    public void test02(){
        List<String> sanitizedInputs = new ArrayList();
        sanitizedInputs.add("nulab");
        sanitizedInputs.add("backlog");
        sanitizedInputs.add("cacoo");
        sanitizedInputs.add("typetalk");

        Zxcvbn zxcvbn = new Zxcvbn();
        Strength strength = zxcvbn.measure("typetalk", sanitizedInputs);
        System.out.println(strength.getCalcTime());
    }

    /**
     * ClasspathResource 从文件加载字典或键盘文件
     */
    @Test
    public void test03() throws IOException {
        Zxcvbn zxcvbn = new ZxcvbnBuilder()
                .dictionary(new DictionaryLoader("us_tv_and_film", new ClasspathResource("test/testDict.txt")).load())
                .keyboard(new SlantedKeyboardLoader("qwerty", new ClasspathResource("test/qwerty.txt")).load())
                .keyboard(new AlignedKeyboardLoader("keypad", new ClasspathResource("test/keypad.txt")).load())
                .build();
        Strength strength = zxcvbn.measure("13456789");
        System.out.println(strength.getScore());
    }

    /**
     * 选项
     * StandardDictionaries
     * StandardKeyboards
     */
    @Test
    public void test04() throws IOException {
        Zxcvbn zxcvbn = new ZxcvbnBuilder()
                .dictionary(StandardDictionaries.ENGLISH_WIKIPEDIA_LOADER.load())
                .dictionary(StandardDictionaries.PASSWORDS_LOADER.load())
                .keyboard(StandardKeyboards.QWERTY_LOADER.load())
                .keyboard(StandardKeyboards.DVORAK_LOADER.load())
                .build();

        Strength strength = zxcvbn.measure("123456789");
        System.out.println(strength.getScore());
    }

    /**
     * 本地化Feedback信息
     * 暂不支持中文
     */
    @Test
    public void test05(){
        Zxcvbn zxcvbn = new Zxcvbn();
        Strength strength = zxcvbn.measure("kenshine44");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("pass", Locale.SIMPLIFIED_CHINESE);
        Feedback feedback = strength.getFeedback();

        Feedback localizedFeedback = feedback.withResourceBundle(resourceBundle);
        List<String> localizedSuggestions = localizedFeedback.getSuggestions();
        String localizedWarning = localizedFeedback.getWarning();
        System.out.println(localizedSuggestions);
        System.out.println(localizedWarning);

        List<String> localizedSuggestions1 = feedback.getSuggestions();
        String localizedWarning1 = feedback.getWarning();
        System.out.println(localizedSuggestions1);
        System.out.println(localizedWarning1);
    }


}
