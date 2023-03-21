package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;

/**
 * @author by kenshine
 * @Classname Select3Cmp
 * @Description TODO
 * @Date 2023/3/16 14:15
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("select3")
public class Select3Cmp extends NodeSwitchComponent {
    @Override
    public String processSwitch() throws Exception {
        System.out.println("select3组件执行了!");
        // 根据tag选择分支 选择第一个
        return "tag:dog";
    }
}
