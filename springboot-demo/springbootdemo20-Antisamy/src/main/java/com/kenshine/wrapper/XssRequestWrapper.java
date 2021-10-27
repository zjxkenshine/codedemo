package com.kenshine.wrapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.owasp.validator.html.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Objects;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 8:32
 * @description：请求包装类
 * @modified By：
 * @version: $
 */
public class XssRequestWrapper extends HttpServletRequestWrapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(XssRequestWrapper.class);
    private static Policy policy = null;

    static {
        try {
            // 获取策略文件路径，策略文件需要放到项目的classpath下
            String antiSamyPath = Objects
                    .requireNonNull(XssRequestWrapper.class.getClassLoader().getResource("antisamy-ebay.xml")).getFile();
            LOGGER.info(antiSamyPath);
            // 获取的文件路径中有空格时，空格会被替换为%20，在new一个File对象时会出现找不到路径的错误
            // 对路径进行解码以解决该问题
            antiSamyPath = URLDecoder.decode(antiSamyPath, "utf-8");
            LOGGER.info(antiSamyPath);
            // 指定策略文件
            policy = Policy.getInstance(antiSamyPath);
        } catch (UnsupportedEncodingException | PolicyException e) {
            e.printStackTrace();
        }
    }

    public XssRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /**
     * 过滤请求头
     *
     * @param name 参数名
     * @return 参数值
     */
    @Override
    public String getHeader(String name) {
        String header = super.getHeader(name);
        // 如果Header为空，则直接返回，否则进行清洗
        return StringUtils.isBlank(header) ? header : xssClean(header);
    }

    /**
     * 过滤请求参数
     *
     * @param name 参数名
     * @return 参数值
     */
    @Override
    public String getParameter(String name) {
        String parameter = super.getParameter(name);
        // 如果Parameter为空，则直接返回，否则进行清洗
        return StringUtils.isBlank(parameter) ? parameter : xssClean(parameter);
    }

    /**
     * 过滤请求参数（一个参数可以有多个值）
     *
     * @param name 参数名
     * @return 参数值数组
     */
    @Override
    public String[] getParameterValues(String name) {
        String[] parameterValues = super.getParameterValues(name);
        if (parameterValues != null) {
            int length = parameterValues.length;
            String[] newParameterValues = new String[length];
            for (int i = 0; i < length; i++) {
                LOGGER.info("AntiSamy清理之前的参数值：" + parameterValues[i]);
                // 清洗参数
                newParameterValues[i] = xssClean(parameterValues[i]);
                LOGGER.info("AntiSamy清理之后的参数值：" + newParameterValues[i]);
            }
            return newParameterValues;
        }
        return super.getParameterValues(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> requestMap = super.getParameterMap();
        requestMap.forEach((key, value) -> {
            for (int i = 0; i < value.length; i++) {
                LOGGER.info(value[i]);
                value[i] = xssClean(value[i]);
                LOGGER.info(value[i]);
            }
        });
        return requestMap;
    }

    /**
     * 使用AntiSamy清洗数据
     *
     * @param value 需要清洗的数据
     * @return 清洗后的数据
     */
    private String xssClean(String value) {
        try {
            AntiSamy antiSamy = new AntiSamy();
            // 使用AntiSamy清洗数据
            final CleanResults cleanResults = antiSamy.scan(value, policy);
            // 获得安全的HTML输出
            value = cleanResults.getCleanHTML();
            // 对转义的HTML特殊字符（<、>、"等）进行反转义，因为AntiSamy调用scan方法时会将特殊字符转义
            return StringEscapeUtils.unescapeHtml4(value);
        } catch (ScanException | PolicyException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 通过修改Json序列化的方式来完成Json格式的XSS过滤
     */
    public static class XssStringJsonSerializer extends JsonSerializer<String> {

        @Override
        public Class<String> handledType() {
            return String.class;
        }

        @Override
        public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            if (!StringUtils.isBlank(value)) {
                try {
                    AntiSamy antiSamy = new AntiSamy();
                    final CleanResults cleanResults = antiSamy.scan(value, XssRequestWrapper.policy);
                    gen.writeString(StringEscapeUtils.unescapeHtml4(cleanResults.getCleanHTML()));
                } catch (ScanException | PolicyException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
