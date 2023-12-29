package com.kenshine.libphonenumber;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname LibphoneTest
 * @Description libphonenumber使用测试
 * @Date 2023-12-29 9:21
 * @modified By：
 * @version: 1.0$
 */
public class LibphoneTest {

    /**
     * 校验
     */
    @Test
    public void test01(){
        // 校验的号码
        String swissNumberStr = "044 668 18 00";
        // 获取 PhoneNumberUtil 实例
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            // 解析号码
            Phonenumber.PhoneNumber swissNumberProto  = phoneUtil.parse(swissNumberStr, "CH");
            // 校验号码
            boolean isVaild = phoneUtil.isValidNumber(swissNumberProto);
            System.out.println("号码校验结果：" + isVaild);
        } catch (NumberParseException e) {
            System.err.println("号码解析异常: " + e.toString());
        }
    }

    /**
     * 格式化
     */
    @Test
    public void test02() throws NumberParseException {
        // 校验的号码
        String swissNumberStr = "044 668 18 00";
        // 获取 PhoneNumberUtil 实例
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        // 解析号码
        Phonenumber.PhoneNumber swissNumberProto  = phoneUtil.parse(swissNumberStr, "CH");

        // 国际标准, 输出 "+41 44 668 18 00"
        System.out.println(phoneUtil.format(swissNumberProto, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL));
        // 国内标准, 输出 "044 668 18 00"
        System.out.println(phoneUtil.format(swissNumberProto,  PhoneNumberUtil.PhoneNumberFormat.NATIONAL));
        // E164标准, 输出 "+41446681800"
        System.out.println(phoneUtil.format(swissNumberProto,  PhoneNumberUtil.PhoneNumberFormat.E164));
        // 格式化成从美国打过来的格式，输出 "011 41 44 668 18 00"
        System.out.println(phoneUtil.formatOutOfCountryCallingNumber(swissNumberProto, "US"));
    }

}
