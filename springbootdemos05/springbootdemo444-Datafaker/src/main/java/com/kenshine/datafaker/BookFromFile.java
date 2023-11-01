package com.kenshine.datafaker;

import net.datafaker.AbstractProvider;
import net.datafaker.Faker;

import java.nio.file.Paths;
import java.util.Locale;

public class BookFromFile extends AbstractProvider {
    private static final String KEY = "books";

    public BookFromFile(Faker faker) {
        super(faker);
        faker.addPath(Locale.CHINA, Paths.get("src\\main\\resources\\fake\\book.yml"));
    }

    public String names() {
        return faker.resolve(KEY + ".names");
    }
    public String authors() {
        return faker.resolve(KEY + ".authors");
    }
}