package com.kenshine.fbs;

import com.google.flatbuffers.FlatBufferBuilder;
import org.junit.Test;

import javax.management.monitor.Monitor;
import java.nio.ByteBuffer;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/15 23:41
 * @description：测试
 * @modified By：
 * @version: $
 */
public class FbsTest {
    @Test
    public void test() {
        // 创建一个ByteBuffer来存储数据
        ByteBuffer buffer;

        FlatBufferBuilder builder=new FlatBufferBuilder();
        // 创建一个Monster对象
        int nameOffset = builder.createString("kenshine");
        Monster.startMonster(builder);
        // 对象使用偏移量
        Monster.addName(builder,nameOffset);
        Monster.addHp(builder,(short)100);
        int personOffset =Monster.endMonster(builder);
        // 结束builder
        builder.finish(personOffset);
        buffer=builder.dataBuffer();

        // 从ByteBuffer中读取Monster对象
        Monster monsterRead = Monster.getRootAsMonster(buffer);

        // 输出读取到的数据
        System.out.println("Name: " + monsterRead.name());
        System.out.println("HP: " + monsterRead.hp());
        //System.out.println("Pos: (" + monsterRead.pos().x() + ", " + monsterRead.pos().y() + ", " + monsterRead.pos().z() + ")");
    }
}
