package com.kenshine.onenio.message;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Chat implements Serializable {
    public final long id;
    public final long[] participants;
    public final String title;
    public final String icon;
    public final List<Message> messages;
    public final Message lastMessage;

    public Chat(long id, long[] participants, String title, String icon, List<Message> messages) {
        this.id = id;
        this.participants = participants;
        this.title = title;
        this.icon = icon;
        this.messages = messages;
        this.lastMessage = messages.isEmpty() ? null : messages.get(messages.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return id == chat.id &&
                Arrays.equals(participants, chat.participants) &&
                Objects.equals(title, chat.title) &&
                Objects.equals(icon, chat.icon) &&
                Objects.equals(messages, chat.messages) &&
                Objects.equals(lastMessage, chat.lastMessage);
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}