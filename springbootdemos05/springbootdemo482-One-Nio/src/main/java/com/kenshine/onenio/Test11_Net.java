package com.kenshine.onenio;

import one.nio.net.*;
import one.nio.os.NativeLibrary;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author by kenshine
 * @Classname Test11_Net
 * @Description 网络
 * @Date 2023-11-15 12:17
 * @modified By：
 * @version: 1.0$
 */
public class Test11_Net {

    @Test
    public void testIPv4() throws IOException {
        Socket s = Socket.create();
        s.setTimeout(3000);

        s.connect("www.baidu.com", 80);
        System.out.println("connected from " + s.getLocalAddress() + " to " + s.getRemoteAddress());
        s.close();
    }

    @Test
    public void testIPv6() throws IOException {
        Socket s = Socket.create();
        s.setTimeout(3000);

        s.connect("2a00:1450:4010:c07::71", 80);
        System.out.println("connected from " + s.getLocalAddress() + " to " + s.getRemoteAddress());

        byte[] b = new byte[1000];
        int bytes = s.read(b, 0, b.length, 0);
        System.out.println("read " + bytes + " bytes");

        s.close();
    }


}
