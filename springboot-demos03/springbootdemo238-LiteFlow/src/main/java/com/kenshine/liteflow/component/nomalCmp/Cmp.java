package com.kenshine.liteflow.component.nomalCmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @Classname ACmp
 * @Description TODO
 * @Date 2023/3/8 14:38
 * @author by kenshine
 * @modified By：
 * @version: 1.0$
 * 普通组件
 *
 */
@LiteflowComponent("nomal")
public class Cmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("ACmp executed!");
    }
}
