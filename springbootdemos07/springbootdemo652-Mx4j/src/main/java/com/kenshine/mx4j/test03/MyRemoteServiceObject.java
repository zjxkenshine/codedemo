package com.kenshine.mx4j.test03;

import javax.naming.InitialContext;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteServiceObject extends RemoteServer implements MyRemoteService, MyRemoteServiceObjectMBean {
    private boolean m_running;

    public MyRemoteServiceObject() throws RemoteException {
    }

    @Override
    public void sayHello(String name) throws RemoteException {
        System.out.println("Hello, " + name);
    }

    @Override
    public void start() throws Exception {
        if (!this.m_running) {
            UnicastRemoteObject.exportObject(this);
            InitialContext ctx = new InitialContext();
            ctx.rebind("rmi://localhost:1099/my-service", this);
            this.m_running = true;
            System.out.println("My remote service started successfully");
        }

    }

    @Override
    public void stop() throws Exception {
        if (this.m_running) {
            InitialContext ctx = new InitialContext();
            ctx.unbind("rmi://localhost:1099/my-service");
            UnicastRemoteObject.unexportObject(this, false);
            this.m_running = false;
            System.out.println("My remote service stopped successfully");
        }

    }

    @Override
    public boolean isRunning() {
        return this.m_running;
    }
}