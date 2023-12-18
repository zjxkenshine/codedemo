package com.kenshine.catchtest;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class ExceptionCodeMatches extends TypeSafeMatcher<CustomException> {

    private int expectedCode;

    public ExceptionCodeMatches(int expectedCode) {
        this.expectedCode = expectedCode;
    }

    @Override
    protected boolean matchesSafely(CustomException item) {
        return item.getCode() == expectedCode;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("expects code ")
                .appendValue(expectedCode);
    }

    @Override
    protected void describeMismatchSafely(CustomException item, Description mismatchDescription) {
        mismatchDescription.appendText("was ")
                .appendValue(item.getCode());
    }
}
