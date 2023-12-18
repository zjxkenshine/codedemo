package com.kenshine.jfairy;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.company.Company;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.person.PersonProperties;
import org.junit.Test;

import java.util.Locale;

/**
 * @author by kenshine
 * @Classname Jfairy
 * @Description Jfairysh使用测试
 * @Date 2023-12-18 9:30
 * @modified By：
 * @version: 1.0$
 */
public class JfairyTest {

    /**
     * 模拟Person生成,单独对象
     */
    @Test
    public void test01(){
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        System.out.println(person.getFirstName());
        System.out.println(person.getEmail());
        System.out.println(person.getTelephoneNumber());

        Person adultMale = fairy.person(PersonProperties.male(), PersonProperties.minAge(21));
        System.out.println(adultMale.isMale());
        System.out.println(adultMale.getDateOfBirth());
    }

    /**
     * 创建关联对象 person与company
     */
    @Test
    public void test02(){
        Fairy fairy = Fairy.create();
        Company company = fairy.company();
        System.out.println(company.getName());
        System.out.println(company.getUrl());

        Person salesman = fairy.person(PersonProperties.withCompany(company));
        System.out.println(salesman.getFullName());
        System.out.println(salesman.getCompanyEmail());
    }

    /**
     * 语言选择
     */
    @Test
    public void test03(){
        // 默认英文
        Fairy enFairy = Fairy.create();
        // 中文
        Fairy zhFairy = Fairy.create(Locale.forLanguageTag("zh"));
        Person person = zhFairy.person();
        System.out.println(person.getFirstName());
        System.out.println(person.getEmail());
        System.out.println(person.getTelephoneNumber());
    }
}
