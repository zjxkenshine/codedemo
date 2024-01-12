package com.kenshine.matchersjson;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import wtf.g4s8.hamcrest.json.JsonValueIs;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1.5.0版本源码
 * @author kenshine
 */
public final class JsonContains extends TypeSafeMatcher<JsonArray> {

    /**
     * Matchers.
     */
    private final List<Matcher<? extends JsonValue>> matchers;

    /**
     * Match JSON array with matchers arguments.
     *
     * @param matchers Matchers
     */
    @SafeVarargs
    public JsonContains(final Matcher<? extends JsonValue>... matchers) {
        this(Arrays.asList(matchers));
    }

    /**
     * Match json array agains matcher list.
     *
     * @param matchers List of matchers
     */
    public JsonContains(final List<Matcher<? extends JsonValue>> matchers) {
        super();
        this.matchers = Collections.unmodifiableList(matchers);
    }

    public JsonContains(final Number... nums) {
        this(
            Stream.of(nums).map(JsonValueIs::new).collect(Collectors.toList())
        );
    }

    public JsonContains(final String... ints) {
        this(
            Stream.of(ints).map(JsonValueIs::new).collect(Collectors.toList())
        );
    }

    public JsonContains(final Boolean... ints) {
        this(
            Stream.of(ints).map(JsonValueIs::new).collect(Collectors.toList())
        );
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText(
            String.format("JSON array with %d items", this.matchers.size())
        );
    }

    @Override
    public boolean matchesSafely(final JsonArray item) {
        boolean matches = true;
        if (item.size() == this.matchers.size()) {
            for (int pos = 0; pos < this.matchers.size(); ++pos) {
                if (!this.matchers.get(pos).matches(item.get(pos))) {
                    matches = false;
                    break;
                }
            }
        } else {
            matches = false;
        }
        return matches;
    }
}