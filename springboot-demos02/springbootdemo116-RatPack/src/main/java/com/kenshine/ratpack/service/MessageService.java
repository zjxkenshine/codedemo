package com.kenshine.ratpack.service;

import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 10:03
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class MessageService {
    public String message() {
        return "Hello World";
    }
}
