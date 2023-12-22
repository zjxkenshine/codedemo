package com.kenshine.iban4j;

import org.iban4j.Bic;
import org.iban4j.BicUtil;

/**
 * @author by kenshine
 * @Classname BicTest
 * @Description iban处理
 * @Date 2023-12-22 14:35
 * @modified By：
 * @version: 1.0$
 */
public class BicTest {

    /**
     * 生成与验证Bic 标准业务代码
     */
    public static void main(String[] args) {
        Bic bic = Bic.valueOf("DEUTDEFF");
        System.out.println(bic);
        BicUtil.validate("DEUTDEFF500");
    }
}
