package com.kenshine.autofactory.test05;

import com.google.inject.Provides;
import com.google.inject.name.Named;
import javafx.scene.Camera;

/**
 * @author by kenshine
 * @Classname UserService
 * @Description 测试
 * @Date 2023-10-24 9:15
 * @modified By：
 * @version: 1.0$
 */
public class UserService {

    @Named("uid")
    @Provides
    User getUser() {
        return new User(1,"kenshine");
    }
}
