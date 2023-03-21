package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeBreakComponent;

/**
 * @author by kenshine
 * @Classname For5Cmp
 * @Description 退出循环组件
 * @Date 2023/3/17 8:26
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("for5")
public class For5Cmp extends NodeBreakComponent {
    @Override
    public boolean processBreak() throws Exception {
        return false;
    }
}
