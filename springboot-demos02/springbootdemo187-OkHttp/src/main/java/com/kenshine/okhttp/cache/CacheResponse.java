package com.kenshine.okhttp.cache;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

import java.io.File;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 15:13
 * @description：缓存
 * @modified By：
 * @version: $
 */
public class CacheResponse {
    public OkHttpClient client;

    public CacheResponse(File cacheDirectory) throws Exception {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(cacheDirectory, cacheSize);

        client = new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    public OkHttpClient getClient(){
        return this.client;
    }



}
