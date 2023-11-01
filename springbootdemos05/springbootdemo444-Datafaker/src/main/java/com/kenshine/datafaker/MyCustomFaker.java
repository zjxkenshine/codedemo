package com.kenshine.datafaker;

import net.datafaker.Faker;

import java.util.Locale;

public class MyCustomFaker extends Faker {

    public MyCustomFaker(Locale locale) {
        super(locale);
    }

    public Movie myMovie() {
        return getProvider(Movie.class, () -> new Movie(this));
    }

    public BookFromFile bookFromFile() {
        return getProvider(BookFromFile.class, () -> new BookFromFile(this));
    }
}