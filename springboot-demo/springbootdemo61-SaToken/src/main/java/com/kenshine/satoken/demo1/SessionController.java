package com.kenshine.satoken.demo1;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.SaSessionCustomUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.kenshine.satoken.demo1.domain.Student;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 17:41
 * @description：Session会话
 * @modified By：
 * @version: $
 */
public class SessionController {

    /**
     * 用户session
     */
    public void userSession(){
        // 获取当前账号id的Session (必须是登录后才能调用)
        StpUtil.getSession();

        // 获取当前账号id的Session, 并决定在Session尚未创建时，是否新建并返回
        StpUtil.getSession(true);

        // 获取账号id为10001的Session
        StpUtil.getSessionByLoginId(10001);

        // 获取账号id为10001的Session, 并决定在Session尚未创建时，是否新建并返回
        StpUtil.getSessionByLoginId(10001, true);

        // 获取SessionId为xxxx-xxxx的Session, 在Session尚未创建时, 返回null
        StpUtil.getSessionBySessionId("xxxx-xxxx");
    }

    //TokenSession
    public void tokenSession(){
        // 获取当前token的专属Session
        SaSession tokenSession = StpUtil.getTokenSession();

        // 获取指定token的专属Session
        StpUtil.getTokenSessionByToken("token值");
    }

    /**
     * 自定义Session
     */
    public void customSession(){
        // 查询指定key的Session是否存在
        SaSessionCustomUtil.isExists("goods-10001");

        // 获取指定key的Session，如果没有，则新建并返回
        SaSessionCustomUtil.getSessionById("goods-10001");

        // 获取指定key的Session，如果没有，第二个参数决定是否新建并返回
        SaSessionCustomUtil.getSessionById("goods-10001", false);

        // 删除指定key的Session
        SaSessionCustomUtil.deleteSessionById("goods-10001");

    }
    
    /**
     * session操作
     */
    public void sessionOperation(){
        SaSession session = StpUtil.getTokenSession();

        // 返回此Session的id 
        session.getId();

        // 返回此Session的创建时间 (时间戳) 
        session.getCreateTime();

        // 在Session上获取一个值 
        session.get("name");

        // 在Session上获取一个值，并指定取不到值时返回的默认值
        session.get("name", "kenshine");

        // 在Session上写入一个值 
        session.set("name", "kenshine");

        // 在Session上移除一个值 
        session.delete("name");

        // 清空此Session的所有值 
        session.clear();

        // 获取此Session是否含有指定key (返回true或false)
        session.has("name");

        // 获取此Session会话上所有key (返回Set<String>)
        session.keys();

        // 返回此Session会话上的底层数据对象（如果更新map里的值，请调用session.update()方法避免产生脏数据）
        session.getDataMap();

        // 将这个Session从持久库更新一下
        session.update();

        // 注销此Session会话 (从持久库删除此Session)
        session.logout();

    }

    /**
     * 类型转换
     */
    public void dataTransfer(){
        SaSession session = StpUtil.getTokenSession();
        
        // 写值
        session.set("name", "kenshine");

        // 写值 (只有在此key原本无值的时候才会写入)
        session.setDefaultValue("name", "kenshine");

        // 取值
        session.get("name");

        // 取值 (指定默认值)
        session.get("name", "<defaultValue>");

        // 取值 (转String类型)
        session.getString("name");

        // 取值 (转int类型)
        session.getInt("age");

        // 取值 (转long类型)
        session.getLong("age");

        // 取值 (转double类型)
        session.getDouble("result");

        // 取值 (转float类型)
        session.getFloat("result");

        // 取值 (指定转换类型)
        session.getModel("key", Student.class);

        // 取值 (指定转换类型, 并指定值为Null时返回的默认值)
        session.getModel("key", Student.class,new Student());

        // 是否含有某个key
        session.has("key");

    }


}
