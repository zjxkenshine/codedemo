package com.kenshine.iban4j;

import org.iban4j.*;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname IbanTest
 * @Description Iban验证
 * @Date 2023-12-22 14:35
 * @modified By：
 * @version: 1.0$
 */
public class IbanTest {


    /**
     * 生成与验证iban
     */
    @Test
    public void test01(){
        // 生成iBan
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.AT)
                .bankCode("19043")
                .accountNumber("00234573201")
                .build();
        // 从String转换
        Iban iban1 = Iban.valueOf("DE89370400440532013000");
        // 格式化
        Iban iban2 = Iban.valueOf("DE89 3704 0044 0532 0130 00", IbanFormat.Default);
        // 随机Iban
        Iban iban3 = Iban.random(CountryCode.AT);
        Iban iban4 = Iban.random();
        Iban iban5 = new Iban.Builder()
                .countryCode(CountryCode.AT)
                .bankCode("19043")
                .buildRandom();

        System.out.println(iban);
        System.out.println(iban1);
        System.out.println(iban2);
        System.out.println(iban3);
        System.out.println(iban4);
        System.out.println(iban5);
        try {
            // 验证iban
            IbanUtil.validate("AT611904300234573201");
            IbanUtil.validate("DE89 3704 0044 0532 0130 00", IbanFormat.Default);
        } catch (IbanFormatException |
                InvalidCheckDigitException |
                UnsupportedCountryException ignored) {
        }
    }

    /**
     * leftPadding 填充
     */
    @Test
    public void test02(){
        // 用零填充（“账号”、“银行代码”和“分行代码”）
        Iban iban1=new Iban.Builder()
                .leftPadding(true)
                .countryCode(CountryCode.DE)
                .bankCode("66280099")
                .accountNumber("123456700")
                .build();
        System.out.println(iban1);

        //如何将默认填充字符（“0”）更改为其他
        Iban iban2=new Iban.Builder()
                .leftPadding(true)
                .paddingCharacter('1')
                .countryCode(CountryCode.DE)
                .bankCode("66280099")
                .accountNumber("123456700")
                .build();
        System.out.println(iban2);
    }
}
