package com.kenshine.soot.test03;

import soot.Body;
import soot.BodyTransformer;

import java.util.Map;

/**
 * 添加
 */
public class GotoInstrumenter extends BodyTransformer {
    private static GotoInstrumenter instance = new GotoInstrumenter();

    private GotoInstrumenter() {
    }

    @Override
    protected void internalTransform(Body body, String s, Map<String, String> map) {

    }

    public static GotoInstrumenter v() {
        return instance;
    }
}