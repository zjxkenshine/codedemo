package com.kenshine.jodamoney;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author by kenshine
 * @Classname MoneyTest
 * @Description joda money 金额转换
 * @Date 2024-01-08 12:37
 * @modified By：
 * @version: 1.0$
 */
public class MoneyTest {

    public static void main(String[] args) {
        // 创建金额
        Money money = Money.parse("USD 23.87");
        // 创建金额
        Money money2 = Money.parse("USD 33.87");

        // 转换double类型
        CurrencyUnit usd = CurrencyUnit.of("USD");
        money = money.plus(Money.of(usd, 12.43d));

        // 减去金额
        money = money.minusMajor(2);
        // 乘3.5并取整
        money = money.multipliedBy(3.5d, RoundingMode.DOWN);
        // 金额比较 money是否比money2大
        boolean bigAmount = money.isGreaterThan(money2);
        System.out.println(bigAmount);

        // 转换为人民币
        // 设置转换率
        BigDecimal conversionRate =BigDecimal.valueOf(7.1574D);
        // HALF_UP取整规则
        Money moneyCNY = money.convertedTo(CurrencyUnit.of("CNY"), conversionRate, RoundingMode.HALF_UP);
        System.out.println("美元："+money);
        System.out.println("人民币："+moneyCNY.getAmount());

        // BigMoney可进行更复杂计算
        BigMoney moneyCalc = money.toBigMoney();
    }

}
