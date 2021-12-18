package com.kenshine.okhttp.cache;

import okhttp3.*;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 15:33
 * @description：身份认证
 * @modified By：
 * @version: $
 */
public class Authenticate {
    public OkHttpClient client;

    public Authenticate() throws Exception {
        client = new OkHttpClient.Builder()
                .authenticator(new Authenticator() {
                    @Override public Request authenticate(Route route, Response response) throws IOException {
                        if (response.request().header("Authorization") != null) {
                            return null; // Give up, we've already attempted to authenticate.
                        }

                        System.out.println("Authenticating for response: " + response);
                        System.out.println("Challenges: " + response.challenges());
                        String credential = Credentials.basic("jesse", "password1");
                        return response.request().newBuilder()
                                .header("Authorization", credential)
                                .build();
                    }
                })
                .build();
    }
    public OkHttpClient getClient(){
        return this.client;
    }
}
