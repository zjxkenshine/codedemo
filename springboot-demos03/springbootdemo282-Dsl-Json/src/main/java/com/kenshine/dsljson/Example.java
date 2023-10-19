package com.kenshine.dsljson;

import com.dslplatform.json.*;
import com.dslplatform.json.runtime.MapAnalyzer;
import com.dslplatform.json.runtime.Settings;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.*;

/**
 * @author by kenshine
 * @Classname Example
 * @Description 官方示例
 * @Date 2023-10-19 15:16
 * @modified By：
 * @version: 1.0$
 */
public class Example {

    //忽略未知属性
    @CompiledJson(onUnknown = CompiledJson.Behavior.IGNORE)
    static class Model {
        @JsonAttribute(nullable = false) // 不能为空
        public String string;
        public List<Integer> integers;
        @JsonAttribute(name = "guids") // 别名
        public UUID[] uuids;
        public Set<BigDecimal> decimals;
        public Vector<Long> longs;
        @JsonAttribute(hashMatch = false) // 可以强制精确的名称匹配，否则将使用散列值进行匹配
        public int number;
        @JsonAttribute(alternativeNames = {"old_nested", "old_nested2"}) //这几个属性可以序列化到json中
        public List<Nested> nested;
        @JsonAttribute(typeSignature = CompiledJson.TypeSignature.EXCLUDE) //从生成的JSON中排除type标识
        public Abstract abs;
        public List<Abstract> absList;
        public Interface iface;//没有反序列化的接口默认也会在JSON中包含$type属性
        public ParentClass inheritance;
        @JsonAttribute(mandatory = true)// mandatory 添加了JSON中是否存在属性的检查，即使在省略默认模式下也会序列化它
        public List<State> states;
        public JsonObjectReference jsonObject; //对象实现JsonObject管理自己的转换。它们必须以“{”开头
        public List<JsonObjectReference> jsonObjects;
        @JsonAttribute(ignore = true)
        public GregorianCalendar ignored;
        public LocalTime time; //不支持LocalTime，需要使用转换器
        public List<LocalTime> times; //即使是不支持类型的容器也会被解析
        @JsonAttribute(converter = FormatDecimal2.class)
        public BigDecimal decimal2; //自定义转换器
        public ArrayList<Integer> intList; //大多数集合运行是转换器支持
        @JsonAttribute(converter = MapAnalyzer.Runtime.class)
        public Map<String, Object> map;
        public ImmutablePerson person; //不可变对象
        public List<ViaFactory> factories; //没有可访问构造函数的对象可以通过工厂方法创建
        public PersonBuilder builder; //支持构建器模式
        public List<SpecialNumber> numbers;//具有特定值的枚举

        public MutablePerson binding = new MutablePerson();

        //显式引用的类不需要@CompiledJson注释
        public static class Nested {
            public long x;
            public double y;
            public float z;
        }

        // 反序列化Abstract会失败，因为它不包含$类型，因为它在上面的配置中被排除了
        // 指定具体类型
        @CompiledJson(deserializeAs = Concrete.class)
        public static abstract class Abstract {
            public int x;
        }

        // 因为这个类没有被显式引用，但它是作为属性使用的抽象类的扩展
        // CompiledJson声明
        @CompiledJson
        public static class Concrete extends Abstract {
            public long y;
        }

        public interface Interface {
            void x(int v);
            int x();
        }

        @CompiledJson(name = "custom-name")//by default class name will be used for $type attribute
        public static class WithCustomCtor implements Interface {
            private int x;
            private int y;

            public WithCustomCtor(int x) {
                this.x = x;
                this.y = x;
            }

            @CompiledJson
            public WithCustomCtor(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public void x(int v) { x = v; }
            public int x() { return x; }
            public void setY(int v) { y = v; }
            public int getY() { return y; }
        }

        public static class ViaFactory {
            public final String name;
            public final int num;
            private ViaFactory(String name, int num) {
                this.name = name;
                this.num = num;
            }
            //编译后的json也可以在没有tor的情况下用于工厂方法
            @CompiledJson
            public static ViaFactory create(String name, int num) {
                return new ViaFactory(name, num);
            }
        }

        public static class BaseClass {
            public int a;
        }

        public static class ParentClass extends BaseClass {
            public long b;
        }

        public enum State {
            LOW(0),
            MID(1),
            HI(2);

            private final int value;

            State(int value) {
                this.value = value;
            }
        }

        public static class JsonObjectReference implements JsonObject {

            public final int x;
            public final String s;

            JsonObjectReference(int x, String s) {
                this.x = x;
                this.s = s;
            }

            public void serialize(JsonWriter writer, boolean minimal) {
                writer.writeAscii("{\"x\":");
                NumberConverter.serialize(x, writer);
                writer.writeAscii(",\"s\":");
                StringConverter.serialize(s, writer);
                writer.writeAscii("}");
            }

            public static final JsonReader.ReadJsonObject<JsonObjectReference> JSON_READER = new JsonReader.ReadJsonObject<JsonObjectReference>() {
                public JsonObjectReference deserialize(JsonReader reader) throws IOException {
                    reader.fillName();//"x"
                    reader.getNextToken();//start number
                    int x = NumberConverter.deserializeInt(reader);
                    reader.getNextToken();//,
                    reader.getNextToken();//start name
                    reader.fillName();//"s"
                    reader.getNextToken();//start string
                    String s = StringConverter.deserialize(reader);
                    reader.getNextToken();//}
                    return new JsonObjectReference(x, s);
                }
            };
        }
        public static abstract class FormatDecimal2 {
            public static BigDecimal read(JsonReader reader) throws IOException {
                if (reader.wasNull()) return null;
                return NumberConverter.deserializeDecimal(reader).setScale(2);
            }
            public static void write(JsonWriter writer, BigDecimal value) {
                if (value == null) {
                    writer.writeNull();
                } else {
                    NumberConverter.serializeNullable(value.setScale(2), writer);
                }
            }
        }
    }

    //移动到私有包类之外，因为它在Java命名空间中引用对象
    @JsonConverter(target = LocalTime.class)
    public static abstract class LocalTimeConverter {
        public static LocalTime read(JsonReader reader) throws IOException {
            if (reader.wasNull()) return null;
            return LocalTime.parse(reader.readSimpleString());
        }
        public static void write(JsonWriter writer, LocalTime value) {
            if (value == null) {
                writer.writeNull();
            } else {
                writer.writeString(value.toString());
            }
        }
    }

    public static void main(String[] args) throws IOException {

        //启用了withrun来支持对默认情况下未注册的内容进行运行时分析
        //默认情况下，注释处理器将运行并生成JSON编码/解码的描述
        DslJson<Object> dslJson = new DslJson<>(Settings.withRuntime().allowArrayFormat(true).includeServiceLoader());
        //Writer应该被重用。对于每个线程重用使用ThreadLocal模式
        JsonWriter writer = dslJson.newWriter();

        Model instance = new Model();
        instance.string = "Hello World!";
        instance.number = 42;
        instance.integers = Arrays.asList(1, 2, 3);
        instance.decimals = new HashSet<>(Arrays.asList(BigDecimal.ONE, BigDecimal.ZERO));
        instance.uuids = new UUID[]{new UUID(1L, 2L), new UUID(3L, 4L)};
        instance.longs = new Vector<>(Arrays.asList(1L, 2L));
        instance.nested = Arrays.asList(new Model.Nested(), null);
        instance.inheritance = new Model.ParentClass();
        instance.inheritance.a = 5;
        instance.inheritance.b = 6;
        instance.iface = new Model.WithCustomCtor(5, 6);
        instance.person = new ImmutablePerson("first name", "last name", 35);
        instance.states = Arrays.asList(Model.State.HI, Model.State.LOW);
        instance.jsonObject = new Model.JsonObjectReference(43, "abcd");
        instance.jsonObjects = Collections.singletonList(new Model.JsonObjectReference(34, "dcba"));
        instance.time = LocalTime.of(12, 15);
        instance.times = Arrays.asList(null, LocalTime.of(8, 16));
        Model.Concrete concrete = new Model.Concrete();
        concrete.x = 11;
        concrete.y = 23;
        instance.abs = concrete;
        instance.absList = Arrays.<Model.Abstract>asList(concrete, null, concrete);
        instance.decimal2 = BigDecimal.TEN;
        instance.intList = new ArrayList<>(Arrays.asList(123, 456));
        instance.map = new HashMap<>();
        instance.map.put("abc", 678);
        instance.map.put("array", new int[] { 2, 4, 8});
        instance.factories = Arrays.asList(null, Model.ViaFactory.create("me", 2), Model.ViaFactory.create("you", 3), null);
        instance.builder = PersonBuilder.builder().firstName("first").lastName("last").age(42).build();
        instance.numbers = Arrays.asList(SpecialNumber.E, SpecialNumber.PI, SpecialNumber.ZERO);
        instance.binding.firstname = MutablePerson.Name.create("my name");
        instance.binding.surname = MutablePerson.Name.create("your surname");
        instance.binding.age = 99;

        dslJson.serialize(writer, instance);

        //JSON生成缓冲区
        byte[] buffer = writer.getByteBuffer();
        int size = writer.size();
        System.out.println(writer);

        //使用byte[] API进行反序列化
        Model deser = dslJson.deserialize(Model.class, buffer, size);

        System.out.println(deser.string);
    }
}
