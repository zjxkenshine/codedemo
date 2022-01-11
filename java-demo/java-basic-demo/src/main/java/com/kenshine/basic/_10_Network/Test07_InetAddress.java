package com.kenshine.basic._10_Network;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 20:10
 * @description：
 * @modified By：
 * @version: $
 */
public class Test07_InetAddress {
    public static void main(String[] args) {
        try {
            //对应着具体的ip地址
            InetAddress inetAddress1=InetAddress.getByName("123.56.174.57");
            System.out.println(inetAddress1);
            InetAddress inetAddress2=InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);
            InetAddress inetAddress3=InetAddress.getByName("www.bilibili.com");
            System.out.println(inetAddress3);

            // ipv4
            InetAddress inet4Address = Inet4Address.getByName("www.baidu.com");
            System.out.println(inet4Address);
            // ipv6
            InetAddress inet6Address = Inet6Address.getByName("www.baidu.com");
            System.out.println(inet6Address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
