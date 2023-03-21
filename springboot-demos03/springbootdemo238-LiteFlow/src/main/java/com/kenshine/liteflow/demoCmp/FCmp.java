package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author by kenshine
 * @Classname FCmp
 * @Description TODO
 * @Date 2023/3/16 11:24
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("f")
public class FCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("组件f执行了");
    }
}
