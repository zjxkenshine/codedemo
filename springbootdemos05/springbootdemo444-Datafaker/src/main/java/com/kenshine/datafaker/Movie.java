package com.kenshine.datafaker;

import net.datafaker.AbstractProvider;
import net.datafaker.Faker;

/**
 * @author by kenshine
 * @Classname Movie
 * @Description 自定义生成器（硬编码）
 * @Date 2023-11-01 9:00
 * @modified By：
 * @version: 1.0$
 */
public class Movie extends AbstractProvider {
    private static final String[] MOVIE_NAMES = new String[]{ "肖申克的救赎", "霸王别姬", "阿甘正传", "泰坦尼克号",
            "这个杀手不太冷", "美丽人生", "千与千寻", "辛德勒的名单", "盗梦空间", "忠犬八公的故事" };

    public Movie(Faker faker) {
        super(faker);
    }

    public String movie() {
        return MOVIE_NAMES[faker.random().nextInt(MOVIE_NAMES.length)];
    }
}




