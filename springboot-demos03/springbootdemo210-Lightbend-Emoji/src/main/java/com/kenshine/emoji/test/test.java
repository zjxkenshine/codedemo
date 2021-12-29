package com.kenshine.emoji.test;

import com.lightbend.emoji.Emoji;
import com.lightbend.emoji.ShortCodes;
import scala.Int;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/29 11:00
 * @description：测试
 * @modified By：
 * @version: $
 */
public class test {
    public static void main(String[] args) {
        Emoji emoji1 = new Emoji(0x1f603);
        System.out.println(emoji1);

        //👀
        //只能转换单个emoji字符，不能转换整个字符串
        Emoji emoji2 = new Emoji(Emoji.apply("\uD83D\uDC40"));
        System.out.println(Emoji.apply("\uD83D\uDC40"));
        System.out.println(emoji2.name());
        System.out.println(emoji2);
    }
}
