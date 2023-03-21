package com.kenshine.liteflow.demoCmp;

import com.kenshine.liteflow.context.CustomContext;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author by kenshine
 * @Classname Context2Cmp
 * @Description TODO
 * @Date 2023/3/21 15:34
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("ctx2")
public class Context2Cmp extends NodeComponent {

    @Override
    public void process() throws Exception {
        CustomContext context = this.getContextBean(CustomContext.class);
        // 获取数据
        String str = context.getData("key2");
        System.out.println(str);
    }
}
