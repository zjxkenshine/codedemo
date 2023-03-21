package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeWhileComponent;

/**
 * @author by kenshine
 * @Classname For3Cmp
 * @Description 条件循环组件
 * @Date 2023/3/17 8:16
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("for3")
public class For3Cmp extends NodeWhileComponent {
    @Override
    public boolean processWhile() throws Exception {
        //这里根据业务去返回while的结果
        return false;
    }
}
