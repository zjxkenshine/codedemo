package com.kenshine.principles.demo1;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/17 10:45
 * @description：测试
 * @modified By：
 * @version: $
 */
public class SkinTest {

    public static void main(String[] args) {
        //创建搜狗
        SougouInput input = new SougouInput();
        //创建皮肤
        DefaultSkin defaultSkin = new DefaultSkin();
        HeimaSkin heimaSkin = new HeimaSkin();
        //设置默认皮肤
        input.setAbstractSkin(defaultSkin);
        input.display();
        //设置黑马皮肤
        input.setAbstractSkin(heimaSkin);
        input.display();
    }

}
