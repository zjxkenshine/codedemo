package com.kenshine.mx4j.test03;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteService extends Remote {
    String JNDI_NAME = "rmi://localhost:1099/my-service";

    void sayHello(String var1) throws RemoteException;
}
