package com.kenshine.simsearch.model;

import cn.langpy.simsearch.annotation.IndexColumn;
import cn.langpy.simsearch.annotation.IndexId;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Student
 * @Description 测试类
 * @Date 2023-12-02 8:57
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Student {
    /*索引唯一id 必须*/
    @IndexId
    private String id;
    /*
    * 需要创建索引的字段：用来模糊搜索
    * */
    @IndexColumn
    private String studentName;
    @IndexColumn
    private String schoolName;
    private String age;
}
