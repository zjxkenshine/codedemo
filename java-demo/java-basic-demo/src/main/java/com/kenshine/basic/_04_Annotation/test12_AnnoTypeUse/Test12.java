package com.kenshine.basic._04_Annotation.test12_AnnoTypeUse;

import java.util.ArrayList;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 19:41
 * @description： 类能使用的地方就能使用
 * @modified By：
 * @version: $
 */
public class Test12 {
    /**
     * @Target({ElementType.TYPE_USE})
     * 在所有类能使用的地方都能使用
     */
    public void show() throws @UseAnno("运行时异常注解") RuntimeException{
        @UseAnno ArrayList<@UseAnno String> list=new @UseAnno ArrayList<>();
        @UseAnno int num=(@UseAnno int)10L;
    }
}
