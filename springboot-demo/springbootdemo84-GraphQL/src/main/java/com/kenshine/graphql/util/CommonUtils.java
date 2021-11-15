package com.kenshine.graphql.util;

import java.util.UUID;

public final class CommonUtils {

    private CommonUtils() {
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
