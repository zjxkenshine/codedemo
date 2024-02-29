package com.kenshine.joddmail;

import jakarta.mail.Flags;
import jodd.mail.*;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author by kenshine
 * @Classname JoddTest
 * @Description 官方示例
 * @Date 2024-02-29 8:33
 * @modified By：
 * @version: 1.0$
 */
public class JoddTest {

    /**
     * 邮件定义
     */
    @Test
    public void test01(){
        Email email = Email.create()
                .from("inf0@jodd.org")
                .to("ig0r@gmail.com")
                .subject("test6")
                .textMessage("Hello!")
                .htmlMessage(
                        "<html><META http-equiv=Content-Type content=\"text/html; " +
                                "charset=utf-8\"><body><h1>Hey!</h1><img src='cid:c.png'>" +
                                "<h2>Hay!</h2></body></html>")
                .embeddedAttachment(EmailAttachment.with()
                        .content(new File("/c.png")))
                .attachment(EmailAttachment.with()
                        .content("/b.jpg"));
    }

    /**
     * 发送邮件
     */
    @Test
    public void test02(){
        Email email1 = Email.create();
        Email email2 = Email.create();
        SmtpServer smtpServer = MailServer.create()
                .host("http://mail.com")
                .port(21)
                .buildSmtpMailServer();
        SendMailSession session = smtpServer.createSession();
        session.open();
        session.sendMail(email1);
        session.sendMail(email2);
        session.close();
    }

    /**
     * 通过SSL发送邮件
     */
    @Test
    public void test03(){
        Email email = Email.create();
        SmtpServer smtpServer = MailServer.create()
                .ssl(true)
                .host("smtp.gmail.com")
                .auth("user@gmail.com", "password")
                .buildSmtpMailServer();
        SendMailSession session = smtpServer.createSession();
        session.open();
        session.sendMail(email);
        session.close();
    }

    /**
     * POP3 接受邮件
     */
    @Test
    public void test04(){
        Pop3Server popServer = MailServer.create().
                host("pop3.jodd.org").
                        auth("username", "password")
                                .buildPop3MailServer();

        ReceiveMailSession session = popServer.createSession();
        session.open();
        System.out.println(session.getMessageCount());
        ReceivedEmail[] emails = session.receiveEmailAndMarkSeen();
        if (emails != null) {
            for (ReceivedEmail email : emails) {
                System.out.println("\n\n===[" + email.messageId() + "]===");

                // common info
                System.out.println("FROM:" + email.from());
                System.out.println("TO:" + email.to()[0]);
                System.out.println("SUBJECT:" + email.subject());
                System.out.println("PRIORITY:" + email.priority());
                System.out.println("SENT DATE:" + email.sentDate());
                System.out.println("RECEIVED DATE: " + email.receivedDate());

                // process messages
                List<EmailMessage> messages = email.messages();
                for (EmailMessage msg : messages) {
                    System.out.println("------");
                    System.out.println(msg.getEncoding());
                    System.out.println(msg.getMimeType());
                    System.out.println(msg.getContent());
                }

                // process attachments
                List<EmailAttachment<? extends jakarta.activation.DataSource>> attachments = email.attachments();
                if (attachments != null) {
                    System.out.println("+++++");
                    for (EmailAttachment attachment : attachments) {
                        System.out.println("name: " + attachment.getName());
                        System.out.println("cid: " + attachment.getContentId());
                        System.out.println("size: " + attachment.getSize());
                        attachment.writeToFile(
                                new File("d:\\", attachment.getName()));
                    }
                }
            }
        }
        session.close();
    }

    /**
     * Pop3接收邮件 SSL
     */
    @Test
    public void test05(){
        Pop3Server popServer = MailServer.create()
                .host("pop.gmail.com")
                .ssl(true)
                .auth("username", "password")
                .buildPop3MailServer();

        ReceiveMailSession session = popServer.createSession();
        session.open();
        session
                .receive()
                .markSeen()
                .fromFolder("work")
                // 邮件过滤
                .filter(EmailFilter.filter().flag(Flags.Flag.SEEN, false).subject("Hello"))
                .get();
        session.close();
    }

    /**
     * IMAP 接收邮件
     */
    @Test
    public void test06(){
        ImapServer imapServer = MailServer.create()
                .host("imap.gmail.com")
                .ssl(true)
                .auth("username", "password")
                .buildImapMailServer();

        ReceiveMailSession session = imapServer.createSession();
        session.open();
        // ...
        session.close();
    }

}
