package com.kenshine.jsonlib.test;

import com.kenshine.jsonlib.model.Student;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 8:53
 * @description：集合转json
 * @modified By：
 * @version: $
 */
public class Test02_CollectionsToJson {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        list1.add("first");
        list1.add("second");
        JSONArray jsonArray1 = JSONArray.fromObject(list1);
        System.out.println("List list1");
        System.out.println(jsonArray1);

        List<Student> list2 = new ArrayList<Student>();
        list2.add(new Student("kenshine","男",25));
        list2.add(new Student("qin","女",18));
        list2.add(new Student("saxon","男",25));
        JSONArray jsonArray2 = JSONArray.fromObject(list2);
        System.out.println("List<Student> list2");
        System.out.println(jsonArray2);
    }
}
