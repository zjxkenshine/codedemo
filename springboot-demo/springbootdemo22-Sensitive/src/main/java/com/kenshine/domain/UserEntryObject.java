package com.kenshine.domain;

import com.github.houbb.sensitive.annotation.SensitiveEntry;
import lombok.Data;

import java.util.List;

/**
 * @author by kenshine
 * @Classname UserEntryObject
 * @Description @SensitiveEntry 放在对象集合中
 * @Date 2023-11-10 11:42
 * @modified By：
 * @version: 1.0$
 */
@Data
public class UserEntryObject {
    @SensitiveEntry
    private User user;

    @SensitiveEntry
    private List<User> userList;

    @SensitiveEntry
    private User[] userArray;
}
