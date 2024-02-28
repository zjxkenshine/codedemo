package com.kenshine.javagenerator;

import cn.binarywang.tools.generator.*;
import cn.binarywang.tools.generator.bank.BankCardNumberGenerator;
import cn.binarywang.tools.generator.bank.BankCardNumberValidator;
import cn.binarywang.tools.generator.bank.BankCardTypeEnum;
import cn.binarywang.tools.generator.bank.BankNameEnum;
import cn.binarywang.tools.generator.util.ChineseCharUtils;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname JavaGenTest
 * @Description java生成测试
 * @Date 2024-02-28 8:54
 * @modified By：
 * @version: 1.0$
 */
public class JavaGenTest {

    /**
     * 银行卡生成
     */
    @Test
    public void test01(){
        String bankCardNo = BankCardNumberGenerator.getInstance().generate();
        System.out.println(bankCardNo);
        String bankCardNo1 = BankCardNumberGenerator.generateByPrefix(436742);
        System.out.println(bankCardNo1);
        // 信用卡
        bankCardNo = BankCardNumberGenerator.generate(BankNameEnum.ICBC, BankCardTypeEnum.CREDIT);
        System.out.println(bankCardNo);
    }

    /**
     * 银行卡校验
     */
    @Test
    public void test02(){
        boolean check=BankCardNumberValidator.validate("6226118903316854");
        System.out.println(check);
    }

    /**
     * 生成一个中文字
     */
    @Test
    public void test03(){
        String result = ChineseCharUtils.genOneChineseChars();
        System.out.println(result);
        String result1 = ChineseCharUtils.genFixedLengthChineseChars(20);
        System.out.println(result1);
        char result2 = ChineseCharUtils.getOneOddChar();
        System.out.println(result2);
    }

    /**
     * 地址生成
     */
    @Test
    public void test04(){
        String generatedAddress = ChineseAddressGenerator.getInstance().generate();
        System.out.println(generatedAddress);
    }

    /**
     *  身份证号生成
     */
    @Test
    public void test05(){
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        System.out.println(idCard);
    }

    /**
     * 手机号生成
     */
    @Test
    public void test06(){
        String generatedMobileNum = ChineseMobileNumberGenerator.getInstance().generate();
        System.out.println(generatedMobileNum);
    }

    /**
     * 中文名生成
     */
    @Test
    public void test07(){
        String generatedName = ChineseNameGenerator.getInstance().generate();
        System.out.println(generatedName);
    }

    /**
     * 邮箱生成
     */
    @Test
    public void test08(){
        String generatedEmail = EmailAddressGenerator.getInstance().generate();
        System.out.println(generatedEmail);
    }

    /**
     * 英文名生成
     */
    @Test
    public void test09(){
        String generatedName = EnglishNameGenerator.getInstance().generate();
        System.out.println(generatedName);
    }

}
