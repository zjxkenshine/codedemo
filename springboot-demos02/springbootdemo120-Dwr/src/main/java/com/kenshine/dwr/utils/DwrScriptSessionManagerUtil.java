package com.kenshine.dwr.utils;

import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 22:31
 * @description：Dwr工具类
 * @modified By：
 * @version: $
 */
public class DwrScriptSessionManagerUtil {
    private static final long serialVersionUID = -7504612622407420071L;
    public void init(final String key, final String value) throws ServletException {
        Container container = ServerContextFactory.get().getContainer();
        ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);

        ScriptSessionListener listener = new ScriptSessionListener() {

            @Override
            public void sessionCreated(ScriptSessionEvent ev) {
                HttpSession session = WebContextFactory.get().getSession();
                //String userId = ((User) session.getAttribute("userinfo")).getHumanid() + "";
                System.out.println("a ScriptSession is created!");
                ev.getSession().setAttribute(key, value);
            }

            @Override
            public void sessionDestroyed(ScriptSessionEvent ev) {
                System.out.println("a ScriptSession is distroyed");
            }
        };

        manager.addScriptSessionListener(listener);
    }
}
