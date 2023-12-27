package com.kenshine.jsonvalidator;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;

import java.io.IOException;

/**
 * @author kenshine
 * 工具类
 */
public final class Utils {
    private static final String PKGBASE;

    static {
        final String pkgName = Utils.class.getPackage().getName();
        PKGBASE = '/' + pkgName.replace(".", "/");
    }

    private Utils(){}

    /**
     * 从资源目录加载JsonNode
     */
    public static JsonNode loadResource(final String name) throws IOException {
        return JsonLoader.fromResource(name);
    }
}