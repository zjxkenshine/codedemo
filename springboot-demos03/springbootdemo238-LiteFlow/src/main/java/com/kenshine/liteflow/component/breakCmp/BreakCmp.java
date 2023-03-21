package com.kenshine.liteflow.component.breakCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeBreakComponent;

/**
 * @author by kenshine
 * @Classname BreakCmp
 * @Description 退出循环组件
 * @Date 2023/3/8 15:08
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("break")
public class BreakCmp extends NodeBreakComponent {
    @Override
    public boolean processBreak() throws Exception {
        return false;
    }
}
