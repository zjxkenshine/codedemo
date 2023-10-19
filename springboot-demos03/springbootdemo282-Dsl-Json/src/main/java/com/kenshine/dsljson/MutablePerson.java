package com.kenshine.dsljson;

import com.dslplatform.json.JsonConverter;
import com.dslplatform.json.JsonReader;
import com.dslplatform.json.JsonWriter;

import java.io.IOException;

public class MutablePerson {

	public static class Name {
		private String value;
		public String value() { return value; }
		public static Name create(String value) {
			Name fn = new Name();
			fn.value = value;
			return fn;
		}

		//可设置为局部可变
		//反序列化实例时我们可以改变值而不是分配更多的对象
		@JsonConverter(target = Name.class)
		public static class NameConverter {
			public static void write(JsonWriter writer, Name instance) {
				writer.writeString(instance.value);
			}
			public static Name read(JsonReader reader) throws IOException {
				return Name.create(reader.readString());
			}

			public static Name bind(JsonReader reader, Name instance) throws IOException {
				if (instance == null) instance = new Name();
				instance.value = reader.readString();
				return instance;
			}
		}
	}

	public Name firstname;
	public Name surname;
	public int age;
}