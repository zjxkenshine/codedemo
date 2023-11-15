package com.kenshine.onenio.message;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sample {

    /**
     * 创建对话
     */
    public static Chat createChat() {
        Long user1 = 11L;
        Long user2 = 22L;
        return new Chat(1, new long[]{user1, user2}, "Chat title", "http://path.to/icon.png", Arrays.asList(
                new Message(111, user1, "First message", Collections.<Attachment>emptyList()),
                new Message(222, user1, "Second message", Collections.<Attachment>singletonList(
                        new Attachment(Attachment.Type.PHOTO, 999)
                )),
                new Message(333, user2, "Reply", Collections.<Attachment>emptyList()),
                new Message(444, user1, "Reply to reply", Arrays.asList(
                        new Attachment(Attachment.Type.PHOTO, 888),
                        new Attachment(Attachment.Type.VIDEO, 777)
                                .with("property1", "value")
                                .with("property2", true)
                                .with("", 0)
                )),
                new Message(555, null, "value", new ArrayList<Attachment>())
        ));
    }
}