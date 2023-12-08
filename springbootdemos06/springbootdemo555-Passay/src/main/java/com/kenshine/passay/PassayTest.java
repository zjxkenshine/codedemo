package com.kenshine.passay;

import lombok.extern.slf4j.Slf4j;
import org.cryptacular.bean.EncodingHashBean;
import org.cryptacular.spec.CodecSpec;
import org.cryptacular.spec.DigestSpec;
import org.junit.Test;
import org.passay.*;
import org.passay.dictionary.WordListDictionary;
import org.passay.dictionary.WordLists;
import org.passay.dictionary.sort.ArraysSort;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author by kenshine
 * @Classname PassayTest
 * @Description Passay使用测试
 * @Date 2023-12-08 15:12
 * @modified By：
 * @version: 1.0$
 */
@Slf4j
public class PassayTest {

    /**
     * qq 密码校验
     * 长度为8-16位、必须包含字母、数字、符号中至少两位、不包含空格
     */
    @Test
    public void test01(){
        List<Rule> rules = new ArrayList<>();
        rules.add(new LengthRule(8, 16));
        // 必须包含字母、数字、符号中至少两种
        CharacterCharacteristicsRule characteristicsRule = new CharacterCharacteristicsRule(2,
                new CharacterRule(EnglishCharacterData.Alphabetical, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1));
        rules.add(characteristicsRule);
        rules.add(new WhitespaceRule(new char[]{0x20}));

        PasswordValidator qqValidator = new PasswordValidator(rules);

        String pass = "12345678 a";
        RuleResult ruleResult = qqValidator.validate(new PasswordData(pass));
        System.out.println(ruleResult.isValid());
    }

    /**
     * gmail 密码要求
     * 长度为8-100位
     * 必须包含字母、数字、符号
     */
    @Test
    public void test02(){
        List<Rule> rules = new ArrayList<>();
        rules.add(new LengthRule(8, 100));
        // 必须包含字母、数字、符号
        CharacterCharacteristicsRule characteristicsRule = new CharacterCharacteristicsRule(3,
                new CharacterRule(EnglishCharacterData.Alphabetical, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1));
        rules.add(characteristicsRule);

        PasswordValidator gmailValidator = new PasswordValidator(rules);

        String pass = "12345678 @a";
        RuleResult ruleResult = gmailValidator.validate(new PasswordData(pass));
        System.out.println(ruleResult.isValid());
    }

    /**
     * 黑名单
     */
    @Test
    public void test03() throws IOException {
        DictionaryRule rule = new DictionaryRule(
                new WordListDictionary(WordLists.createFromReader(
                        // 读取器周围的单词列表文件
                        new FileReader[] {new FileReader("dict\\passwordblack.txt")},
                        // 区分大小写为True，否则为false
                        false,
                        // 字典必须排序
                        new ArraysSort())));

        PasswordValidator dValidator = new PasswordValidator(rule);

        RuleResult result1 = dValidator.validate(new PasswordData("!password!"));
        System.out.println(result1.isValid());
        System.out.println(dValidator.getMessages(result1));
    }


    /**
     * 密码匹配 是其中之一不通过
     */
    @Test
    public void test04(){
        List<PasswordData.Reference> history = Arrays.asList(
                // Password=P@ssword1
                new PasswordData.HistoricalReference(
                        "SHA256",
                        "j93vuQDT5ZpZ5L9FxSfeh87zznS3CM8govlLNHU8GRWG/9LjUhtbFp7Jp1Z4yS7t"),

                // Password=P@ssword2
                new PasswordData.HistoricalReference(
                        "SHA256",
                        "mhR+BHzcQXt2fOUWCy4f903AHA6LzNYKlSOQ7r9np02G/9LjUhtbFp7Jp1Z4yS7t"),

                // Password=P@ssword3
                new PasswordData.HistoricalReference(
                        "SHA256",
                        "BDr/pEo1eMmJoeP6gRKh6QMmiGAyGcddvfAHH+VJ05iG/9LjUhtbFp7Jp1Z4yS7t")
        );


        EncodingHashBean hasher = new EncodingHashBean(
                // base64编码
                new CodecSpec("Base64"),
                // 加密算法
                new DigestSpec("SHA256"),
                //hash次数
                1,
                // 是否有salt
                false);
        // DigestHistoryRule 拒绝与以前的密码相匹配的密码
        List<Rule> historyRules = Arrays.asList(
                new DigestHistoryRule(hasher));

        PasswordValidator historyValidator = new PasswordValidator(historyRules);
        PasswordData data = new PasswordData("username", "P@ssword3");
        data.setPasswordReferences(history);
        RuleResult result2 = historyValidator.validate(data);
        System.out.println(result2.isValid());
        System.out.println(historyValidator.getMessages(result2));
    }

    /**
     * 字符序列
     * passay 还支持校验字符序列，字母序列，数字序列，键盘字符qwerty序列
     */
    @Test
    public void test05(){
        List<Rule> ruleList = Arrays.asList(
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),
                new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false),
                new IllegalSequenceRule(EnglishSequenceData.USQwerty, 5, false));

        PasswordValidator seqValidator = new PasswordValidator(ruleList);
        RuleResult result3 = seqValidator.validate(new PasswordData("qwerty"));
        log.info("{}, {}", result3.isValid(), seqValidator.getMessages(result3));
    }

    /**
     * passay国际化
     */
    @Test
    public void test06() throws IOException {
        Properties props = new Properties();
        InputStream url = Files.newInputStream(Paths.get("src\\main\\resources\\message_zh_CN.properties"));
        props.load(new InputStreamReader(url, StandardCharsets.UTF_8));
        MessageResolver resolver = new PropertiesMessageResolver(props);
        PasswordValidator validator = new PasswordValidator(resolver,
                // 长度在8-16个字符之间
                new LengthRule(8, 16),
                // 至少有一个大写字母
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                // 至少有一个小写字母
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                // 至少有一个数字
                new CharacterRule(EnglishCharacterData.Digit, 1),
                // 至少有一个特殊字符
                new CharacterRule(EnglishCharacterData.Special, 1),
                // 非法：字母按序列连续出现超过5个 （>=5）
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),
                // 非法：数字按序列连续超过5个 （>=5）
                new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false),
                // 非法：按键盘布局连续相邻出现5个 （>=5）
                new IllegalSequenceRule(EnglishSequenceData.USQwerty, 5, false),
                // 不准有空白字符
                new WhitespaceRule());
        RuleResult result = validator.validate(new PasswordData("kenshine123456"));
        System.out.println(validator.getMessages(result));
    }

    /**
     * 密码生成 PasswordGenerator
     * 英文相关字符密码
     */
    @Test
    public void test07(){
        List<CharacterRule> characterRuleList = Arrays.asList(
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 2)
        );
        PasswordGenerator generator = new PasswordGenerator();
        String s = generator.generatePassword(10, characterRuleList);
        log.info("{}", s);
    }

    /**
     * 自定义字符集生成密码
     */
    @Test
    public void test08(){
        List<CharacterRule> characterRuleList = Arrays.asList(
                // 至少1个自定义中文字符集合字符
                new CharacterRule(new CharacterData() {
                    @Override
                    public String getErrorCode() {
                        return "中文error";
                    }

                    @Override
                    public String getCharacters() {
                        return "这是测试集合";
                    }
                }, 1),
                // 至少2个数字
                new CharacterRule(EnglishCharacterData.Digit, 2)
        );
        PasswordGenerator generator = new PasswordGenerator();
        String s = generator.generatePassword(10, characterRuleList);
        log.info("{}", s);
    }


}
