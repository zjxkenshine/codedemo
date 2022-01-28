package com.kenshine.rpc.protocol;

/**
 * 序列化接口
 */
public interface Serializer {
    /**
     * 序列化
     * @param object 被序列化的对象
     * @param <T> 被序列化对象类型
     * @return 序列化后的字节数组
     */
    <T> byte[] serialize(T object);

    /**
     * 反序列化
     * @param clazz 反序列化的目标类的Class对象
     * @param bytes 被反序列化的字节数组
     * @param <T> 反序列化目标类
     * @return 反序列化后的对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);


}
