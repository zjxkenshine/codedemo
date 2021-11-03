package com.kenshine.protobuf.utils;

import com.kenshine.protobuf.domain.User;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 17:42
 * @description：ProtoBuf工具类
 * @modified By：
 * @version: $
 */
public class ProtoBufUtil {
    private static Logger log = LoggerFactory.getLogger(ProtoBufUtil.class);
    private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();

    private static Objenesis objenesis = new ObjenesisStd(true);

    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> cls) {
        Schema<T> schema = (Schema<T>) cachedSchema.get(cls);
        if (schema == null) {
            schema = RuntimeSchema.createFrom(cls);
            if (schema != null) {
                cachedSchema.put(cls, schema);
            }
        }
        return schema;
    }

    public ProtoBufUtil() {
    }

    @SuppressWarnings({ "unchecked" })
    public static <T> byte[] serializer(T obj) {
        Class<T> cls = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            Schema<T> schema = getSchema(cls);
            return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            log.error("protobuf序列化失败");
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            buffer.clear();
        }
    }

    public static <T> T deserializer(byte[] bytes, Class<T> clazz) {
        try {
            T message = (T) objenesis.newInstance(clazz);
            Schema<T> schema = getSchema(clazz);
            ProtostuffIOUtil.mergeFrom(bytes, message, schema);
            return message;
        } catch (Exception e) {
            log.error("protobuf反序列化失败");
            throw new IllegalStateException(e.getMessage(), e);
        }
    }


    /**
     * 使用测试
     * @param args
     */
    public static void main(String[] args) {
        User user = new User();
        user.setUserId(1);
        user.setUserTypeId(1);
        user.setUserName("XRQ");
        user.setCreateDateTime(new Date());
        //序列化成ProtoBuf数据结构
        byte[] userProtoObj= ProtoBufUtil.serializer(user);

        //ProtoBuf数据结构反序列化成User对象
        User newUserObj = ProtoBufUtil.deserializer(userProtoObj, User.class);

        System.out.println(newUserObj);
    }

}
