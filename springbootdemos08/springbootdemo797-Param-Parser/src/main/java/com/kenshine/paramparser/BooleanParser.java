package com.kenshine.paramparser;

import idea.verlif.parser.NullValueParser;
import idea.verlif.parser.ParamParser;

/**
 * @author kenshine
 * 自定义parser
 */
public class BooleanParser extends ParamParser<Boolean> {

    private static final char[] TRUE = new char[]{'t', 'T', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    @Override
    public Class<?>[] match() {
        return new Class[]{Boolean.class, boolean.class};
    }

    /**
     * 转换文本到boolean值
     *
     * @param param 文本内容，不为空。<br/>
     *              为true的格式有
     *              <ul>
     *                  <li> true、TRUE及所有 't' 或 'T' 开头的文本 </li>
     *                  <li> 首位为数字且大于数字0的文本，例如 '12'、'0ac' 等 </li>
     *              </ul>
     * @return 转换得到的boolean值。若格式不匹配则返回false。若是空字符串则返回null，交由ParamParser父类处理空值。
     */
    @Override
    public Boolean convert(String param) {
        if (param.length() == 0) {
            return null;
        }
        char c = param.charAt(0);
        for (char c1 : TRUE) {
            if (c == c1) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 空值返回true
     */
    public final static class TrueValueParser implements NullValueParser<Boolean> {
        @Override
        public Boolean parserNull() {
            return true;
        }
    }

    /**
     * 空值返回false
     */
    public final static class FalseValueParser implements NullValueParser<Boolean> {
        @Override
        public Boolean parserNull() {
            return false;
        }
    }
}