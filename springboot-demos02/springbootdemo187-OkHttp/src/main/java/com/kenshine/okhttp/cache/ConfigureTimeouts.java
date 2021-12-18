package com.kenshine.okhttp.cache;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 15:26
 * @description：超时
 * @modified By：
 * @version: $
 */
public class ConfigureTimeouts {
    public OkHttpClient client;

    public ConfigureTimeouts() throws Exception {
        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public OkHttpClient getClient(){
        return this.client;
    }
}
