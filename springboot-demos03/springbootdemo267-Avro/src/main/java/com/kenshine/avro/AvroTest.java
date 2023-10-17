package com.kenshine.avro;

import com.kenshine.avro.pojo.User;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.file.SeekableByteArrayInput;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname AvroTest
 * @Description 测试 Avro 序列化与反序列化
 * @Date 2023-10-17 11:57
 * @modified By：
 * @version: 1.0$
 */
public class AvroTest {
    /**
     * 对象序列化到文件
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        DatumWriter<User> datumWriter = new SpecificDatumWriter<>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<>(datumWriter);

        Schema schema = User.getClassSchema();
        String fileName = "userData.avro";
        dataFileWriter.create( schema, new File( fileName ) );

        List<User> list = getUserList();
        for (User user : list) {
            dataFileWriter.append(user);
        }

        dataFileWriter.close();
    }

    /**
     * 从文件中反序列化为对象
     * @return
     */
    @Test
    public void test2() throws IOException {
        String fileName = "userData.avro";
        DatumReader<User> datumReader = new SpecificDatumReader<>( User.class );
        DataFileReader<User> dataFileReader = new DataFileReader<>( new File(fileName), datumReader);
        while ( dataFileReader.hasNext() ) {
            User user = dataFileReader.next();
            System.out.println(user);
        }
    }

    /**
     * 对象序列化为字节数组及反序列化
     */
    @Test
    public void test3() throws IOException {
        System.out.println("--------------- 对象序列化为字节数组 ---------------");

        DatumWriter<User> datumWriter = new SpecificDatumWriter<>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<>(datumWriter);

        Schema schema = User.getClassSchema();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        dataFileWriter.create( schema, byteArrayOutputStream );

        List<User> list = getUserList();
        for (User user : list) {
            dataFileWriter.append(user);
        }
        dataFileWriter.close();

        // 序列化后的字节数组
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        System.out.println("--------------- 字节数组反序列化为对象 ---------------");

        SeekableByteArrayInput seekableByteArrayInput = new SeekableByteArrayInput(byteArray);
        DatumReader<User> datumReader = new SpecificDatumReader<>( User.class );
        DataFileReader<User> dataFileReader = new DataFileReader<>( seekableByteArrayInput, datumReader );

        while ( dataFileReader.hasNext() ) {
            User user = dataFileReader.next();
            System.out.println(user);
        }
    }

    /**
     * 序列化为字节数组及反序列化 直接基于Schema文件
     * 需要引入 snappy 包，否则会报错
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        System.out.println("--------------- 序列化为字节数组 ---------------");
        String path = System.getProperty("user.dir") + "/src/main/java/com/kenshine/avro/avsc/";
        String fileName = "user.avsc";
        Schema schema = new Schema.Parser().parse( new File(path, fileName) );

        GenericRecord user1 = new GenericData.Record(schema);
        user1.put("name", "刘备");
        user1.put("age", 33);
        user1.put("sex", "男");

        GenericRecord user2 = new GenericData.Record(schema);
        user2.put("name", "孙尚香");
        user2.put("age", 46);
        user2.put("sex", "女");

        GenericRecord user3 = new GenericData.Record(schema);
        user3.put("name", "曹操");
        user3.put("age", 146);

        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        dataFileWriter.create(schema, byteArrayOutputStream);

        dataFileWriter.append( user1 );
        dataFileWriter.append( user2 );
        dataFileWriter.append( user3 );
        dataFileWriter.close();

        // 序列化后的字节数组
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        System.out.println("--------------- 字节数组反序列化 ---------------");

        SeekableByteArrayInput seekableByteArrayInput = new SeekableByteArrayInput(byteArray);
        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(seekableByteArrayInput, datumReader);

        while (dataFileReader.hasNext()) {
            GenericRecord user = dataFileReader.next();
            System.out.println(user);
        }

    }

    private List<User> getUserList() {
        List<User> list = new LinkedList<>();
        list.add( new User("Aaron", 25,  "男") );
        list.add( new User("Bob", 27,  "女") );
        list.add( new User("Tony", 18,  null) );
        return list;
    }
}
