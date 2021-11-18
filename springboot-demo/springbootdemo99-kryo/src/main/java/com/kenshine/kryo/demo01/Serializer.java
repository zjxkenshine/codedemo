package com.kenshine.kryo.demo01;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 15:02
 * @description：序列化器
 * @modified By：
 * @version: $
 */
public interface Serializer {
    /**
     * 序列化
     * @param object
     * @param bytes
     */
    void serializer(Object object,byte[] bytes);

    /**
     *
     * @param object
     * @param bytes
     * @param offset
     * @param count
     */
    void serializer(Object object,byte[] bytes,int offset,int count);

    /**
     * 反序列化
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deserializer(byte[] bytes);

    /**
     * 反序列化
     * @param bytes
     * @param offset
     * @param count
     * @param <T>
     * @return
     */
    <T> T deserializer(byte[] bytes,int offset,int count);
}
