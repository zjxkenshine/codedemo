package com.kenshine.liteflow.demoCmp;

import com.kenshine.liteflow.context.CustomContext;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author by kenshine
 * @Classname Context1Cmp
 * @Description 传参测试
 * @Date 2023/3/21 13:46
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("ctx1")
public class Context1Cmp extends NodeComponent {

    @Override
    public void process() {
        CustomContext context = this.getContextBean(CustomContext.class);
        // 获取数据
       String str = context.getData("key1");
        context.setData("key2","value2");
       System.out.println(str);

       // 获取流程入参
       String str1=this.getRequestData();
        System.out.println(str1);
    }
}
