package com.kenshine.designpattern.gof11_Composite.test01;

import java.util.ArrayList;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 19:41
 * @description：分支类
 * @modified By：
 * @version: $
 */
public class Branch implements Component {
    private ArrayList<Component> children = new ArrayList<Component>();
    public void add(Component c) {
        children.add(c);
    }
    public void remove(Component c) {
        children.remove(c);
    }
    public Component getChild(int i) {
        return children.get(i);
    }
    public void operation() {
        for (Object obj : children) {
            ((Component) obj).operation();
        }
    }
}
