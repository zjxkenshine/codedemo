package com.kenshine.jyaml;

import com.kenshine.jyaml.model.Person;
import org.ho.yaml.Yaml;
import org.ho.yaml.YamlDecoder;
import org.ho.yaml.YamlEncoder;
import org.junit.Test;

import java.io.*;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/22 15:18
 * @description：测试
 * @modified By：
 * @version: $
 */
public class YamlTest {

    /**
     * 创建yaml文件
     */
    @Test
    public void test(){
        Person michael = new Person();
        Person floveria = new Person();
        Person[] children = new Person[2];
        children[0] = new Person();
        children[1] = new Person();

        michael.setName("Michael Corleone");
        michael.setAge(24);
        floveria.setName("Floveria Edie");
        floveria.setAge(24);
        children[0].setName("boy");
        children[0].setAge(3);
        children[1].setName("girl");
        children[1].setAge(1);

        michael.setSpouse(floveria);
        floveria.setSpouse(michael);

        michael.setChildren(children);
        floveria.setChildren(children);

        /*
        * 导出到文件
        * */
        File dumpFile = new File("yaml\\John.yaml");
        try {
            Yaml.dump(michael, dumpFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * yaml流处理
     * 添加一个john
     */
    @Test
    public void test02() throws FileNotFoundException {
        File dumpFile = new File("yaml\\John.yaml");
        Person john2 = Yaml.loadType(dumpFile, Person.class);
        YamlEncoder enc = new YamlEncoder(new FileOutputStream(dumpFile));
        for(int i=0; i<2; i++){
            john2.setAge(37+i);
            enc.writeObject(john2);
            enc.flush();
        }
        enc.close();
    }

    /**
     * 读取对象
     */
    @Test
    public void test03() throws FileNotFoundException {
        File dumpFile = new File("yaml\\John.yaml");
        Person john2;
        YamlDecoder dec = new YamlDecoder(new FileInputStream(dumpFile));
        while(true){
            try{
                john2 = (Person) dec.readObject();
                System.out.println(john2.getAge());
            }catch(EOFException e){
                break;
            }
        }
    }
}
