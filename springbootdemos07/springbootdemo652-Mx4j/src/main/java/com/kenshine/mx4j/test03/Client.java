package com.kenshine.mx4j.test03;

import javax.naming.InitialContext;

public class Client {
    public Client() {
    }

    public static void main(String[] args) throws Exception {
        InitialContext ctx = new InitialContext();
        MyRemoteService service = (MyRemoteService)ctx.lookup("rmi://localhost:1099/my-service");
        service.sayHello("Simon");
    }
}
