package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author by kenshine
 * @Classname DCmp
 * @Description TODO
 * @Date 2023/3/16 11:16
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("d")
public class DCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("组件d执行了");
    }
}
