package com.kenshine.classworlds.demo;

import org.codehaus.plexus.classworlds.ClassWorld;
import org.codehaus.plexus.classworlds.realm.ClassRealm;
import org.codehaus.plexus.classworlds.realm.DuplicateRealmException;
import org.codehaus.plexus.classworlds.realm.NoSuchRealmException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/19 23:14
 * @description： ClassWorld类加载测试(基本用法)
 * @modified By：
 * @version: $
 */
public class demo01 {
    public static void main(String[] args) throws DuplicateRealmException, NoSuchRealmException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassWorld world = new ClassWorld ();
        //创建realm
        ClassRealm userRealm = world.newRealm( "user" );
        //导入类
        userRealm.importFrom("user","com.kenshine.classworlds.demo.User");

        //获取导入该类的类加载器
        System.out.println(userRealm.getImportClassLoader("com.kenshine.classworlds.demo.User"));

        //使用ClassRealm创建对象
        Class<?> userClass = world.getClassRealm("user").loadClass("com.kenshine.classworlds.demo.User");
        System.out.println(userClass.getCanonicalName());
        User user = (User) userClass.newInstance();
        System.out.println(user.getName());
        System.out.println(userClass.getClassLoader());
    }
}
