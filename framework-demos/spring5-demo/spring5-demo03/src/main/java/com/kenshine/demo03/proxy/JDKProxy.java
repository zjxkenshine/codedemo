package com.kenshine.demo03.proxy;

import com.kenshine.demo03.dao.UserDao;
import com.kenshine.demo03.dao.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        Class interfaces[] = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProcy(userDao));
        int result = dao.add(1, 2);
        System.out.println(result);
    }
}
class UserDaoProcy implements InvocationHandler {
    //被传代理对象过来
    private Object obj;
    public UserDaoProcy(Object obj) {
        this.obj = obj;
    }

    //赠强的部分
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法之前......" + method.getName() + "传递的参数: " + Arrays.toString(args));
        //被增强的方法执行
        Object res = method.invoke(obj, args);
        //方法之后
        System.out.println("方法之后....." + obj);
        return res;
    }
}