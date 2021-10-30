package com.kenshine.web;

import com.vdurmont.emoji.EmojiParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 13:49
 * @description：测试表情
 * @modified By：
 * @version: $
 */
@RestController
public class EmojiController {

    /**
     * 参数
     *  👱👍 🎁🐚
     * @param name
     */
    @PostMapping("/test")
    public String testEmoji(@RequestBody String name){
        System.out.println(name);
        System.out.println(EmojiParser.parseToAliases(name));
        return name+EmojiParser.parseToAliases(name);
    }



    public static void main(String[] args) {
        String parse = EmojiParser.parseToAliases("哈哈哈\uD83D\uDC71\uD83D\uDC4D \uD83C\uDF81\uD83D\uDC1A");
        System.out.println(parse);
        System.out.println(EmojiParser.parseToUnicode(parse));

    }

}
