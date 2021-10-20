package com.kenshine.pattern2.bridge;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 桥接模式
 * @Author: kenshine
 *
 * 使用场景
 *
 * 当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。(如系统和软件，手机和软件等)
 * 当一个系统不希望使用继承或因为多层次继承导致系统类的个数急剧增加时。
 * 当一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性时。避免在两个层次之间建立静态的继承联系，通过桥接模式可以使它们在抽象层建立一个关联关系
 *
 */
public class Client {
    public static void main(String[] args) {
        //创建mac系统对象
        OpratingSystem system = new Mac(new AviFile());
        //使用操作系统播放视频文件
        system.play("战狼3");
    }
}
