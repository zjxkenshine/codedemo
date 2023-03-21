package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author by kenshine
 * @Classname ECmp
 * @Description TODO
 * @Date 2023/3/16 11:16
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("e")
public class ECmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("组件e执行了");
    }
}
