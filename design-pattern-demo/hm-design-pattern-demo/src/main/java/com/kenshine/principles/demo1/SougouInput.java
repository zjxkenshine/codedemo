package com.kenshine.principles.demo1;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/17 10:43
 * @description：模拟搜狗皮肤
 * @modified By：
 * @version: 1.0$
 */
public class SougouInput {
    private AbstractSkin skin;

    public void setAbstractSkin(AbstractSkin abstractSkin){
        this.skin = abstractSkin;
    };

    public void display(){
        skin.display();
    }

}
