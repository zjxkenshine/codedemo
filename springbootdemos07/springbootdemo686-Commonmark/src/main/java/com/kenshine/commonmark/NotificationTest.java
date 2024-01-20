package com.kenshine.commonmark;

import fr.brouillard.oss.commonmark.ext.notifications.Notification;
import fr.brouillard.oss.commonmark.ext.notifications.NotificationsExtension;
import org.commonmark.Extension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.junit.Test;

import java.util.Collections;

/**
 * @author by kenshine
 * @Classname NotificationTest
 * @Description 告警扩展示例
 * @Date 2024-01-20 15:26
 * @modified By：
 * @version: 1.0$
 */
public class NotificationTest {

    /**
     * 基本使用
     */
    @Test
    public void test01() {
        Extension notificationExtension = NotificationsExtension.create();
        Parser parser = Parser
                .builder()
                .extensions(Collections.singleton(notificationExtension))
                .build();
        Node document = parser.parse("! Use Notifications Extension !!!");
        HtmlRenderer renderer = HtmlRenderer
                .builder()
                .extensions(Collections.singleton(notificationExtension))
                .build();
        String render=renderer.render(document);
        System.out.println(render);
    }

    /**
     * 配置
     */
    @Test
    public void test02(){
        Extension notificationExtension = NotificationsExtension.create()
                .withClassMapper(n -> n == Notification.ERROR ? "alert alert-danger" : "alert alert-" + n.name().toLowerCase());
        Parser parser = Parser
                .builder()
                .extensions(Collections.singleton(notificationExtension))
                .build();
        Node document = parser.parse("! Use Notifications Extension !!!");
        HtmlRenderer renderer = HtmlRenderer
                .builder()
                .extensions(Collections.singleton(notificationExtension))
                .build();
        String render=renderer.render(document);
        System.out.println(render);
    }
}
