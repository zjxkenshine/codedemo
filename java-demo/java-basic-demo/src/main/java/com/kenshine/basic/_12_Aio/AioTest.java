package com.kenshine.basic._12_Aio;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/12 13:05
 * @description：
 * @modified By：
 * @version: $
 */
public class AioTest {
    @Test
    public void testServer() throws IOException, InterruptedException {
        SimpleServer server = new SimpleServer(7788);
        Thread.sleep(10000);
    }

    @Test
    public void testClient() throws IOException, InterruptedException, ExecutionException {
        SimpleClient client = new SimpleClient("localhost", 7788);
        client.write((byte) 11);
    }
}
