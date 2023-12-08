package com.kenshine;

import edu.vt.middleware.password.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname VtpasswordTest
 * @Description Vtpassword使用测试
 * @Date 2023-12-08 18:23
 * @modified By：
 * @version: 1.0$
 */
public class VtpasswordTest {

    /**
     * 简单使用
     */
    @Test
    public void test(){
        PasswordData passwordData = new PasswordData(new Password("12345678a"));
        List<Rule> rules = new ArrayList<>();
        rules.add(new LengthRule(8, 16));
        // 必须包含小写字母、数字、符号中至少两种
        CharacterCharacteristicsRule characteristicsRule = new CharacterCharacteristicsRule();
        // 需满足的特征数量
        characteristicsRule.setNumberOfCharacteristics(2);
        // 规则
        characteristicsRule.setRules(Arrays.asList(
                new AlphabeticalCharacterRule(1),
                new DigitCharacterRule(1),
                new LowercaseCharacterRule(1)
        ));
        // 添加规则
        rules.add(characteristicsRule);
        // 校验密码是否包含空白字符的规则
        rules.add(new WhitespaceRule());

        PasswordValidator qqValidator = new PasswordValidator(rules);
        RuleResult ruleResult = qqValidator.validate(passwordData);
        System.out.println(ruleResult.isValid());
    }

}
