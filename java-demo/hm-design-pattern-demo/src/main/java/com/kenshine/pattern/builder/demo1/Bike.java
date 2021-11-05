package com.kenshine.pattern.builder.demo1;

/**
 * @version v1.0
 * @ClassName: Bike
 * @Description: 产品对象
 * @Author: 黑马程序员
 */
public class Bike {

    private String frame;//车架

    private String seat;//车座

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
