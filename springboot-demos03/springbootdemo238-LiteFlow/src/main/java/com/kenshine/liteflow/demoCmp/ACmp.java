package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author by kenshine
 * @Classname ACmp
 * @Description TODO
 * @Date 2023/3/8 15:13
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("a")
public class ACmp extends NodeComponent {

    @Override
    public void process() throws Exception {
        System.out.println("组件a执行了");
    }
}
