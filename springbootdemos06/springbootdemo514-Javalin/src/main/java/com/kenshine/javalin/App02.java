package com.kenshine.javalin;

import com.kenshine.javalin.controller.UserController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

/**
 * @author by kenshine
 * @Classname App02
 * @Description RESTFul API
 * @Date 2023-11-29 11:51
 * @modified By：
 * @version: 1.0$
 */
public class App02 {
    /**
     * localhost:7000/users
     */
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.routes(() -> {
            path("users", () -> {
                get(UserController::getAllUsers);
                post(UserController::createUser);
                path(":id", () -> {
                    get(UserController::getUser);
                    patch(UserController::updateUser);
                    delete(UserController::deleteUser);
                });
            });
        });
    }
}
