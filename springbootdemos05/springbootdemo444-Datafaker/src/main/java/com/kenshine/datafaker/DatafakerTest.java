package com.kenshine.datafaker;

import net.datafaker.*;
import net.datafaker.fileformats.Format;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

/**
 * @author by kenshine
 * @Classname Test01
 * @Description 使用测试
 * @Date 2023-11-01 8:50
 * @modified By：
 * @version: 1.0$
 */
public class DatafakerTest {
    Logger logger = LoggerFactory.getLogger(DatafakerTest.class);

    /**
     * 基本生成
     * net.datafaker下还有很多
     */
    @Test
    public void test01(){
        Faker faker = new Faker(Locale.CHINA);
        // 名称
        Name name = faker.name();
        logger.info("{}", name.name());
        // 电话
        PhoneNumber phoneNumber = faker.phoneNumber();
        logger.info("{}", phoneNumber.cellPhone());
        // 地点
        Address address = faker.address();
        logger.info("{}, {}, {}", address.state(), address.city(), address.streetAddress());
        // 时间
        DateAndTime date = faker.date();
        logger.info("{}, {}", date.birthday("yyyy年MM月dd日HH时mm分ss秒"), date.between(Timestamp.valueOf("2000-01-01 00:00:00"), Timestamp.valueOf("2099-12-31 23:59:59")));
        // 大学
        University university = faker.university();
        logger.info("{}", university.name());
        // 山
        Mountain mountain= faker.mountain();
        logger.info("{}",mountain.name());
        // 动物
        Animal animal = faker.animal();
        logger.info("{}",animal.name());
    }

    /**
     * 集合
     */
    @Test
    public void test02(){
        Faker faker = new Faker(Locale.CHINA);
        // 随机生成3-5个姓名
        List<String> names =
                faker.collection(() -> faker.name().name())
                        .len(3, 5)
                        .generate();
        logger.info("{}", names);

        // 随机生成10个身份证号码，其中 30% 为null
        List<String> ids = faker.collection(() -> faker.idNumber().validZhCNSsn()).len(10).nullRate(0.3).generate();
        logger.info("{}", ids);
    }


    /**
     * 自定义生成(硬编码)
     */
    @Test
    public void testFaker() {
        MyCustomFaker customFaker = new MyCustomFaker(Locale.CHINA);
        Movie movie = customFaker.myMovie();
        logger.info("{}", movie.movie());
    }

    /**
     * 自定义生成(配置文件)
     */
    @Test
    public void testFaker2() {
        MyCustomFaker customFaker = new MyCustomFaker(Locale.CHINA);
        BookFromFile bookFromFile = customFaker.bookFromFile();
        logger.info("{}, {}", bookFromFile.names(), bookFromFile.authors());
    }


    /**
     * 表达式
     */
    @Test
    public void testExpression(){
        Faker faker = new Faker(Locale.CHINA);
        // 将?替换为随机字母
        String e1 = faker.expression("#{letterify 'test????test'}");
        // 将#替换为随机数字
        String e2 = faker.expression("#{numerify '#test#'}");
        // 上述组合
        String e3 = faker.expression("#{bothify '?#?#?#?#'}");
        // 能够调用其他Provider类
        String e4 = faker.expression("#{Name.last_name}#{Name.first_name}");
        // 能够将字符替换
        String e5 = faker.expression("#{templatify 'test','t','q','@'}");
        logger.info("{}, {}, {}, {}, {}", e1, e2, e3, e4, e5);
    }

    /**
     * 生成Json数据
     */
    @Test
    public void testJson(){
        Faker faker = new Faker(Locale.CHINA);
        String json = Format.toJson(
                faker.collection(faker::name)
                        .len(2)
                        .build())
                .set("firstName", Name::firstName)
                .set("lastName", Name::lastName)
                .build()
                .generate();
        logger.info("{}", json);
    }




}
