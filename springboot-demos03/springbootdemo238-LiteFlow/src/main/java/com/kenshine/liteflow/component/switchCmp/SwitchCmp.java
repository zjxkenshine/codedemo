package com.kenshine.liteflow.component.switchCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;

/**
 * @author by kenshine
 * @Classname BCmp
 * @Description 选择组件
 * @Date 2023/3/8 14:42
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("switch")
public class SwitchCmp extends NodeSwitchComponent {
    @Override
    public String processSwitch() throws Exception {
        // 选择C组件
        return "c";
    }
}
