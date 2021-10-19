package com.kenshine.jsonserial.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 8:46
 * @description：自定义序列化反序列化器
 * @modified By：
 * @version: 1.0$
 *
 * 使用@JsonComponent注释会自动被注册到Jackson中.
 *
 *
 * 常用json注解
 * @JsonIgnoreProperties    此注解是类注解，作用是在json序列化时将Java bean中的某些属性忽略掉，序列化和反序列化都受影响。
 * @JsonIgnore  此注解用于属性或者方法上(最好是属性上)，作用和上面的@JsonIgnoreProperties一样
 * @JsonFormat  此注解用于属性或者方法上（最好是属性上)，可以方便的把Date类型直接转化为我们想要的模式
 * @JsonSerialize   此注解用于属性或者getter方法上，用于在序列化时嵌入我们自定义的序列化器，比如序列化一个double时在其后面限制两位小数点
 * @JsonDeserialize 此注解用于属性或者setter方法上，用于在反序列化时嵌入我们自定义的反序列化器，比如反序列化一个Date类型的时间字符串
 * @JsonCreator与@JsonProperty   该注解的作用就是指定反序列化时替代无参构造函数，构造方法的参数前面需要加上@JsonProperty注解
 */
@JsonComponent
public class CustomJackSon {

    /**
     * 自定义序列化器,格式化数值Decimal
     */
    public static class MySerializer extends JsonSerializer<Double> {

        private DecimalFormat df = new DecimalFormat("##.00");

        /**
         * 序列化操作,继承JsonSerializer，重写Serialize函数
         */
        @Override
        public void serialize(Double value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(df.format(value));
        }
    }

    /**
     * 自定义反序列化器,格式化时间
     */
    public static class MyDeserializer extends JsonDeserializer<Date> {

        private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Date date = null;
            try {
                date = sdf.parse(jsonParser.getText());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }
    }

}
