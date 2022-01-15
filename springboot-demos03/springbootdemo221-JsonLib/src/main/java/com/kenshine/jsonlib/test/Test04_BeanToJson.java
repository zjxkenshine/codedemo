package com.kenshine.jsonlib.test;

import com.kenshine.jsonlib.model.Class;
import com.kenshine.jsonlib.model.Student;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 8:55
 * @description： Bean转json
 * @modified By：
 * @version: $
 */
public class Test04_BeanToJson {

    public static void main(String[] args) {
        Student s1 = new Student("kenshine", "男", 22);
        JSONObject jsonObject1 = JSONObject.fromObject(s1);
        System.out.println("Student s1");
        System.out.println(jsonObject1);


        Class c1 = new Class();
        c1.setName("计算机应用1班");
        c1.setDate(new Date());
        JsonConfig config = new JsonConfig();

        //设置循环策略为忽略
        config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);

        //设置 json转换的处理器用来处理日期类型
        //凡是反序列化Date类型的对象，都会经过该处理器进行处理
        config.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
                    //参数1 ：属性名参数2：json对象的值参数3：jsonConfig对象
                    @Override
                    public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date d = (Date) arg1;
                        return sdf.format(d);
                    }

                    @Override
                    public Object processArrayValue(Object arg0, JsonConfig arg1) {
                        return null;
                    }
                });

        List<Student> students = new ArrayList<>();
        students.add(new Student("kenshine", "男", 21));
        students.add(new Student("qin", "女", 18));
        students.add(new Student("lex", "男", 22));
        c1.setStudents(students);
        JSONObject jsonObject2 = JSONObject.fromObject(c1, config);
        System.out.println("Class c1");
        System.out.println(jsonObject2);
    }
}
