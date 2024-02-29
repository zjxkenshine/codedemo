package com.kenshine.joddmail;


import jodd.mail.*;
import jodd.net.MimeTypes;

import java.io.File;
import java.io.IOException;

/**
 * @author kenshine
 * 发送示例
 */
public class JoddDemo {
    public static void main(String[] args) {
        try {
            sendEmail();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendEmail() throws IOException {
        // 创建邮件
        Email email = Email.create();
        // 设置邮件发送人
        email.from("su***g@qq.com");
        // 设置收件人
        email.to("64***76@qq.com");
        // 设置邮件主题
        email.subject("测试邮件");
        // 设置邮件内容，text格式
        @SuppressWarnings("unused")
        EmailMessage textMessage = new EmailMessage("Hello", MimeTypes.MIME_TEXT_PLAIN);
        // 设置邮件内容，html格式
        EmailMessage htmlMessage = new EmailMessage("<html><META http-equiv=Content-Type content=\"text/html; "
                + "charset=utf-8\"><body><h1>Hey!</h1><img src='cid:dongman1.jpg'>" + "<h2>Hay!</h2></body></html>",
                MimeTypes.MIME_TEXT_HTML);
        // 将邮件内容添加到邮件中
        email.message(htmlMessage);

        // 创建字节数组附件
        EmailAttachment emailAttachment = EmailAttachment.with()
                .content(new File("/image/dog1.jpg"))
                .name("dog1.jpg")
                .inline(true)   //内联方式
                .buildByteArrayDataSource();

        // 因为是内联方式，所以必须添加到内容中
        emailAttachment.setEmbeddedMessage(htmlMessage);
        EmailAttachment emailAttachment2 = EmailAttachment.with()
                .content(new File("/image/dog2.jpg"))
                .name("dog2.jpg").buildByteArrayDataSource();

        // 将附件添加到邮件中
        email.embeddedAttachment(emailAttachment);
        email.embeddedAttachment(emailAttachment2);

        // 发送邮件
        SmtpServer smtpServer = SmtpSslServer.create().ssl(true).host("smtp.exmail.qq.com").auth("sug***ng@qq.com",
                "Ad***55").buildSmtpMailServer();
        // smtpServer.timeout(10);
        // smtpServer.properties(properties);
        SendMailSession session = smtpServer.createSession();
        session.open();
        session.sendMail(email);
        session.close();
    }

}