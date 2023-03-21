package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author by kenshine
 * @Classname CCmp
 * @Description TODO
 * @Date 2023/3/8 15:16
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("c")
public class CCmp extends NodeComponent {
    @Override
    public void process() {
        System.out.println("组件c执行了");
    }
}
