package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;

/**
 * @author by kenshine
 * @Classname A1Cmp
 * @Description TODO
 * @Date 2023/3/16 14:02
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("select1")
public class Select1Cmp extends NodeSwitchComponent {

    @Override
    public String processSwitch() throws Exception {
        System.out.println("select1组件执行了!");
        // 选择了c组件
        return "c";
    }
}
