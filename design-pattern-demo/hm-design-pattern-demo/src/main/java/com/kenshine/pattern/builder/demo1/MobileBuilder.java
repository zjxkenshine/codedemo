package com.kenshine.pattern.builder.demo1;

/**
 * @version v1.0
 * @ClassName: MobileBuilder
 * @Description: 具体的构建者，用来构建摩拜单车对象
 * @Author: 黑马程序员
 */
public class MobileBuilder extends Builder {

    @Override
    public void buildFrame() {
        bike.setFrame("碳纤维车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("真皮车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
