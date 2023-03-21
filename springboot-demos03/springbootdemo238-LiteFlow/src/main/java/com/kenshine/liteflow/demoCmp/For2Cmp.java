package com.kenshine.liteflow.demoCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeForComponent;

/**
 * @author by kenshine
 * @Classname For1Cmp
 * @Description 次数循环组件
 * @Date 2023/3/17 8:13
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("for2")
public class For2Cmp extends NodeForComponent {
    @Override
    public int processFor() {
        //这里根据业务去返回for的结果
        return 3;
    }
}
