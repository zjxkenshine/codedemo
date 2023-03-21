package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author by kenshine
 * @Classname BCmp
 * @Description TODO
 * @Date 2023/3/8 15:15
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("b")
public class BCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("组件b执行了");
    }

}
