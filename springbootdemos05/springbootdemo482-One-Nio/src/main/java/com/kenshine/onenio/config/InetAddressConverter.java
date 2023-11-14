package com.kenshine.onenio.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Kenshine
 * 自定义converter
 */
public class InetAddressConverter {
        public InetAddress convert(String value) throws UnknownHostException {
            return InetAddress.getByName(value);
        }
    }