package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeIfComponent;

/**
 * @author by kenshine
 * @Classname If1Cmp
 * @Description 条件组件1
 * @Date 2023/3/16 15:01
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("if1")
public class If1Cmp extends NodeIfComponent {
    @Override
    public boolean processIf() throws Exception {
        //do your biz
        return true;
    }
}
