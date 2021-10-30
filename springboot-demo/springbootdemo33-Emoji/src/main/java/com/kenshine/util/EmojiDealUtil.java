package com.kenshine.util;

import com.vdurmont.emoji.EmojiParser;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 13:59
 * @description：表情处理
 * @modified By：
 * @version: $
 */
public class EmojiDealUtil extends EmojiParser {
    /**
     * 获取非表情字符串
     * @param input
     * @return
     */
    public static String getNonEmojiString(String input) {
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        List<UnicodeCandidate> replacements = getUnicodeCandidates(input);
        for (UnicodeCandidate candidate : replacements) {
            sb.append(input.substring(prev, candidate.getEmojiStartIndex()));
            prev = candidate.getFitzpatrickEndIndex();
        }
        return sb.append(input.substring(prev)).toString();
    }

    /**
     * 获取表情字符串
     * @param input
     * @return
     */
    public static String getEmojiUnicodeString(String input){
        EmojiTransformer  transformer = new EmojiTransformer() {
            @Override
            public String transform(UnicodeCandidate unicodeCandidate) {
                return unicodeCandidate.getEmoji().getHtmlHexadecimal();
            }
        };
        StringBuilder sb = new StringBuilder();
        List<UnicodeCandidate> replacements = getUnicodeCandidates(input);
        for (UnicodeCandidate candidate : replacements) {
            sb.append(transformer.transform(candidate));
        }
        return  parseToUnicode(sb.toString());
    }

    public static String getUnicode(String source){
        String returnUniCode=null;
        String uniCodeTemp=null;
        for(int i=0;i<source.length();i++){
            uniCodeTemp = "\\u"+Integer.toHexString((int)source.charAt(i));
            returnUniCode=returnUniCode==null?uniCodeTemp:returnUniCode+uniCodeTemp;
        }
        return returnUniCode;
    }
}
