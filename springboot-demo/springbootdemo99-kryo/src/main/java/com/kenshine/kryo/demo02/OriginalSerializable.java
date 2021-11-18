package com.kenshine.kryo.demo02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 15:11
 * @description：Java原生序列化
 * @modified By：
 * @version: $
 */
public class OriginalSerializable {

    public static void main(String[] args) throws IOException{
        long start =  System.currentTimeMillis();
        setSerializableObject();
        System.out.println("java原生序列化时间:" + (System.currentTimeMillis() - start) + " ms" );
        start =  System.currentTimeMillis();
        getSerializableObject();
        System.out.println("java原生反序列化时间:" + (System.currentTimeMillis() - start) + " ms");
    }

    public static void setSerializableObject() throws IOException{

        FileOutputStream fo = new FileOutputStream("D:/file2.bin");

        ObjectOutputStream so = new ObjectOutputStream(fo);

        for (int i = 0; i < 100000; i++) {
            Map<String,Integer> map = new HashMap<>(2);
            map.put("kenshine0", i);
            map.put("kenshine1", i);
            so.writeObject(new Simple("kenshine"+i,(i+1),map));
        }
        so.flush();
        so.close();
    }

    public static void getSerializableObject(){
        FileInputStream fi;
        try {
            fi = new FileInputStream("D:/file2.bin");
            ObjectInputStream si = new ObjectInputStream(fi);

            while(si.readObject() != null){
                //System.out.println(simple.getAge() + "  " + simple.getName());
            }
            fi.close();
            si.close();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }

    }
}
