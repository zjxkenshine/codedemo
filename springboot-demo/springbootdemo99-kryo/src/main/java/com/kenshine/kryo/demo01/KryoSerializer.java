package com.kenshine.kryo.demo01;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.BeanSerializer;
import org.objenesis.strategy.StdInstantiatorStrategy;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 15:02
 * @description：Kryo序列化
 * @modified By：
 * @version: $.
 *
 *
 * kryo实现序列化和反序列化接口
 * kryo不是线程安全的，需要注意，使用独立线程实现
 */
public class KryoSerializer implements Serializer {
    //将kryo对象存储在线程中，只有这个线程可以访问到，这样保证kryo的线程安全性，ThreadLocal(线程内部存储类)
    //通过get()&set()方法读取线程内的数据
    private final ThreadLocal<Kryo> kryoThreadLocal = new ThreadLocal<Kryo>(){
        @Override
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            kryo.register(aClass, new BeanSerializer<>(kryo,aClass));
            //引用，对A对象序列化时，默认情况下kryo会在每个成员对象第一次序列化时写入一个数字，
            // 该数字逻辑上就代表了对该成员对象的引用，如果后续有引用指向该成员对象，
            // 则直接序列化之前存入的数字即可，而不需要再次序列化对象本身。
            // 这种默认策略对于成员存在互相引用的情况较有利，否则就会造成空间浪费
            // （因为没序列化一个成员对象，都多序列化一个数字），
            // 通常情况下可以将该策略关闭，kryo.setReferences(false);
            kryo.setReferences(false);
            //设置是否注册全限定名，
            kryo.setRegistrationRequired(false);
            //设置初始化策略，如果没有默认无参构造器，那么就需要设置此项,使用此策略构造一个无参构造器
            kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
            return kryo;
        }
    };

    private final  ThreadLocal<Output> outputThreadLocal = new ThreadLocal<>();

    private final  ThreadLocal<Input> inputThreadLocal = new ThreadLocal<>();

    private Class<?> aClass = null;


    public Class<?> getaClass() {
        return aClass;
    }

    public void setaClass(Class<?> aClass) {
        this.aClass = aClass;
    }

    @Override
    public void serializer(Object object, byte[] bytes) {
        Kryo kryo = kryoThreadLocal.get();
        Output output =getOutPut(bytes);
        kryo.writeObjectOrNull(output,object,object.getClass());
        output.flush();
    }

    @Override
    public void serializer(Object object, byte[] bytes, int offset, int count) {
        Kryo kryo = kryoThreadLocal.get();
        Output output =getOutPut(bytes,offset,count);
        kryo.writeObjectOrNull(output,object,object.getClass());
        output.flush();
    }

    @Override
    public <T> T deserializer(byte[] bytes) {
        Kryo kryo =  kryoThreadLocal.get();
        Input input = getInPut(bytes);
        return (T)kryo.readObjectOrNull(input,aClass);
    }

    @Override
    public <T> T deserializer(byte[] bytes, int offset, int count){
        Kryo kryo = kryoThreadLocal.get();
        Input input = getInPut(bytes,offset,count);
        return (T)kryo.readObjectOrNull(input,aClass);
    }

    private Output getOutPut(byte[] bytes){
        Output output = outputThreadLocal.get();
        if(output == null){
            output = new Output();
            outputThreadLocal.set(new Output());
        }
        if(bytes!=null){
            output.setBuffer(bytes);
        }
        return output;
    }
    private Output getOutPut(byte[] bytes, int offset, int count){
        Output output = outputThreadLocal.get();
        if(output == null){
            output = new Output();
            outputThreadLocal.set(new Output());
        }
        if(bytes!=null){
            output.writeBytes(bytes,offset,count);
        }
        return output;
    }
    private Input getInPut(byte[] bytes){
        Input input = inputThreadLocal.get();
        if(input == null){
            input= new Input();
            outputThreadLocal.set(new Output());
        }
        if(bytes!=null){
            input.setBuffer(bytes);
        }
        return input;
    }

    private Input getInPut(byte[] bytes,int offser,int count){
        Input input = inputThreadLocal.get();
        if(input == null){
            input= new Input();
            outputThreadLocal.set(new Output());
        }
        if(bytes!=null){
            input.setBuffer(bytes,offser,count);
        }
        return input;
    }
}
