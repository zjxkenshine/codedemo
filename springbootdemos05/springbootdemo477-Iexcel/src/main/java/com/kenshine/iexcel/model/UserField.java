package com.kenshine.iexcel.model;

import com.github.houbb.iexcel.annotation.ExcelField;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author Kenshine
 * @ExcelField注解使用
 */
@Data
@AllArgsConstructor
public class UserField {

    @ExcelField(headName = "姓名", order = 2)
    private String name;

    @ExcelField(headName = "年龄",order = 1)
    private int age;

    /**
     * 构建用户
     * @return
     */
    public static List<UserField> buildUserList() {
        List<UserField> users = new ArrayList<>();
        users.add(new UserField("kenshine",20));
        users.add(new UserField("excel",20));
        return users;
    }
}