package com.kenshine.liteflow.component.ifCmp;

import com.yomahub.liteflow.core.NodeIfComponent;
import org.springframework.stereotype.Component;

/**
 * @author by kenshine
 * @Classname CCmp
 * @Description 条件组件
 * @Date 2023/3/8 14:49
 * @modified By：
 * @version: 1.0$
 */
@Component("if")
public class IfCmp extends NodeIfComponent {
    @Override
    public boolean processIf() throws Exception {
        return true;
    }
}
