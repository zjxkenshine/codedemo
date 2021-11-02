package com.kenshine.drools.demo04.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 17:59
 * @description：信用卡申请信息
 * @modified By：
 * @version: $
 */
@Data
@ToString
public class CreditCardApplyInfo {
    public static final String EDUCATION_1 = "专科以下";
    public static final String EDUCATION_2 = "专科";
    public static final String EDUCATION_3 = "本科";
    public static final String EDUCATION_4 = "本科以上";

    private String name;
    private String sex;
    private int age;
    private String education;
    private String telephone;
    private double monthlyIncome = 0;//月收入
    private String address;

    private boolean hasHouse = false;//是否有房
    private boolean hasCar = false;//是否有车
    private int hasCreditCardCount = 0;//现持有信用卡数量

    private boolean checkResult = true;//审核是否通过
    private double quota = 0;//额度
}
