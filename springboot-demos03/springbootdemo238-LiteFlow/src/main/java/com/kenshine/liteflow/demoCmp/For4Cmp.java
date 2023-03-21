package com.kenshine.liteflow.demoCmp;

import cn.hutool.core.collection.ListUtil;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeIteratorComponent;

import java.util.Iterator;
import java.util.List;

/**
 * @author by kenshine
 * @Classname For4Cmp
 * @Description 迭代循环组件
 * @Date 2023/3/17 8:23
 * @modified By：
 * @version: 1.0$
 */
@LiteflowComponent("for4")
public class For4Cmp extends NodeIteratorComponent {
    @Override
    public Iterator<?> processIterator() throws Exception {
        List<String> list = ListUtil.toList("jack", "mary", "tom");
        return list.iterator();
    }
}
