package com.kenshine.onenio.message;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Message implements Serializable {
    public final long id;
    public final long timestamp;
    public final Long author;
    public final String text;
    public final List<Attachment> attachments;

    public Message(long id, Long author, String text, List<Attachment> attachments) {
        this.id = id;
        this.timestamp = System.currentTimeMillis();
        this.author = author;
        this.text = text;
        this.attachments = attachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return id == message.id &&
                timestamp == message.timestamp &&
                Objects.equals(author, message.author) &&
                Objects.equals(text, message.text) &&
                Objects.equals(attachments, message.attachments);
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}