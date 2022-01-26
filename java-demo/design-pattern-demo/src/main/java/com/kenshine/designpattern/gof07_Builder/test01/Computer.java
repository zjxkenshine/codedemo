package com.kenshine.designpattern.gof07_Builder.test01;

import lombok.Getter;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/26 12:41
 * @description：
 * @modified By：
 * @version: $
 *
 * Lombok中也提供了构建者模式的注解@Builder
 */
@Getter
@ToString
public class Computer {
    private final String cpu;//必须
    private final String ram;//必须
    private final int usbCount;//可选
    private final String keyboard;//可选
    private final String display;//可选

    private Computer(Builder builder){
        this.cpu=builder.cpu;
        this.ram=builder.ram;
        this.usbCount=builder.usbCount;
        this.keyboard=builder.keyboard;
        this.display=builder.display;
    }

    public static class Builder{
        private String cpu;//必须
        private String ram;//必须
        private int usbCount;//可选
        private String keyboard;//可选
        private String display;//可选

        public Builder(String cup,String ram){
            this.cpu=cup;
            this.ram=ram;
        }

        public Builder setUsbCount(int usbCount) {
            this.usbCount = usbCount;
            return this;
        }
        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }
        public Builder setDisplay(String display) {
            this.display = display;
            return this;
        }
        //build方法创建对象
        public Computer build(){
            return new Computer(this);
        }
    }
}
