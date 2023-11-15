package com.kenshine.onenio.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Attachment implements Serializable {
    enum Type {PHOTO, VIDEO}

    public final Type type;
    public final long id;
    public final Map<String, Object> properties = new HashMap<>();

    public Attachment(Type type, long id) {
        this.type = type;
        this.id = id;
    }

    public Attachment with(String key, Object value) {
        properties.put(key, value);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attachment that = (Attachment) o;
        return id == that.id &&
                type == that.type &&
                Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
