package com.kenshine.commonrandom;

import com.apifan.common.random.RandomSource;
import com.apifan.common.random.constant.CreditCardType;
import com.apifan.common.random.constant.Province;
import com.apifan.common.random.entity.Poem;
import com.apifan.common.random.source.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname RandomTest01
 * @Description 测试
 * @Date 2023-12-25 16:43
 * @modified By：
 * @version: 1.0$
 */
public class RandomTest01 {

    /**
     * 统一入口
     */
    @Test
    public void test01(){
        //地区类虚拟数据
        AreaSource areaSource = RandomSource.areaSource();
        //日期时间类虚拟数据
        DateTimeSource dateTimeSource = RandomSource.dateTimeSource();
        //教育类虚拟数据
        EducationSource educationSource = RandomSource.educationSource();
        //金融类虚拟数据
        FinancialSource financialSource = RandomSource.financialSource();
        //互联网信息类虚拟数据
        InternetSource internetSource = RandomSource.internetSource();
        //数字类虚拟数据
        NumberSource numberSource = RandomSource.numberSource();
        //个人类虚拟数据
        PersonInfoSource personInfoSource = RandomSource.personInfoSource();
        //体育竞技类虚拟数据
        SportSource sportSource = RandomSource.sportSource();
        //语言文字类虚拟数据
        LanguageSource languageSource = RandomSource.languageSource();
        //其它杂项虚拟数据
        OtherSource otherSource = RandomSource.otherSource();
    }

    /**
     * 随机数字
     */
    @Test
    public void test02_Num(){
        //生成1个1~101(不含)之间的随机整数
        int a = RandomSource.numberSource().randomInt(1, 101);
        //生成8个1~101(不含)之间的随机整数
        int[] b = RandomSource.numberSource().randomInt(1, 101, 8);
        //生成1个10000000000~20000000001(不含)之间的随机长整数
        long c = RandomSource.numberSource().randomLong(10000000000L, 20000000001L);
        //生成9个10000000000~20000000001(不含)之间的随机长整数
        long[] d = RandomSource.numberSource().randomLong(10000000000L, 20000000001L, 9);
        //生成1个0.01~0.51(不含)之间的随机整数
        double e = RandomSource.numberSource().randomDouble(0.01D, 0.51D);
        //生成8个0.01~0.51(不含)之间的随机整数
        double[] f = RandomSource.numberSource().randomDouble(0.01D, 0.51D, 8);
        //生成随机百分比
        BigDecimal percent = RandomSource.numberSource().randomPercent();
        System.out.println(a);
        System.out.println(Arrays.stream(b).boxed().collect(Collectors.toList()));
        System.out.println(c);
        System.out.println(Arrays.stream(d).boxed().collect(Collectors.toList()));
        System.out.println(e);
        System.out.println(Arrays.stream(f).boxed().collect(Collectors.toList()));
    }

    /**
     * 汉字、成语、唐诗生成
     */
    @Test
    public void test03_Hz(){
        //生成1个随机汉字
        String a = RandomSource.languageSource().randomChinese();
        //生成4个随机汉字
        String b = RandomSource.languageSource().randomChinese(4);
        System.out.println(a);
        System.out.println(b);
        String c=RandomSource.languageSource().randomChineseIdiom();
        Poem poem=RandomSource.languageSource().randomTangPoem();
        System.out.println(c);
        System.out.println(poem);
    }

    /**
     * 随机人名
     */
    @Test
    public void test04_Name(){
        //生成1个随机中文人名(性别随机)
        String a=RandomSource.personInfoSource().randomChineseName();
        //生成1个随机男性中文人名
        String b=RandomSource.personInfoSource().randomMaleChineseName();
        //生成1个随机女性中文人名
        String c=RandomSource.personInfoSource().randomFemaleChineseName();
        //生成1个随机英文人名
        String d=RandomSource.personInfoSource().randomEnglishName();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    /**
     * 随机身份证
     */
    @Test
    public void test05_IdCard(){
        //生成1个随机的虚拟身份证号码，地区为广西壮族自治区，男性，出生日期在1990年11月11日至1999年12月12日之间
        LocalDate beginDate = LocalDate.of(1990,11,11);
        LocalDate endDate = LocalDate.of(1999,12,12);
        String id1 = RandomSource.personInfoSource().randomMaleIdCard(Province.GX, beginDate, endDate);
        //生成1个随机的虚拟身份证号码，地区为河北省，女性，出生日期在2001年1月11日至2008年2月22日之间
        LocalDate beginDate2 = LocalDate.of(2001,1,11);
        LocalDate endDate2 = LocalDate.of(2008,2,22);
        String id2 = RandomSource.personInfoSource().randomFemaleIdCard(Province.HE, beginDate2, endDate2);
        //生成1个随机的虚拟身份证号码，地区为广西壮族自治区，男性，年龄为18岁
        String id3 = RandomSource.personInfoSource().randomMaleIdCard(Province.GX, 18);
        //生成1个随机的虚拟身份证号码，地区为河北省，女性，年龄为19岁
        String id4 = RandomSource.personInfoSource().randomFemaleIdCard(Province.HE, 19);
        System.out.println(id1);
        System.out.println(id2);
        System.out.println(id3);
        System.out.println(id4);
    }

    /**
     * 银行卡
     */
    @Test
    public void test06_Credit(){
        //生成1个随机虚拟VISA信用卡号码
        String cc1 = RandomSource.financialSource().randomCreditCardNo(CreditCardType.Visa);
        //生成1个随机虚拟MasterCard信用卡号码
        String cc2 = RandomSource.financialSource().randomCreditCardNo(CreditCardType.MasterCard);
        //生成1个随机虚拟American Express信用卡号码
        String cc3 = RandomSource.financialSource().randomCreditCardNo(CreditCardType.Amex);
        //生成1个随机虚拟银联信用卡号码
        String cc4 = RandomSource.financialSource().randomCreditCardNo(CreditCardType.UnionPay);
        //生成1个随机虚拟JCB信用卡号码
        String cc5 = RandomSource.financialSource().randomCreditCardNo(CreditCardType.JCB);
        System.out.println(cc1);
        System.out.println(cc2);
        System.out.println(cc3);
        System.out.println(cc4);
        System.out.println(cc5);
    }

}
