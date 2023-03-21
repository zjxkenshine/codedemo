package com.kenshine.liteflow.component.whileCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeWhileComponent;

/**
 * @author by kenshine
 * @Classname WhileCmp
 * @Description 条件循环组件
 * @Date 2023/3/8 15:00
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("while")
public class WhileCmp extends NodeWhileComponent {
    @Override
    public boolean processWhile() throws Exception {
        return false;
    }
}
