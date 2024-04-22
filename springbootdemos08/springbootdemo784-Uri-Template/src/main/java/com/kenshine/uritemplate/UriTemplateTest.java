package com.kenshine.uritemplate;

import com.github.fge.uritemplate.URITemplate;
import com.github.fge.uritemplate.URITemplateException;
import com.github.fge.uritemplate.URITemplateParseException;
import com.github.fge.uritemplate.vars.VariableMap;
import com.github.fge.uritemplate.vars.VariableMapBuilder;
import com.github.fge.uritemplate.vars.values.MapValue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname UriTemplateTest
 * @Description UriTemplate使用测试
 * @Date 2024-04-22 8:41
 * @modified By：
 * @version: 1.0$
 */
public class UriTemplateTest {

    public static void main(String[] args) throws URITemplateException, URISyntaxException, MalformedURLException {
        VariableMapBuilder builder = VariableMap.newBuilder();

        // 添加scalar值
        builder.addScalarValue("scalar", "hello");

        // 创建list
        builder.addListValue("list", "one", 2, "three");

        // Create a map value
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        builder.addMapValue("map", map);

        // 创建VariableMap
        VariableMap vars = builder.freeze();

        // 设置模板
        URITemplate template = new URITemplate("http://foo.bar/myPage{?map*}");

        // 转换为String
        String str=template.toString(vars);
        System.out.println("转String="+str);
        URI uri=template.toURI(vars);
        System.out.println("转URI="+uri);
        URL url=template.toURL(vars);
        System.out.println("转URL="+url);
    }
}
