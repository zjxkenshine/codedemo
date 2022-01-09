package com.kenshine.basic._04_Annotation.test09_AnnotationType;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 18:05
 * @description：自定义处理器
 * @modified By：
 * @version: $
 */
public class CustomHandler implements Handler{

    @Override
    public void handle() {
        System.out.println("调用了自定义处理器");
    }

}
