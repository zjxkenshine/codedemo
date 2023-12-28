package com.kenshine.jmockit.service;

public interface MailService {
    public boolean sendMail(long userId, String content);
}