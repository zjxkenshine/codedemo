package com.kenshine.chapter04;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/10 14:16
 * @description：多任务版GuardedObject
 * @modified By：
 * @version: $
 */
public class Test08_MultiGuardedObject {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new People().start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * MailBox是可复用的
         */
        for(Integer id : Mailboxes.getIds()) {
            new Postman(id, "内容 " + id).start();
        }
    }

}

@Slf4j(topic = "c.People")
class People extends Thread {

    @Override
    public void run() {
        GuardedObject guardedObject = Mailboxes.createGuardedObject();
        log.info("收信的为 id: {}", guardedObject.getId());
        Object o = guardedObject.get(5000);
        log.info("收到信的 id: {}, 内容: {}", guardedObject.getId(), o);
    }
}

@Slf4j(topic = "c.Postman")
class Postman extends Thread {
    private int id;
    private String mail;

    public Postman(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void run() {
        GuardedObject guardedObject = Mailboxes.getGuardedObject(id);
        log.info("送信的 id: {}, 内容: {}", id, mail);
        guardedObject.complete(mail);
    }
}

class Mailboxes {
    private static int id = 1;
    private static Map<Integer, GuardedObject> boxes = new Hashtable<>();

    public static synchronized int generateId() {
        return id++;
    }

    // 用户会进行投信
    public static GuardedObject createGuardedObject() {
        GuardedObject guardedObject = new GuardedObject(generateId());
        // 添加到邮箱
        boxes.put(guardedObject.getId(), guardedObject);
        return guardedObject;
    }

    // 派件员会派发信
    public static GuardedObject getGuardedObject(int id) {
        // 从从邮箱列表移除
        return boxes.remove(id);
    }

    public static Set<Integer> getIds() {
        // 获取所有id
        return boxes.keySet();
    }
}

class GuardedObject {
    private int id;
    public GuardedObject(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    private Object response;

    // 优化等待时间
    public Object get(long timeout) {
        synchronized (this) {
            long begin = System.currentTimeMillis();
            long passTime = 0;
            while (response == null) {
                long waitTime = timeout - passTime; // 剩余等待时间
                if(waitTime <= 0) {
                    break;
                }
                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passTime = System.currentTimeMillis() - begin;
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (this) {
            this.response = response;
            this.notify();
        }
    }
}
