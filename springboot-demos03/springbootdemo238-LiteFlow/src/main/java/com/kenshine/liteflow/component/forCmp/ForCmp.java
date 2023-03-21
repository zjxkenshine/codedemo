package com.kenshine.liteflow.component.forCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeForComponent;

/**
 * @author by kenshine
 * @Classname ForCmp
 * @Description TODO
 * @Date 2023/3/8 14:54
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("for")
public class ForCmp extends NodeForComponent {
    @Override
    public int processFor() throws Exception {
        // 可以根据业务返回for结果
        return 0;
    }
}
