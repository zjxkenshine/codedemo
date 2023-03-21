package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;

/**
 * @author by kenshine
 * @Classname Select2Cmp
 * @Description TODO
 * @Date 2023/3/16 14:09
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("select2")
public class Select2Cmp extends NodeSwitchComponent {
    @Override
    public String processSwitch() throws Exception {
        System.out.println("select2组件执行了!");
        // 根据id选择分支
        return "w1";
    }
}
